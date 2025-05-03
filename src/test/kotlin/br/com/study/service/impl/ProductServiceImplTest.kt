package br.com.study.service.impl

import br.com.study.domain.Product
import br.com.study.exceptions.AlreadyExistsException
import br.com.study.exceptions.ProductNotFoundException
import br.com.study.repositories.ProductRepository
import br.com.study.services.impl.ProductServiceImpl
import br.com.study.utils.toRequest
import br.com.study.utils.toUpdateRequest
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

    @Test
    fun `when update method is called with valid data, should update a product`() {
        val productUpdateInput = Product(id = 1, name = "Product 1", price = 8.0, quantityInStock = 7)
        val product = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)
        val productUpdated = Product(id = 1, name = "Product 1", price = 8.0, quantityInStock = 7)

        `when`(productRepository.findById(productUpdateInput.id))
            .thenReturn(Optional.of(product))

        `when`(productRepository.update(productUpdateInput))
            .thenReturn(productUpdated)

        val result = productService.update(productUpdateInput.toUpdateRequest())

        assert(productUpdateInput.name == result.name)
    }

    @Test
    fun `when update method is called with duplicate product name should throw AlreadyExistsException`() {
        val productUpdateInput = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)
        val product = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.findByNameIgnoreCase(productUpdateInput.name))
            .thenReturn(product)

        Assertions.assertThrowsExactly(
            AlreadyExistsException::class.java
        ) {
            productService.update(productUpdateInput.toUpdateRequest())
        }
    }

    @Test
    fun `when update method is called with non-existant product, should throw AlreadyExistsException`() {
        val productId = 1L
        val productUpdateInput = Product(id = 1, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.findById(productId))
            .thenReturn(Optional.empty())

        Assertions.assertThrowsExactly(
            ProductNotFoundException::class.java
        ) {
            productService.update(productUpdateInput.toUpdateRequest())
        }
    }

    @Test
    fun `when delete method is called with valid ID, should delete a product`() {
        val productId = 1L
        val product = Product(id = productId, name = "Product 1", price = 10.0, quantityInStock = 2)

        `when`(productRepository.findById(productId))
            .thenReturn(Optional.of(product))

        productService.delete(productId)

        Assertions.assertDoesNotThrow {
            productRepository.findById(productId)
        }

        Mockito.verify(productRepository).deleteById(productId)
    }

    @Test
    fun `when delete method is called with non-existant product, should throw ProductNotFoundException`() {
        val productId = 1L

        `when`(productRepository.findById(productId))
            .thenReturn(Optional.empty())

        Assertions.assertThrowsExactly(
            ProductNotFoundException::class.java
        ) {
            productService.delete(productId)
        }
    }

    @Test
    fun `when findAll method is called, should return a list of ProductRes`() {
        val product = Product(id = 1L, name = "Product 1", price = 10.0, quantityInStock = 2)
        val product2 = Product(id = 2L, name = "Product 2", price = 20.0, quantityInStock = 5)

        `when`(productRepository.findAll())
            .thenReturn(listOf(product, product2))

        val response = productService.findAll()

        Assertions.assertNotNull(response)
        Assertions.assertEquals(2, response.size)
    }

    @Test
    fun `when findAll method is called and no product exists, should return empty list`() {
        `when`(productRepository.findAll())
            .thenReturn(listOf())

        val response = productService.findAll()

        Assertions.assertNotNull(response)
        Assertions.assertEquals(0, response.size)
    }
}