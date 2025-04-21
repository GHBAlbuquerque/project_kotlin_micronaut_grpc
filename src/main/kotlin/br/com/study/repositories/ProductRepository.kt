package br.com.study.repositories

import br.com.study.domain.Product
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByName(name: String): Product?
    fun existsByName(name: String): Boolean
}