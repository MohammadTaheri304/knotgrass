package io.zino.knotgrass.network;

import com.google.common.eventbus.Subscribe;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.zino.knotgrass.Context;
import io.zino.knotgrass.network.request.PublishBlockRequest;
import io.zino.knotgrass.network.request.PublishTransactionRequest;

import java.io.IOException;

public class NetworkHandler {

    private final NetworkServiceConsumer networkServiceConsumer;

    public NetworkHandler(Context context) {
        final Integer serverPort = context.getServerPort();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server server = ServerBuilder.forPort(serverPort)
                            .addService(new NetworkServiceProvider(NetworkHandler.this)).build();
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

        this.networkServiceConsumer = new NetworkServiceConsumer(this);
    }

    @Subscribe
    public void handle(PublishTransactionRequest request) {
        this.networkServiceConsumer.publishTransactionToNetwork(request.getTransactionDO());
    }

    @Subscribe
    public void handle(PublishBlockRequest request) {
        this.networkServiceConsumer.publishBlockToNetwork(request.getBlockDO());
    }
}
