ForoHub Application

Descripción

ForoHub es una aplicación desarrollada en Java con Spring Boot que permite la creación y gestión de foros temáticos. Los usuarios pueden registrarse, autenticar sus credenciales, crear publicaciones, comentar en las mismas y explorar contenido por categorías.

Tecnologías Utilizadas

Java 17: Lenguaje de programación principal.

Spring Boot: Framework para el desarrollo de la aplicación.

Spring Data JPA para la gestión de la base de datos.

Spring Security para la autenticación y autorización.

PostgreSQL: Base de datos relacional.

Hibernate: Implementación de JPA.

Maven: Herramienta para la gestión de dependencias.

Características

Autenticación y Autorización:

Registro de usuarios.

Inicio de sesión seguro.

Roles y permisos definidos para usuarios.

Gestión de Foros:

Creación de publicaciones.

Comentarios en publicaciones.

Filtrado de contenido por categorías.

Diseño Modular:

Separación de capas (Controladores, Servicios, Repositorios).

Gestión de entidades a través de Hibernate.

Requisitos del Sistema

Java 17 o superior.

PostgreSQL 14 o superior.

Maven 3.8.1 o superior.

Configuración del Proyecto

Clonar el repositorio

git clone https://github.com/usuario/forohub.git
cd forohub

Configurar la Base de Datos

Crear una base de datos PostgreSQL:

CREATE DATABASE forohub;

Actualizar las credenciales de la base de datos en application.properties o application.yml:

spring.datasource.url=jdbc:postgresql://localhost:5432/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Ejecutar el Proyecto

Compilar y empaquetar la aplicación:

mvn clean install

Ejecutar la aplicación:

mvn spring-boot:run

Endpoints Principales

Autenticación:

POST /auth/login: Inicio de sesión.

POST /auth/register: Registro de usuarios.

Publicaciones:

GET /posts: Listar publicaciones.

POST /posts: Crear una nueva publicación.

Comentarios:

POST /posts/{id}/comments: Agregar un comentario a una publicación.

Pruebas

Pruebas Unitarias: Implementadas con JUnit y Mockito.

Ejecutar pruebas:

mvn test

Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.
