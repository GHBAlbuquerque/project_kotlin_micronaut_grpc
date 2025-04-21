package br.com.study.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?, //accepts null for automatic generation on database
    val name: String,
    val price: Double,
    val quantityInStock: Int
)
