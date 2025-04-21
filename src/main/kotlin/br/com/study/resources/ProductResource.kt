package br.com.study.resources

import br.com.study.ProductServiceRequest
import br.com.study.ProductServiceResponse
import br.com.study.ProductServiceServiceGrpc
import br.com.study.services.ProductService
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResource(private val productService: ProductService) : ProductServiceServiceGrpc.ProductServiceServiceImplBase() {

    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {

        val toSend = "Hello, ${request?.name}"

        val reply = ProductServiceResponse.newBuilder()
            .setMessage(toSend)
            .build()

        responseObserver?.onNext(reply)
        responseObserver?.onCompleted()
    }
}


