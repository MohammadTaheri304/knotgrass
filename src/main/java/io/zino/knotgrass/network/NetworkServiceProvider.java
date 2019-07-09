package io.zino.knotgrass.network;

import io.grpc.stub.StreamObserver;

public class NetworkServiceProvider extends NetworkServiceGrpc.NetworkServiceImplBase {

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
