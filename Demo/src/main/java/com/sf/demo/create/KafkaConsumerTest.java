package com.sf.demo.create;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        // 定义kakfa 服务的地址，不需要将所有broker指定上
        props.put("bootstrap.servers", "10.23.21.27:9092");
        // 制定consumer group
        props.put("group.id", "test");
        // 是否自动确认offset
        props.put("enable.auto.commit", "true");
        // 自动确认offset的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        // key的序列化类
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // value的序列化类
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        //定义consumer
        KafkaConsumer consumer = new KafkaConsumer<>(props);


        //消费者订阅的topic，可同时订阅多个
        consumer.subscribe(Arrays.asList("first","second","third"));


        while(true){
            //读取数据，读取超时时间为100ms
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofSeconds(100));


            for(ConsumerRecord<String,String> record:records){
                System.out.printf("offset = %d, key = %s, valu" +
                        "e = %s%n", record.offset(), record.key(), record.value());
            }


        }


    }

}
