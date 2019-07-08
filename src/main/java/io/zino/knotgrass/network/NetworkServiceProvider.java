package io.zino.knotgrass.network;

import io.grpc.stub.StreamObserver;
import io.zino.network.Network;
import io.zino.network.NetworkServiceGrpc.NetworkServiceImplBase;

public class NetworkServiceProvider extends NetworkServiceImplBase {

    public NetworkServiceProvider(NetworkHandler dana) {
        //todo
    }

    @Override
    public void publishTransaction(Network.PublishTransactionRequest request, StreamObserver<Network.PublishTransactionResponse> responseObserver) {
        //todo
        super.publishTransaction(request, responseObserver);
    }

    @Override
    public void publishBlock(Network.PublishBlockRequest request, StreamObserver<Network.PublishBlockResponse> responseObserver) {
        //todo
        super.publishBlock(request, responseObserver);
    }
}
