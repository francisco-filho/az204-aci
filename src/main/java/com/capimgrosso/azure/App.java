package com.capimgrosso.azure;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws InterruptedException {
        var app = new App();
        app.listBlobs();
    }

    public void listBlobs(){
        String endpoint = "https://az204cg.blob.core.windows.net/";
        DefaultAzureCredential cred = new DefaultAzureCredentialBuilder().build();

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint(endpoint)
                .credential(cred)
                .buildClient();

        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("teste");

        blobContainerClient.listBlobs()
                .forEach(b -> System.out.println(b.getName()));
    }


    private static void justSleep() throws InterruptedException {
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
