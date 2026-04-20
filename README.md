# EjercicioMVC_Java-Mullo

![Java 21](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot 3](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue.svg)
![Render](https://img.shields.io/badge/Deployed_on-Render-purple.svg)

Desarrollado por **Josué Mullo**.

Sistema de Gestión de Ventas y Comisiones construido con arquitectura MVC usando Spring Boot, Thymeleaf y base de datos PostgreSQL alojada en Supabase. El sistema utiliza entidades con JPA e inyección de dependencias.

## Requisitos Previos
- JDK 21
- Docker (Opcional, para ejecución en contenedor)
- Conexión a Base de Datos Supabase (La BD se crea y actualiza de manera automática mediante `ddl-auto=update`).

## Construcción y Ejecución

Para compilar y empaquetar el proyecto (asegúrate de setear la variable de entorno `SUPABASE_DB_PASSWORD` ya sea global o antes del comando):
```bash
mvn clean package -DskipTests
```

Para correr el `.jar` directamente:
```bash
java -jar target/minicore-0.0.1-SNAPSHOT.jar
```

## Docker

Construir la imagen de Docker usando el `Dockerfile` multietapa optimizado:
```bash
docker build -t minicore-app .
```

Ejecutar el contenedor pasando la variable de entorno requerida por la base de datos:
```bash
docker run -p 8080:8080 -e SUPABASE_DB_PASSWORD=tu_password minicore-app
```
