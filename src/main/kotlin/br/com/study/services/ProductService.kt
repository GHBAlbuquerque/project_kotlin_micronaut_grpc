package br.com.study.services

import br.com.study.dto.CreateProductReq
import br.com.study.dto.ProductRes
import br.com.study.dto.UpdateProductReq

interface ProductService {
    fun create(req: CreateProductReq): ProductRes
    fun findById(id: Long): ProductRes
    fun update(req: UpdateProductReq): ProductRes
    fun delete(id: Long)
}