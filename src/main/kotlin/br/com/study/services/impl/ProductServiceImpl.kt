package br.com.study.services.impl

import br.com.study.domain.Product
import br.com.study.dto.CreateProductReq
import br.com.study.dto.ProductRes
import br.com.study.dto.UpdateProductReq
import br.com.study.exceptions.AlreadyExistsException
import br.com.study.exceptions.ProductNotFoundException
import br.com.study.repositories.ProductRepository
import br.com.study.services.ProductService
import br.com.study.utils.toDomain
import br.com.study.utils.toResponse
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun create(req: CreateProductReq): ProductRes {
        verifyName(req.name)

        val result = productRepository.save(req.toDomain())

        return result.toResponse() // using 'extension function' declared on Kotlin file ProductConverterUtil
    }

    override fun findById(id: Long): ProductRes {
        val result = productRepository.findById(id)

        result.orElseThrow { ProductNotFoundException(id) }

        return result.get().toResponse()
    }

    override fun update(req: UpdateProductReq): ProductRes {
        verifyName(req.name ?: "")

        val product = productRepository.findById(req.id)
            .orElseThrow { ProductNotFoundException(req.id) }

        val copy = copyExistingProduct(product, req)
            .let { productRepository.update(it) } // passed on for update

        return copy.toResponse()
    }

    override fun delete(id: Long) {
        findById(id) // throws exception if not found
        productRepository.deleteById(id)
    }

    private fun verifyName(name: String) {
        productRepository.findByNameIgnoreCase(name)?.let {// only enters if a product with this name exists
            throw AlreadyExistsException(name);
        }
    }

    private fun copyExistingProduct(product: Product, req: UpdateProductReq): Product {
        // Kotlin function that creates a copy of the object
        // Other fields retain their original values unless explicitly modified.
        // Here I chose to ignore zero value because it is the proto default, there is no null

        return product.copy(
            name = if (req.name.isNullOrBlank()) product.name else req.name,
            price = if (req.price == null || req.price <= 0) product.price else req.price,
            quantityInStock = if (req.quantityInStock == null || req.quantityInStock <= 0) product.quantityInStock else req.quantityInStock,
        )
    }
}