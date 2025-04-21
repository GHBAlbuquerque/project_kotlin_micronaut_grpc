package br.com.study.resources

import br.com.study.ProductServiceRequest
import br.com.study.ProductServiceResponse
import br.com.study.ProductsServiceGrpc
import br.com.study.dto.ProductReq
import br.com.study.services.ProductService
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResource(private val productService: ProductService) : ProductsServiceGrpc.ProductsServiceImplBase() {

    override fun create(request: ProductServiceRequest?, responseObserver: StreamObserver<ProductServiceResponse>?) {
        val productReq = ProductReq(name = request!!.name, price = request.price, quantityInStock = request.quantityInStock)

        val productRes = productService.create(productReq)
        val response = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(response) // Send the response
        responseObserver?.onCompleted() // Complete the call
    }
}


