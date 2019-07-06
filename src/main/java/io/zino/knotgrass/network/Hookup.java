package io.zino.knotgrass.network;

import io.grpc.stub.StreamObserver;
import io.zino.network.Network;
import io.zino.network.NetworkServiceGrpc.NetworkServiceImplBase;

public class Hookup extends NetworkServiceImplBase {

    public Hookup(NetworkHandler dana) {
        //todo
    }

    @Override
    public StreamObserver<Network.ChatMessage> chat(StreamObserver<Network.ChatMessageFromServer> responseObserver) {
        return super.chat(responseObserver);
    }
}
