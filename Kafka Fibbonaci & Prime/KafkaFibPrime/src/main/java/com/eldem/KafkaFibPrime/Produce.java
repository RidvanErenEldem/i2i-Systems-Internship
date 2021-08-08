package com.eldem.KafkaFibPrime;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Produce {

	public static void main(String[] args) {
		Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
		properties.put("acks", "all");
		properties.put("retries", 0);
        properties.put("batch.size", 16384);
		properties.put("linger.ms", 1);
		properties.put("buffer.memory", 33554432);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		try{ 
			 producer.send(new ProducerRecord<String, String>("kafkaExample", "firstKey", "2,fib"));
			 producer.send(new ProducerRecord<String, String>("kafkaExample", "firstKey", "5,fib"));
			 producer.send(new ProducerRecord<String, String>("kafkaExample", "firstKey", "11,fib"));
			 producer.send(new ProducerRecord<String, String>("kafkaExample", "firstKey", "13,fib"));
			 producer.send(new ProducerRecord<String, String>("kafkaExample", "firstKey", "602,fib"));
		 }
		finally {
			if(producer != null)
				producer.close();
		}
    }
}

