package br.com.study.dto

data class UpdateProductReq(
    val id: Long,
    val name: String?,
    val price: Double?,
    val quantityInStock: Int?
)
