package br.com.study.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?, //aceita nulo para poder gerar automático no banco
    val name: String,
    val price: Double,
    val quantityInStock: Int
)
