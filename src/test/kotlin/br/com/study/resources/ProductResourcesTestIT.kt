package br.com.study.resources

import br.com.study.CreateProductServiceRequest
import br.com.study.Empty
import br.com.study.ProductsServiceGrpc.ProductsServiceBlockingStub
import br.com.study.RequestByIdServiceRequest
import br.com.study.UpdateProductServiceRequest
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer
import org.mockito.Mockito

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class ProductResourcesTestIT(
    private val flyway: Flyway,
    private val productsServiceBlockingStub: ProductsServiceBlockingStub
) {

    @BeforeEach
    fun setup(){
        //flyway.clean()
        flyway.migrate()
    }

    @Test
    @Order(1)
    fun `when ProductsServiceGrpc create method is called with valid data, a success message is returned`() {
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
    @Order(2)
    fun `when ProductsServiceGrpc create method is called with invalid data, an error message is returned`() {
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
    @Order(3)
    fun `when ProductsServiceGrpc create method is called with duplicate name, an error message is returned`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Product B")
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
    @Order(4)
    fun `when ProductsServiceGrpc findById method is called with valid id, a success message is returned`() {
        val request = RequestByIdServiceRequest.newBuilder().setId(1L).build();

        val response = productsServiceBlockingStub.findById(request)

        Assertions.assertEquals(1, response.id)
        Assertions.assertEquals("Product A", response.name)
    }

    @Test
    @Order(5)
    fun `when ProductsServiceGrpc findById method is called with invalid id, an error message is returned`() {
        val request = RequestByIdServiceRequest.newBuilder().setId(100L).build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.findById(request)
        }

        Assertions.assertEquals(Status.NOT_FOUND.code, response.status.code)
    }

    @Test
    @Order(6)
    fun `when ProductsServiceGrpc update method is called with valid data, a success message is returned`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(5L)
            .setName("Tubaína")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = productsServiceBlockingStub.update(request)

        Assertions.assertEquals(5L, response.id)
        Assertions.assertEquals("Tubaína", response.name)
    }

    @Test
    @Order(7)
    fun `when ProductsServiceGrpc update method is called with invalid data, an error message is returned`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(1L)
            .setName("")
            .setPrice(-1.00)
            .setQuantityInStock(5)
            .build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.update(request)
        }
    }

    @Test
    @Order(8)
    fun `when ProductsServiceGrpc update method is called with duplicate name, an error message is returned`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(6L)
            .setName("Product A")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.update(request)
        }

        Assertions.assertEquals(Status.ALREADY_EXISTS.code, response.status.code)
    }

    @Test
    @Order(9)
    fun `when ProductsServiceGrpc update method is called with non-existant product, an error message is returned`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(16L)
            .setName("Sprite")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.update(request)
        }

        Assertions.assertEquals(Status.NOT_FOUND.code, response.status.code)
    }

    @Test
    @Order(10)
    fun `when ProductsServiceGrpc delete method is called with valid id, a success message is returned`() {
        val request = RequestByIdServiceRequest.newBuilder().setId(1L).build();

        Assertions.assertDoesNotThrow {
            productsServiceBlockingStub.delete(request)
        }
    }

    @Test
    @Order(11)
    fun `when ProductsServiceGrpc delete method is called with invalid id, an error message is returned`() {
        val request = RequestByIdServiceRequest.newBuilder().setId(100L).build();

        val response = Assertions.assertThrows(
            StatusRuntimeException::class.java
        ) {
            productsServiceBlockingStub.delete(request)
        }

        Assertions.assertEquals(Status.NOT_FOUND.code, response.status.code)
    }

    @Test
    @Order(12)
    fun `when ProductsServiceGrpc findAll method is called, a success message is returned`() {
        val request = Empty.newBuilder().build();

        val response = productsServiceBlockingStub.findAll(request)

        Assertions.assertTrue(response.productsList.isNotEmpty())
    }




}