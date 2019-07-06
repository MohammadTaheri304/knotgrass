package io.zino.knotgrass.network;

import com.google.common.eventbus.Subscribe;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public enum NetworkHandler {
    INSTANCE;

    public static class PublishTransactionRequest {
    }

    NetworkHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    Server server = ServerBuilder.forPort(8080)
                            .addService(new Hookup(this)).build();
                    System.out.println("Starting server...");
                    server.start();
                    System.out.println("Server started!");
                    server.awaitTermination();
                    System.out.println("hi");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Subscribe
    public void handle(PublishTransactionRequest request) {
        System.out.println("ooooooooooooh");
    }
}
