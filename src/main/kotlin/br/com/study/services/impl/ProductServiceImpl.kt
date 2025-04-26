package br.com.study.services.impl

import br.com.study.dto.ProductReq
import br.com.study.dto.ProductRes
import br.com.study.exceptions.AlreadyExistsException
import br.com.study.repositories.ProductRepository
import br.com.study.services.ProductService
import br.com.study.utils.toDomain
import br.com.study.utils.toResponse
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun create(req: ProductReq): ProductRes {
        verifyName(req.name)

        val result = productRepository.save(req.toDomain())

        return result.toResponse() // using 'extension function' declared on Kotlin file ProductConverterUtil
    }

    override fun findById(id: Long): ProductRes? {
        val result = productRepository.findById(id)
        return result?.get()?.toResponse()
    }

    private fun verifyName(name: String) {
        productRepository.findByNameIgnoreCase(name)?.let {// only enters if a product with this name exists
            throw AlreadyExistsException(name);
        }
    }
}