package br.com.study.service.impl

import br.com.study.domain.Product
import br.com.study.dto.ProductReq
import br.com.study.exceptions.AlreadyExistsException
import br.com.study.exceptions.ProductNotFoundException
import br.com.study.repositories.ProductRepository
import br.com.study.services.impl.ProductServiceImpl
import br.com.study.utils.toRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.util.*

internal class ProductServiceImplTest {

    private val productRepository = Mockito.mock(ProductRepository::class.java)
    private val productService = ProductServiceImpl(productRepository)

    @Test
    fun `when create method is called with valid data, should create a product`() {
        val productInput = Product(id = null, name = "Product 1", price = 10.0, quantityInStock = 2)
        val product = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.save(productInput))
            .thenReturn(product)

        val result = productService.create(productInput.toRequest())

        assert(productInput.name == result.name)
    }

    @Test
    fun `when create method is called with duplicate product name should throw AlreadyExistsException`() {
        val productInput = Product(id = null, name = "Product 1", price = 10.0, quantityInStock = 2)
        val product = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.findByNameIgnoreCase(productInput.name))
            .thenReturn(product)

        Assertions.assertThrowsExactly(
            AlreadyExistsException::class.java
        ) {
            productService.create(productInput.toRequest())
        }
    }

    @Test
    fun `when findbyID method is called with valid ID, should return a product`() {
        val productId = 1L
        val product = Product(id = productId, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.findById(productId))
            .thenReturn(Optional.of(product))

        val result = productService.findById(productId)

        assert(productId == result.id)
    }

    @Test
    fun `when findbyID method is called with non-existant product should throw ProductNotFoundException`() {
        val productId = 1L

        `when`(productRepository.findById(productId))
            .thenReturn(Optional.empty())

        Assertions.assertThrowsExactly(
            ProductNotFoundException::class.java
        ) {
            productService.findById(productId)
        }
    }
}