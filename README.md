# Audit Service

A production-oriented Spring Boot REST API that audits websites by analyzing HTTP responses, SSL certificates, security headers, SEO metadata, and response time

## Features

* HTTP status validation
* Response time measurement
* SSL certificate inspection
* Security headers audit
* SEO metadata audit
* Concurrent Requests Limit
* Rate limiting per client (Bucket4j)
* Caffeine caching
* Structured logging with Request IDs
* Docker support
* Ready for Render deployment

---

## Tech Stack

* Java 17
* Spring Boot
* Maven
* Bucket4j
* Caffeine Cache
* SLF4J / Logback
* Docker

---

## Project Structure

```text
src
 ├── controller
 ├── config
 ├── dto
 ├── exception
 ├── filter
 ├── service
```

---

# API Documentation (Swagger)

Interactive API documentation is automatically generated using **SpringDoc OpenAPI**.

### Swagger UI

```text
https://auditservice-yzy5.onrender.com/swagger-ui/index.html
```

### OpenAPI Specification (JSON)

Swagger provides:

* Interactive API testing
* Request and response examples
* HTTP status codes
* Request parameter documentation
* Response model documentation

---

# API Contract

## Base URL

```text
https://auditservice-yzy5.onrender.com/
```

---

### Endpoint

```http
POST /audit
```
---

# Configuration
Can configure properties in application.properties files. For example

```
server.port=${PORT:8080}

rate-limit.enabled=true

cache.audit.ttl=10
cache.audit.max-size=1000
```

---

# Logging
Every request is assigned a unique Request ID.

---
Built for Digital Heroes Training Task


