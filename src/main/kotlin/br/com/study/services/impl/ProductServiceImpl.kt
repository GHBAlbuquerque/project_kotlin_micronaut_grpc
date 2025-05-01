package br.com.study.services.impl

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

        val copy = product.copy(name = req.name ?: product.name, // Kotlin function that creates a copy of the object
                    price = req.price ?: product.price,
                    quantityInStock = req.quantityInStock ?: product.quantityInStock) // other fields retain their original values unless explicitly modified.
            .let { productRepository.update(it) } // passed on for update

        return copy.toResponse()
    }

    private fun verifyName(name: String) {
        productRepository.findByNameIgnoreCase(name)?.let {// only enters if a product with this name exists
            throw AlreadyExistsException(name);
        }
    }
}