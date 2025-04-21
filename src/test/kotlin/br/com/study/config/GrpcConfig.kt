package br.com.study.config

import br.com.study.ProductsServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel

@Factory // Factory class to create gRPC beans
class GrpcConfig {

    @Bean
    fun productServiceBean(
        @GrpcChannel("productservice") channel: ManagedChannel // ManagedChannel for gRPC communication from application-test.yml
    ): ProductsServiceGrpc.ProductsServiceBlockingStub { // Blocking Stub for synchronous calls
        return ProductsServiceGrpc.newBlockingStub(channel) // Create a new blocking stub using the channel
    }
}