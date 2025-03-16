package br.com.study.services.impl

import br.com.study.dto.ProductReq
import br.com.study.dto.ProductRes
import br.com.study.repositories.ProductRepository
import br.com.study.services.ProductService
import br.com.study.utils.toDomain
import br.com.study.utils.toResponse
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {

    override fun create(req: ProductReq): ProductRes {
        val product = req.toDomain()

        val result = productRepository.save(product)

        return result.toResponse() // Usando 'extension function' declarda no Kotlin file ProductUtil
    }
}