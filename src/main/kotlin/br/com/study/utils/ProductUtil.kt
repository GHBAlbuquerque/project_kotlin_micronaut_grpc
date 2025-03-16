package br.com.study.utils

import br.com.study.domain.Product
import br.com.study.dto.ProductReq
import br.com.study.dto.ProductRes

fun Product.toResponse(): ProductRes {
    return ProductRes(
        id = id!!,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun ProductReq.toDomain(): Product {
    return Product(
        id = null,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}