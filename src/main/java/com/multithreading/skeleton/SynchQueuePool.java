package com.multithreading.skeleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchQueuePool {
    static SynchronousQueue<String> syn= new SynchronousQueue<String>();

    public static void main(String[] args) throws InterruptedException {
            ExecutorService exServ=Executors.newFixedThreadPool(2);
            Runnable prod = new Runnable() {

                public void run() {
                   try {
                       syn.put("myString");
                   }catch(InterruptedException ex) {
                       ex.printStackTrace();
                      
                   }
                    
                }
                
            };
            Runnable consum = new Runnable() {
                public void run() {
                   try {
                      System.out.println(Thread.currentThread()+" "+ syn.take());
                   }catch(InterruptedException ex) {
                       ex.printStackTrace();
                      
                   }
                    
                }
                
            };
            exServ.submit(prod);
            exServ.submit(consum);
            exServ.awaitTermination(10, TimeUnit.SECONDS);
            exServ.shutdown();
            
    }

}
