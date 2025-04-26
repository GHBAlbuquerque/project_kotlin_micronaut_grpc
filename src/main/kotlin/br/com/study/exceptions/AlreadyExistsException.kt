package br.com.study.exceptions

class AlreadyExistsException(private val productName : String) : BaseBusinessException() {
    override fun errorMessage(): String {
        return "Product with name '$productName' already exists."
    }

    override fun statusCode(): io.grpc.Status.Code {
        return io.grpc.Status.Code.ALREADY_EXISTS
    }
}