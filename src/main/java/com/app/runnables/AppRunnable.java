package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppRunnable {
	
	public static void main(String[] args) {
		Runnable runnable =()->{
			
			try(BufferedReader reader = new BufferedReader(new FileReader(new File("G:\\Concurrency-MultiThread\\sample.txt")))){
				
				String line = null;
				
				while((line=reader.readLine())!=null) {
					System.out.println(Thread.currentThread().getName()+" reading the line: "+line);
				}
			} catch (FileNotFoundException e) {
				Logger.getLogger(AppThreads.class.getName()).log(Level.SEVERE, null, e);
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (IOException e) {
				Logger.getLogger(AppThreads.class.getName()).log(Level.SEVERE, null, e);
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(runnable);
	}
	

}
