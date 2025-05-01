package br.com.study.utils

import br.com.study.domain.Product
import br.com.study.dto.CreateProductReq
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProductConverterUtilTest {

    @Test
    fun `when toResponse method is called, should return a ProductRes with all data`() {
        val product = Product(id=1, name= "Guaraná", price = 9.99, quantityInStock = 5)
        val response = product.toResponse()

        Assertions.assertEquals(product.id, response.id)
        Assertions.assertEquals(product.name, response.name)
        Assertions.assertEquals(product.price, response.price)
        Assertions.assertEquals(product.quantityInStock, response.quantityInStock)
    }

    @Test
    fun `when toRequest method is called, should return a ProductReq without id`() {
        val product = Product(id=1, name= "Guaraná", price = 9.99, quantityInStock = 5)
        val request = product.toRequest()

        Assertions.assertEquals(product.name, request.name)
        Assertions.assertEquals(product.price, request.price)
        Assertions.assertEquals(product.quantityInStock, request.quantityInStock)
    }

    @Test
    fun `when toDomain method is called, should return a Product without id`() {
        val request = CreateProductReq(name= "Guaraná", price = 9.99, quantityInStock = 5)
        val product = request.toDomain()

        Assertions.assertEquals(null, product.id)
        Assertions.assertEquals(request.name, product.name)
        Assertions.assertEquals(request.price, product.price)
        Assertions.assertEquals(request.quantityInStock, product.quantityInStock)
    }
}