package br.com.study.services

import br.com.study.dto.ProductReq
import br.com.study.dto.ProductRes

interface ProductService {
    fun create(req: ProductReq): ProductRes
    fun findById(id: Long): ProductRes?
}