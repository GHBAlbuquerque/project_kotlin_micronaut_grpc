# Product Service (gRPC, Kotlin and Micronaut)

Project based on the Udemy course by [Tony Augusto Silva](https://github.com/TonyALS). Done with Micronaut framework, gRPC and Kotlin.
[Udemy Course Link](https://www.udemy.com/share/10da6D3@PnrNCowtb0qfY0EjrpZ7FT8ao-Vey2Sw8W-sJNnGzRplAg6LyxX4sj3kz1jwzphm/)

#### Technologies
![image](https://img.shields.io/badge/gRPC-blue?style=for-the-badge&logo=grpc&logoColor=white)
![image](https://img.shields.io/badge/Kotlin-a64eff?style=for-the-badge&logo=kotlin&logoColor=white)
![image](https://img.shields.io/badge/Micronaut-black?style=for-the-badge&logo=Micronaut&logoColor=black)

## Description :book: 

### What is RPC?

Remote Procedure Call (RPC):
Think of RPC as a way for software components on different machines to communicate as if they were local procedures. Instead of sending data in a traditional format, RPCs enable one machine to directly call a function or method on another machine, as if it's a local function call.

#### What is gRPC?
gRPC is a high-performance, open-source Remote Procedure Call (RPC) framework developed by Google, primarily for connecting services across distributed environments.

Utilizes: GTTP2 and Protocol Buffers (Protobuf) for efficient serialization and deserialization of data.

### gRPC vs REST 🆚

gRPC:

* Faster and More Efficient: gRPC uses HTTP/2 and binary encoding (Protobuf) for faster data transmission and lower latency.
* Streaming: supports various streaming patterns (bidirectional, server, client) allowing for real-time communication.
* Tight Coupling: client and server are tightly coupled, requiring the same Protobuf definition, which can lead to more dependencies.
* Built-in Code Generation: offers built-in code generation tools for client and server stubs.
* Ideal for: High-performance applications, microservices, and real-time systems.

Examples: ```Netflix, video streaming, financial services.```

REST:
* Simpler and More Flexible: uses HTTP and text-based formats (JSON, XML) which are easy to understand and debug.
* Stateless and Cacheable: meaning each request is independent, and data can be cached.
* Loosely Coupled: allows for independent development and deployment of client and server.
* No Built-in Code Generation: requires third-party tools (like Swagger, Postman) for code generation.
* Ideal for: Public web services, applications that need to be accessible from web browsers.

Examples: ```Web APIs, social media platforms.```

## Features :toolbox:

* Create Product
* Find Product by ID

## Running locally :computer: 

### How to Run

1. Clone the repository:
2. Add as Gradle project
3. Build the project:
   ```bash
   ./gradlew build
   ```
4. Run the application with the Application.kt class
   

### Making requests

Insomnia request configuration:
```
- method: gRPC
- importo product-service.proto
- select desired method
- change desired unary
- port: 0.0.0.0:50051
```

## Authors

*Giovanna Albuquerque* [@GHBAlbuquerque](https://github.com/GHBAlbuquerque)

*Tony Augusto* [@tonyals](https://github.com/TonyALS)

Done in 2025