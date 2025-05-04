package br.com.study.interceptor

import br.com.study.exceptions.BaseBusinessException
import io.grpc.ForwardingServerCallListener
import io.grpc.Metadata
import io.grpc.ServerCall
import io.grpc.Status

class ExceptionHandlerServerCallListener<ReqT, ResT>(
    private val servercall: ServerCall<ReqT, ResT>?,
    private val metadata: Metadata?,
    delegate: ServerCall.Listener<ReqT>?
) : ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(delegate) {

    override fun onHalfClose() {
        try {
            super.onHalfClose()
        } catch (ex: BaseBusinessException) {
            servercall?.close(
                ex.statusCode().toStatus()
                    .withDescription(ex.errorMessage()),
                metadata
            )
        } catch (ex: Throwable) {
            servercall?.close(
                Status.UNKNOWN
                    .code.toStatus()
                    .withDescription("Internal Server error"),
                metadata
            )
        }
    }

    override fun onReady() {
        try {
            super.onReady()
        } catch (ex: BaseBusinessException) {
            servercall?.close(
                ex.statusCode().toStatus()
                    .withDescription(ex.errorMessage()),
                metadata
            )
        } catch (ex: Throwable) {
            servercall?.close(
                Status.UNKNOWN
                    .code.toStatus()
                    .withDescription("Internal Server error"),
                metadata
            )
        }
    }
}