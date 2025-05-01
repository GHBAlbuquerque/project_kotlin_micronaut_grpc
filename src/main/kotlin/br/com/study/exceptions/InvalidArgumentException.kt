package br.com.study.exceptions

class InvalidArgumentException(private val argumentName : String, private val errorMessage : String) : BaseBusinessException() {
    override fun errorMessage(): String {
        return "Argument '$argumentName' is invalid. Error message: $errorMessage"
    }

    override fun statusCode(): io.grpc.Status.Code {
        return io.grpc.Status.Code.INVALID_ARGUMENT
    }
}