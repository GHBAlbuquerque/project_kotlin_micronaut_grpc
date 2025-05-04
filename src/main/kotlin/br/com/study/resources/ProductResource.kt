package br.com.study.resources

import br.com.study.*
import br.com.study.dto.CreateProductReq
import br.com.study.dto.UpdateProductReq
import br.com.study.services.ProductService
import br.com.study.utils.ValidationUtil
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductResource(private val productService: ProductService) : ProductsServiceGrpc.ProductsServiceImplBase() {
    // works like a controller in a REST API

    override fun create(
        request: CreateProductServiceRequest?,
        responseObserver: StreamObserver<ProductServiceResponse>?
    ) {
        val payload = ValidationUtil.isValidPayload(request)
        val createProductReq =
            CreateProductReq(name = payload.name, price = payload.price, quantityInStock = payload.quantityInStock)

        val productRes = productService.create(createProductReq)
        val response = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(response) // Send the response
        responseObserver?.onCompleted() // Complete the call
    }

    override fun findById(
        request: RequestByIdServiceRequest,
        responseObserver: StreamObserver<ProductServiceResponse>?
    ) {
        val productRes = productService.findById(request.id)
        val response = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun update(
        request: UpdateProductServiceRequest?,
        responseObserver: StreamObserver<ProductServiceResponse>?
    ) {
        val payload = ValidationUtil.isValidPayload(request);
        val updateProductReq =
            UpdateProductReq(
                id = payload.id,
                name = payload.name,
                price = payload.price,
                quantityInStock = payload.quantityInStock
            )

        val productRes = productService.update(updateProductReq)
        val response = ProductServiceResponse.newBuilder()
            .setId(productRes.id)
            .setName(productRes.name)
            .setPrice(productRes.price)
            .setQuantityInStock(productRes.quantityInStock)
            .build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun delete(
        request: RequestByIdServiceRequest,
        responseObserver: StreamObserver<Empty>?
    ) {
        productService.delete(request.id)
        val response = Empty.newBuilder().build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }

    override fun findAll(
        request: Empty?,
        responseObserver: StreamObserver<ProductsList>?
    ) {
        val productList = productService.findAll()

        val responseList = productList.map {
            ProductServiceResponse.newBuilder()
                .setId(it.id)
                .setName(it.name)
                .setPrice(it.price)
                .setQuantityInStock(it.quantityInStock)
                .build()
        }

        val response = ProductsList.newBuilder()
            .addAllProducts(responseList)
            .build()

        responseObserver?.onNext(response)
        responseObserver?.onCompleted()
    }
}


