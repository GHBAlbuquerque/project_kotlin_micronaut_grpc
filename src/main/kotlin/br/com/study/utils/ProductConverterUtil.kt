package br.com.study.utils

import br.com.study.domain.Product
import br.com.study.dto.CreateProductReq
import br.com.study.dto.ProductRes
import br.com.study.dto.UpdateProductReq

fun Product.toResponse(): ProductRes {
    return ProductRes(
        id = id!!,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun Product.toRequest(): CreateProductReq {
    return CreateProductReq(
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun CreateProductReq.toDomain(): Product {
    return Product(
        id = null,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}

fun Product.toUpdateRequest(): UpdateProductReq {
    return UpdateProductReq(
        id = id!!,
        name = name,
        price = price,
        quantityInStock = quantityInStock
    )
}