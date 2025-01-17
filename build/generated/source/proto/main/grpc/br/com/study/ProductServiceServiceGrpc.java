package br.com.study;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: product-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceServiceGrpc {

  private ProductServiceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "br.com.study.ProductServiceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.study.ProductServiceRequest,
      br.com.study.ProductServiceReply> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = br.com.study.ProductServiceRequest.class,
      responseType = br.com.study.ProductServiceReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.study.ProductServiceRequest,
      br.com.study.ProductServiceReply> getSendMethod() {
    io.grpc.MethodDescriptor<br.com.study.ProductServiceRequest, br.com.study.ProductServiceReply> getSendMethod;
    if ((getSendMethod = ProductServiceServiceGrpc.getSendMethod) == null) {
      synchronized (ProductServiceServiceGrpc.class) {
        if ((getSendMethod = ProductServiceServiceGrpc.getSendMethod) == null) {
          ProductServiceServiceGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<br.com.study.ProductServiceRequest, br.com.study.ProductServiceReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.study.ProductServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.study.ProductServiceReply.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceServiceMethodDescriptorSupplier("send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceStub>() {
        @java.lang.Override
        public ProductServiceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceServiceStub(channel, callOptions);
        }
      };
    return ProductServiceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceBlockingStub>() {
        @java.lang.Override
        public ProductServiceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductServiceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceServiceFutureStub>() {
        @java.lang.Override
        public ProductServiceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceServiceFutureStub(channel, callOptions);
        }
      };
    return ProductServiceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void send(br.com.study.ProductServiceRequest request,
        io.grpc.stub.StreamObserver<br.com.study.ProductServiceReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductServiceService.
   */
  public static abstract class ProductServiceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductServiceService.
   */
  public static final class ProductServiceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceServiceStub> {
    private ProductServiceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceServiceStub(channel, callOptions);
    }

    /**
     */
    public void send(br.com.study.ProductServiceRequest request,
        io.grpc.stub.StreamObserver<br.com.study.ProductServiceReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductServiceService.
   */
  public static final class ProductServiceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceServiceBlockingStub> {
    private ProductServiceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.study.ProductServiceReply send(br.com.study.ProductServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductServiceService.
   */
  public static final class ProductServiceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceServiceFutureStub> {
    private ProductServiceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.study.ProductServiceReply> send(
        br.com.study.ProductServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((br.com.study.ProductServiceRequest) request,
              (io.grpc.stub.StreamObserver<br.com.study.ProductServiceReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              br.com.study.ProductServiceRequest,
              br.com.study.ProductServiceReply>(
                service, METHODID_SEND)))
        .build();
  }

  private static abstract class ProductServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.study.ProductService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductServiceService");
    }
  }

  private static final class ProductServiceServiceFileDescriptorSupplier
      extends ProductServiceServiceBaseDescriptorSupplier {
    ProductServiceServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceServiceMethodDescriptorSupplier
      extends ProductServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductServiceServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductServiceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceServiceFileDescriptorSupplier())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
