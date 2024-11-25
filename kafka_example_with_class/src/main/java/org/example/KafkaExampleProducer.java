package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.example.Entities.Student;

import java.util.Properties;

public class KafkaExampleProducer {
    public static void main(String[] args) {
        String topic = "example-topic";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < 10; i++) {
                Student student = new Student(i, "Student " + i);
                try {
                    String mappedObject = objectMapper.writeValueAsString(student);
                    ProducerRecord<String, String> record = new ProducerRecord<>(topic, mappedObject);
                    RecordMetadata metadata = producer.send(record).get();
                    System.out.println("Sent: " + mappedObject + " to partition " + metadata.partition() + " with offset " + metadata.offset());
                } catch (com.fasterxml.jackson.core.JsonProcessingException exc) {
                    exc.printStackTrace();
                }
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}


