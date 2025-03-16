package br.com.study.service.impl

import br.com.study.domain.Product
import br.com.study.dto.ProductReq
import br.com.study.repositories.ProductRepository
import br.com.study.services.impl.ProductServiceImpl
import br.com.study.utils.toRequest
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

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
}