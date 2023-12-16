package com.capimgrosso.azure;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        int seconds = 30;
        System.out.println( "Hello World!" );
        log("--- Waiting process to finish ---");
        Thread.sleep(1000L * seconds);
        log("--- Job finished ---");
    }

    private static void log(String s){
        System.out.println("" + LocalDateTime.now() + " " + s);
    }
}
