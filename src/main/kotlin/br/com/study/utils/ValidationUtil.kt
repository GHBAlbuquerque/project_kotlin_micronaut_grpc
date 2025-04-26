package br.com.study.utils

import br.com.study.CreateProductServiceRequest

class ValidationUtil {
    companion object { // Companion object to allow static-like access

        fun isValidPayload(payload: CreateProductServiceRequest?): CreateProductServiceRequest {

            payload?.let {// check if payload is not null
                if (it.name.isNullOrBlank()) {
                    throw IllegalArgumentException("Name cannot be null or blank")
                }
                if ( it.price.isNaN() || it.price <= 0) {
                    throw IllegalArgumentException("Price must be greater than 0")
                }
                if (it.quantityInStock < 0) {
                    throw IllegalArgumentException("Quantity in stock cannot be less than 0")
                }

                return it;
            }

            throw IllegalArgumentException("Payload cannot be null")
        }


    }
}