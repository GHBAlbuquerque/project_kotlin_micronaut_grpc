package br.com.study.resources

import br.com.study.CreateProductServiceRequest
import br.com.study.ProductsServiceGrpc.ProductsServiceBlockingStub
import io.grpc.StatusRuntimeException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
internal class ProductResourcesTestIT(
    private val productsServiceBlockingStub: ProductsServiceBlockingStub
) {

    @Test
    fun `when ProductsServiceGrpc create method is called with valid data a success message is returned`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Guaraná")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = productsServiceBlockingStub.create(request)

        Assertions.assertEquals(1, response.id)
        Assertions.assertEquals("Guaraná", response.name)
    }

    @Test
    fun `when ProductsServiceGrpc create method is called with invalid data a error message is returned`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.create(request)
        }
    }
}