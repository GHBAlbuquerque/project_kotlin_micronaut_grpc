package br.com.study.utils

import br.com.study.CreateProductServiceRequest
import br.com.study.UpdateProductServiceRequest
import br.com.study.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ValidationUtilTest {

    @Test
    fun `when validatePayload (Create) method is called with valid data, should not throw exception`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Guaraná")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        Assertions.assertDoesNotThrow()
        {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Create) method is called with invalid name, should throw exception`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Create) method is called with invalid price, should throw exception`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Product")
            .setPrice(-7.0)
            .setQuantityInStock(5)
            .build();

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Create) method is called with invalid quantity in stock, should throw exception`() {
        val request = CreateProductServiceRequest.newBuilder()
            .setName("Product")
            .setPrice(7.0)
            .setQuantityInStock(-8)
            .build();

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Create) method is called with a null payload, should throw exception`() {
        val request : CreateProductServiceRequest? = null

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }


    @Test
    fun `when validatePayload (Update) method is called with valid data, should not throw exception`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(1)
            .setName("Guaraná")
            .setPrice(9.99)
            .setQuantityInStock(5)
            .build();

        Assertions.assertDoesNotThrow()
        {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Update) method is called with invalid price, should throw exception`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(1)
            .setPrice(-7.0)
            .build();

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Update) method is called with invalid quantity in stock, should throw exception`() {
        val request = UpdateProductServiceRequest.newBuilder()
            .setId(1)
            .setQuantityInStock(-8)
            .build();

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }

    @Test
    fun `when validatePayload (Update) method is called with a null payload, should throw exception`() {
        val request : UpdateProductServiceRequest? = null

        Assertions.assertThrowsExactly(
            InvalidArgumentException::class.java
        ) {
            ValidationUtil.isValidPayload(request)
        }
    }
}