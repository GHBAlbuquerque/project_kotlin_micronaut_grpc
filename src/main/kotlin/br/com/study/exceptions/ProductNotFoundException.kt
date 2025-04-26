package br.com.study.exceptions

class ProductNotFoundException(private val productId : Long) : BaseBusinessException() {
    override fun errorMessage(): String {
        return "Product with id '$productId' not found."
    }

    override fun statusCode(): io.grpc.Status.Code {
        return io.grpc.Status.Code.NOT_FOUND
    }
}