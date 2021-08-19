package com.uni.demo.create;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class KafkaProducerTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.23.21.27:9092");
        props.put("acks", "0");
        props.put("retries", 0);
//        props.put("batch.size", 16384);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer producer = new KafkaProducer(props);
        //正常发送消息的producer
        ProducerRecord<String, String> record = new ProducerRecord<>("first", "333");
        //带key的producer
//        ProducerRecord<String, String> record = new ProducerRecord<>("first","key", "3312333");
        //指定分区的producer
//        ProducerRecord<String, String> record = new ProducerRecord<>("first",0,"key", "lover");
        producer.send(record);
        producer.close();
    }

}
