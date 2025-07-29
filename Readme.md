## 🌐 REST (REpresentational State Transfer)

REST is a **lightweight, language-independent** approach for communication between applications over HTTP.

### 🔑 Key Features:

- **Language Independent**
    - Clients and servers can be written in **any language**
- **Data Format Independent**
    - Can use **XML**, **JSON**, or others
    - **JSON** is the most **popular and modern** choice

---

## 📦 JSON (JavaScript Object Notation)

JSON is a **lightweight, plain-text data format** used for storing and exchanging data.

### ✅ Key Characteristics:

- **Language independent**
- **Readable and compact**
- Commonly used with REST APIs

### 🧱 JSON Structure:

- Curly braces `{}` define an object
- Inside an object:
    - Data is represented as **name/value pairs**
    - Format: `"name": value`
    - **Name must always be in double quotes**

### 📝 Example:

```json
{
  "name": "Ayush",
  "age": 27,
  "isDeveloper": true
}
```

---

## 🌍 REST over HTTP

REST uses the **HTTP protocol** to perform operations on resources identified by URLs.  
Each operation corresponds to an HTTP method.

### 🔧 Common HTTP Methods in REST:

| HTTP Method | Purpose                     | Example Use Case             |
|-------------|-----------------------------|------------------------------|
| `GET`       | Retrieve a resource         | Fetch a list of users        |
| `POST`      | Create a new resource       | Add a new user               |
| `PUT`       | Update an existing resource | Replace user details         |
| `PATCH`     | Partially update a resource | Update just the user’s email |
| `DELETE`    | Remove a resource           | Delete a specific user       |

### 📌 Key Concepts:

- **Resources** are represented by **URLs**
- REST is **stateless** — each request contains all the info needed
- Common response formats: **JSON** and **XML**
- Uses standard **HTTP response codes** (e.g., 200 OK, 404 Not Found, 201 Created)

REST over HTTP allows systems to **interact easily and consistently** using simple, standardized operations.

---

## 📤 HTTP Request Message

An **HTTP Request** is sent by the client to the server to perform an action on a resource.

### 🧱 Structure:

1. **Request Line**
    - Method + URL + HTTP Version
    - Example: `GET /api/users HTTP/1.1`

2. **Headers**
    - Key-value pairs that provide metadata
    - Example: `Content-Type: application/json`

3. **Blank Line**
    - Separates headers from body

4. **Body** (optional)
    - Data sent to the server (used in POST, PUT, etc.)
    - Usually in JSON or XML format

---

## 📥 HTTP Response Message

An **HTTP Response** is sent by the server back to the client after processing the request.

### 🧱 Structure:

1. **Status Line**
    - HTTP Version + Status Code + Status Message
    - Example: `HTTP/1.1 200 OK`

2. **Headers**
    - Metadata about the response
    - Example: `Content-Type: application/json`

3. **Blank Line**
    - Separates headers from body

4. **Body** (optional)
    - Contains the response data (e.g., JSON object)

---

### 🔢 Common Status Codes:

| Code | Meaning                 |
|------|-------------------------|
| 200  | OK (successful request) |
| 201  | Created                 |
| 400  | Bad Request             |
| 401  | Unauthorized            |
| 404  | Not Found               |
| 500  | Internal Server Error   |

---

## 📄 MIME (Multipurpose Internet Mail Extensions)

MIME is a standard that indicates the **type and format of data** being sent over the internet.

In the context of HTTP, MIME types are used in the **Content-Type** header to describe the **media type** of the request
or response body.

### 🧱 Format:

### 📌 Common MIME Types:

| MIME Type                  | Description                       |
|----------------------------|-----------------------------------|
| `text/plain`               | Plain text                        |
| `text/html`                | HTML document                     |
| `application/json`         | JSON data (commonly used in REST) |
| `application/xml`          | XML data                          |
| `multipart/form-data`      | Used for file uploads             |
| `application/octet-stream` | Binary data                       |
| `image/png`, `image/jpeg`  | Image files                       |

### 📝 Example Header:

```Content-Type: application/json```
This tells the server or client that the body of the message contains **JSON-formatted data**.

---
## 🛣️ `@PathVariable` in Spring

`@PathVariable` is used in Spring to extract **values from the URI path** and bind them to method parameters.

It allows dynamic parts of the URL to be passed into the controller method.

### 📝 Example:
```java
@GetMapping("/student/{studentId}")
public Student getStudent(@PathVariable int studentId){
    // studentId will contain the value from the URL
}
```

🔑 Key Points:
- The value inside {} in the URL maps to the method parameter
- The names must match, or you must explicitly define the name in the annotation
- Often used for REST endpoints like /products/{productId} or /orders/{orderId}

---
## ❗ Spring REST Exception Handling

Exception handling in Spring REST is essential for creating clean, consistent, and user-friendly error responses.

---

### 🎯 Goal

To handle exceptions in a way that:
- Returns **meaningful HTTP status codes**
- Avoids exposing internal details
- Keeps response format consistent (e.g., JSON)

---

### 🪜 Step-by-Step Process

| Step | What You Do                                      | Purpose                                      |
|------|--------------------------------------------------|----------------------------------------------|
| 1    | Create a custom exception class                  | To define specific errors (e.g., Not Found)  |
| 2    | Create a global handler class using `@ControllerAdvice` | To apply consistent exception handling app-wide |
| 3    | Use `@ExceptionHandler` inside that class        | To define how to respond to specific exceptions |
| 4    | (Optional) Create a custom error response class  | To return structured JSON error details      |
| 5    | Return proper HTTP status using `ResponseEntity` | To inform client of the error type correctly |

---

### 🏷️ Common Annotations Used

| Annotation         | Purpose                                                                 |
|--------------------|-------------------------------------------------------------------------|
| `@ControllerAdvice`| Marks a class for global exception handling across controllers          |
| `@ExceptionHandler`| Defines a method to handle specific exceptions                          |
| `@ResponseStatus`  | Sets the HTTP status code directly on a custom exception class          |
| `@RestControllerAdvice` | Same as `@ControllerAdvice` but adds `@ResponseBody` automatically |

---

### 🧱 Recommended Error Structure (Custom Response)

| Field      | Description                                |
|------------|--------------------------------------------|
| `message`  | Description of the error                   |
| `status`   | HTTP status code (e.g., 404, 500)          |
| `timestamp`| Time when the error occurred               |

Returning structured JSON like this improves API clarity and consumer experience.

---

### ✅ Summary

- Use `@ControllerAdvice` for centralized error handling
- Use `@ExceptionHandler` for mapping specific exceptions
- Return `ResponseEntity` with appropriate HTTP status
- Optionally use a custom response class for better structure

With this setup, your API becomes **cleaner**, more **robust**, and **easier to maintain**.

---
## 🌐 REST API Design (Revision Notes)

Designing a REST API involves structuring your endpoints and behavior to be **intuitive, scalable, and maintainable**.

---

### 🔑 Core Principles of REST

| Principle             | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| **Statelessness**     | Each request is independent with all necessary data                         |
| **Resource-Based**    | APIs should be centered around **resources**, not actions                   |
| **HTTP Methods**      | Use HTTP verbs (GET, POST, PUT, DELETE, etc.) to perform operations         |
| **Uniform Interface** | Consistent naming and behavior across the API                              |
| **Use of URIs**       | Unique identifiers for resources (e.g., `/users/101`)                       |

---

### 🧱 RESTful URI Design

| Action           | URI Example                | HTTP Method |
|------------------|----------------------------|-------------|
| Get all items    | `/users`                   | `GET`       |
| Get single item  | `/users/{id}`              | `GET`       |
| Create new item  | `/users`                   | `POST`      |
| Update item      | `/users/{id}`              | `PUT`       |
| Delete item      | `/users/{id}`              | `DELETE`    |

- Use **plural nouns** (`/products`, `/orders`)
- Avoid verbs in URIs — use HTTP methods instead

---

### 📦 Data Format

- Use **JSON** for requests and responses (`Content-Type: application/json`)
- Ensure clear structure and meaningful field names

---
### 📌 Best Practices

- Use **versioning** in URL (e.g., `/api/v1/users`)
- Support **filtering, pagination, and sorting** via query params
- Return **descriptive error messages** and use proper status codes
- Maintain a **consistent response format** (e.g., success + error structure)
- Use **HTTPS** for secure communication

---

### ✅ Summary

A well-designed REST API:
- Follows resource-based, stateless design
- Uses consistent URIs and HTTP methods
- Returns proper status codes and structured JSON
- Scales easily and is intuitive for client developers

