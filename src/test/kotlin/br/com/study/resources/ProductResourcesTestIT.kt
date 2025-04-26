package br.com.study.resources

import br.com.study.CreateProductServiceRequest
import br.com.study.FindProductByIdServiceRequest
import br.com.study.ProductsServiceGrpc.ProductsServiceBlockingStub
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions;
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

        Assertions.assertEquals(6, response.id)
        Assertions.assertEquals("Guaraná", response.name)
    }

    @Test
    fun `when ProductsServiceGrpc create method is called with invalid data an error message is returned`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.create(request)
        }
    }

    @Test
    fun `when ProductsServiceGrpc create method is called with duplicate name an error message is returned`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Product A")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.create(request)
        }

        Assertions.assertEquals(Status.ALREADY_EXISTS.code, response.status.code)
    }

    @Test
    fun `when ProductsServiceGrpc findById method is called with valid id a success message is returned`() {
        val request = FindProductByIdServiceRequest.newBuilder().setId(1L).build();

        val response = productsServiceBlockingStub.findById(request)

        Assertions.assertEquals(1, response.id)
        Assertions.assertEquals("Product A", response.name)
    }

    @Test
    fun `when ProductsServiceGrpc findById method is called with invalid id an error message is returned`() {
        val request = FindProductByIdServiceRequest.newBuilder().setId(100L).build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.findById(request)
        }

        Assertions.assertEquals(Status.NOT_FOUND.code, response.status.code)
    }
}