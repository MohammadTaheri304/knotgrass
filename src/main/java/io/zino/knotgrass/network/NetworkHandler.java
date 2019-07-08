package io.zino.knotgrass.network;

import com.google.common.eventbus.Subscribe;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.zino.knotgrass.Context;

import java.io.IOException;

public class NetworkHandler {


    public static class PublishTransactionRequest {
    }

    public NetworkHandler(Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server server = ServerBuilder.forPort(8080)
                            .addService(new Hookup(NetworkHandler.this)).build();
                    System.out.println("Starting server...");
                    server.start();
                    System.out.println("Server started!");
                    server.awaitTermination();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Subscribe
    public void handle(PublishTransactionRequest request) {
        System.out.println("ooooooooooooh");
    }
}
