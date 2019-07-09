package io.zino.knotgrass.network;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.zino.knotgrass.domain.BlockDO;
import io.zino.knotgrass.domain.TransactionDO;

import java.util.ArrayList;
import java.util.List;

public class NetworkServiceConsumer {

    // make a client to call other servers
    private final List<NetworkServiceGrpc.NetworkServiceFutureStub> stubs;

    public NetworkServiceConsumer(NetworkHandler dana) {
        //todo set the servers set
        this.stubs = prepareStubs();
    }

    private List<NetworkServiceGrpc.NetworkServiceFutureStub> prepareStubs() {
        List<NetworkServiceGrpc.NetworkServiceFutureStub> stubs = new ArrayList<>();

        // todo do for all servers
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        NetworkServiceGrpc.NetworkServiceFutureStub stub
                = NetworkServiceGrpc.newFutureStub(channel);
        stubs.add(stub);

        return stubs;
    }

    public void publishBlockToNetwork(BlockDO blockDO) {
        //todo prepare correct request
        Network.PublishBlockRequest request = Network.PublishBlockRequest.newBuilder().build();
        stubs.parallelStream().forEach(stub -> stub.publishBlock(request));
    }

    public void publishTransactionToNetwork(TransactionDO transactionDO) {
        //todo prepare correct request
        Network.PublishTransactionRequest request = Network.PublishTransactionRequest.newBuilder().build();
        stubs.parallelStream().forEach(stub -> stub.publishTransaction(request));
    }
}
