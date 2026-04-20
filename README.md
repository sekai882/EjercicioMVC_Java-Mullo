# 📈 Sistema de Cálculo de Comisiones - Mini-Core Java

**Desarrollado por:** Josué Mullo  
**Materia:** Ingeniería de Software / Ingeniería Web  
**Institución:** Universidad de las Américas (UDLA)  

---

## 🚀 Descripción del Proyecto

Este mini-core es una aplicación robusta desarrollada en Java con Spring Boot que implementa una arquitectura MVC para la gestión y cálculo de comisiones de ventas. El sistema procesa transacciones dentro de un rango de fechas y aplica reglas de negocio dinámicas basadas en el rendimiento de los vendedores.

**Características Principales:**
- **Cálculo Dinámico:** Aplicación de porcentajes (6%, 12% y 15%) según el volumen total de ventas.
- **Arquitectura Limpia:** Uso de patrones Service/ServiceImpl, DTOs para la transferencia de datos y Repositorios JPA.
- **Frontend Integrado:** Interfaz interactiva desarrollada con Thymeleaf y Bootstrap 5.
- **Persistencia Escalable:** Conexión a PostgreSQL mediante Supabase con gestión de pool de conexiones.

---

## 🔗 Despliegue en Vivo

La aplicación se encuentra dockerizada y desplegada en la nube:

👉 **Demo del Proyecto en Render:**  
[https://ejerciciomvc-java-mullo.onrender.com](https://ejerciciomvc-java-mullo.onrender.com)

---

## 🛠️ Stack Tecnológico

- **Backend:** Java 21, Spring Boot 3.x, Spring Data JPA, Lombok.
- **Frontend:** Thymeleaf, HTML5, CSS3 (Bootstrap 5).
- **Base de Datos:** PostgreSQL (Alojada en Supabase).
- **DevOps:** Docker, Render (PaaS).

---

## 💻 Configuración Local

**1. Clonar el repositorio:**
```bash
git clone https://github.com/sekai882/EjercicioMVC_Java-Mullo.git
```

**2. Configurar Base de Datos:**
Ajustar las credenciales en `src/main/resources/application.properties` (o asegurar que exista la variable de entorno `SUPABASE_DB_PASSWORD`).

**3. Compilar el proyecto:**
```bash
mvn clean package
```

**4. Ejecutar la aplicación:**
```bash
java -jar target/minicore-0.0.1-SNAPSHOT.jar
```

---

<p align="center">© 2026 - Josué Mullo - UDLA</p>
