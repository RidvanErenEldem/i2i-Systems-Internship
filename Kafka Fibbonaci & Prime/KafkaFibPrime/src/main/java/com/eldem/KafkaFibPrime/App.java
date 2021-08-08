package com.eldem.KafkaFibPrime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
public class App 
{
	private ExecutorService executorService;
	
	public App(int pool)
	{
		executorService = Executors.newFixedThreadPool(pool);
	}
	
	public void submit(Runnable task)
	{
		executorService.submit(task);
	}
	
	public void shutDown()
	{
		executorService.shutdown();
	}

    public static void main( String[] args )
    {
    	LinkedBlockingQueue<NumOp> extractedMessages = new LinkedBlockingQueue<NumOp>();
    	final String topic = "kafkaExample";
    	final int poolSize = 2;
    	
    	Runnable messageProcessor = new Processor(extractedMessages);
    	Runnable kafkaConsumer = new Consumer(topic,extractedMessages);
    	
    	App app = new App(poolSize);
    	
    	app.submit(kafkaConsumer);
    	app.submit(messageProcessor);
    	app.shutDownHook();
    }
    
    private void shutDownHook()
    {
    	Runtime.getRuntime().addShutdownHook(new Thread() 
    	{
    		public void run()
    		{
    			shutDown();
    		}
    	});
    }
}
