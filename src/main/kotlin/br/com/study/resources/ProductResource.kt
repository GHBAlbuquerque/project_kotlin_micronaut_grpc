package br.com.study.resources

import br.com.study.ProductServiceReply
import br.com.study.ProductServiceRequest
import br.com.study.ProductServiceServiceGrpc
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResource : ProductServiceServiceGrpc.ProductServiceServiceImplBase() {
    override fun send(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceReply>?) {

        val toSend = "Hello, ${request?.name}"

        val reply = ProductServiceReply.newBuilder()
            .setMessage(toSend)
            .build()

        responseObserver?.onNext(reply)
        responseObserver?.onCompleted()
    }
}


