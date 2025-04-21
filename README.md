# Prodcut Service (gRPC, Kotlin and Micronaut)

Project based on the Udemy course by Tony Augusto Silva. Done with Micronaut framework, gRPC and Kotlin.
[Udemy Link](https://www.udemy.com/share/10da6D3@PnrNCowtb0qfY0EjrpZ7FT8ao-Vey2Sw8W-sJNnGzRplAg6LyxX4sj3kz1jwzphm/)

## Description

### What is gRPC?

TBD

### gRPC vs REST

gRPC:

Faster and More Efficient: gRPC uses HTTP/2 and binary encoding (Protobuf) for faster data transmission and lower latency.
Streaming: gRPC supports various streaming patterns (bidirectional, server, client) allowing for real-time communication.
Tight Coupling: gRPC's client and server are tightly coupled, requiring the same Protobuf definition, which can lead to more dependencies.
Built-in Code Generation: gRPC offers built-in code generation tools for client and server stubs.
Ideal for: High-performance applications, microservices, and real-time systems.
Examples: Netflix, video streaming, financial services.

REST:
Simpler and More Flexible:
REST uses HTTP and text-based formats (JSON, XML) which are easy to understand and debug.
Stateless and Cacheable:
REST APIs are stateless, meaning each request is independent, and data can be cached.
Loosely Coupled:
REST APIs are loosely coupled, allowing for independent development and deployment of client and server.
No Built-in Code Generation:
REST requires third-party tools (like Swagger, Postman) for code generation.
Ideal for:
Public web services, applications that need to be accessible from web browsers.
Examples:
Web APIs, social media platforms.

