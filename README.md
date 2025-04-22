# 🍕 Proyecto de Gestión de Pedidos de Pizza en Línea

Este proyecto implementa un sistema completo en Java para gestionar pedidos de pizza con conexión a base de datos remota (Railway) mediante JDBC y patrón de diseño con inyección de dependencias.

---

## 📦 Estructura del Proyecto

### ✅ `Main.java`
Clase principal del proyecto. Orquesta la ejecución del sistema. Realiza las siguientes funciones:
- Conecta a la base de datos con `DataBaseManager`
- Autentica al usuario con `Authenticator`
- Crea y elimina pedidos con `OrderManager`
- Usa `PaymentProcessor` para simular el pago

---

### 🔐 `Authenticator.java`
Clase responsable de autenticar usuarios registrados en la base de datos (`users`).
- Recibe una conexión JDBC (inyectada)
- Ejecuta un `SELECT` sobre la tabla `users`
- Devuelve el `user_id` si las credenciales son correctas
- Devuelve `-1` si la autenticación falla

---

### 🗃️ `DataBaseManager.java`
Encargada de la conexión a la base de datos en Railway.
- Método `connect()`: abre la conexión JDBC
- Método `createOrder(...)`: inserta un nuevo pedido en la tabla `orders`
- Método `deleteOrder(...)`: elimina un pedido por su ID
- Proporciona la conexión para otras clases como `Authenticator`

---

### 🧾 `OrderManager.java`
Gestiona toda la lógica de negocio relacionada con los pedidos.
- Método `crearPedido(...)`: solicita el pago, luego guarda el pedido
- Método `eliminarPedido(...)`: elimina un pedido por ID
- Recibe `DataBaseManager` y `PaymentProcessor` por inyección de dependencias

---

### 💳 `PaymentProcessor.java`
Simula el procesamiento de pagos.
- Método `processPayment(...)`: simula la transacción de pago
- Actualmente siempre devuelve `true` (puede extenderse a lógica real en el futuro)

---

## 🧪 Base de datos en Railway

- Tabla `users`: contiene los usuarios registrados (`id`, `username`, `password`)
- Tabla `orders`: contiene los pedidos (`id`, `user_id`, `description`, `amount`, `created_at`)

---

## 💡 Tecnologías utilizadas

- Java 17
- JDBC (MySQL)
- Railway (DBaaS)
- Maven
- IntelliJ IDEA

---

## 🛠️ Posibles mejoras

- Implementación de interfaz gráfica (JavaFX o Swing)
- Cifrado de contraseñas con `BCrypt`
- Listado de pedidos por usuario
- API REST con Spring Boot

---
