package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.example.Entities.Student;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaExampleConsumer {
    public static void main(String[] args) {
        String topic = "example-topic";

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put("group.id", "example-group");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        try (consumer) {
            consumer.subscribe(Collections.singletonList(topic));
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("Subscribed to topic: " + topic);
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                if (records.isEmpty()) {
                    System.out.println("No messages found...");
                }
                records.forEach(record -> {
                    try {
                        Student newStudent = objectMapper.readValue(record.value(), Student.class);
                        System.out.println(newStudent);
                    } catch (com.fasterxml.jackson.core.JsonProcessingException exc) {
                        exc.printStackTrace();
                    }
                });
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}