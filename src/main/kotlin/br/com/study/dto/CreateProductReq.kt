package br.com.study.dto

data class CreateProductReq(
    val name: String,
    val price: Double,
    val quantityInStock: Int
)
