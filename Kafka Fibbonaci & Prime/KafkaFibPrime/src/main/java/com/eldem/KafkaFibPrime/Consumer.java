package com.eldem.KafkaFibPrime;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer implements Runnable {
	
	private LinkedBlockingQueue<NumOp> extractedMessages;
	private String topic;
	
	public Consumer(String topic, LinkedBlockingQueue<NumOp> extractedMessages) {
		this.extractedMessages = extractedMessages;
		this.topic = topic;
	}

	@Override
	public void run() {
		getMessageFromTopic();
	}
	
	private void getMessageFromTopic()
	{
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("group.id", "test");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		consumer.subscribe(Arrays.asList(topic));
		
		while(true)
		{
			 ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
	         for (ConsumerRecord<String, String> record : records) {
	        	 final int numberIndex = 0;
	        	 final int opIndex = 1;
	        	 
	             String[] numOpString = record.value().split(",");
	             try {
					extractedMessages.put(new NumOp(
					    		 numOpString[numberIndex],
					    		 numOpString[opIndex]
							 ));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					consumer.close();
					break;
				}
	         }
		}
	}
	
}
class NumOp{
	private int number;
	private String op;
	
	public NumOp(String number, String op) {
		this.number = Integer.parseInt(number);
		this.op = op;
	}

	public int getNumber() {
		return number;
	}

	public String getOp() {
		return op;
	}
}

