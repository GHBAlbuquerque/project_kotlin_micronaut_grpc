package br.com.study.utils

import br.com.study.CreateProductServiceRequest
import br.com.study.UpdateProductServiceRequest
import br.com.study.dto.UpdateProductReq
import br.com.study.exceptions.InvalidArgumentException

class ValidationUtil {
    companion object { // Companion object to allow static-like access

        fun isValidPayload(payload: CreateProductServiceRequest?): CreateProductServiceRequest {

            payload?.let {// check if payload is not null
                if (it.name.isNullOrBlank()) {
                    throw InvalidArgumentException("name", "Name cannot be null or blank")
                }
                if ( it.price.isNaN() || it.price <= 0) {
                    throw InvalidArgumentException("price", "Price must be greater than 0")
                }
                if (it.quantityInStock < 0) {
                    throw InvalidArgumentException("quantity_in_stock", "Quantity in stock cannot be less than 0")
                }

                return it;
            }

            throw InvalidArgumentException("payload", "Payload cannot be null")
        }

        fun isValidPayload(payload: UpdateProductServiceRequest?): UpdateProductServiceRequest {

            payload?.let {
                if (it.id <= 0L) {
                    throw InvalidArgumentException("id", "Id must be greater than 0")
                }
                if (it.price.isNaN() || it.price < 0) {
                    throw InvalidArgumentException("price", "Price must be greater than 0")
                }
                if (it.quantityInStock < 0) {
                    throw InvalidArgumentException("quantity_in_stock", "Quantity in stock cannot be less than 0")
                }

                return it;
            }

            throw InvalidArgumentException("payload", "Payload cannot be null")
        }
    }
}