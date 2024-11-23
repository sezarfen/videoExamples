package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaExampleProducer {
    public static void main(String[] args) {
        String topic = "example-topic";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        try{
            for (int i = 0; i < 10; i++) {
                String message = "Message " + i;
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Sent: " + message + " to partititon " + metadata.partition() + " with offset " + metadata.offset());
            }
        }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }finally {
            producer.close();
        }
    }
}


