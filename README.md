# JAVA SPARK FOR WEB APPS

## 🛍️ Tienda en Línea — Spark Java (Modelo MCS)

Este proyecto implementa una **API web** para una tienda en línea de artículos coleccionables, desarrollada con **Java 17**, **Spark Framework** y **Mustache** para las vistas.  
Sigue el patrón **MCS (Modelo - Controlador - Servicio)** y utiliza **Maven** para la gestión de dependencias.

---

## 🚀 Tecnologías Utilizadas

- **Java 17 (Oracle JDK)**
- **Spark Java Framework**
- **Maven**
- **Mustache Template Engine**
- **HTML/CSS** (para las vistas)
- **Postman** (para pruebas de endpoints)

---
## ⚙️ Dependencias Principales

En tu `pom.xml` asegúrate de incluir lo siguiente:

```xml
<dependencies>
    <!-- Spark Java -->
    <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-core</artifactId>
        <version>2.9.4</version>
    </dependency>

    <!-- Mustache Template Engine -->
    <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-template-mustache</artifactId>
        <version>2.7.1</version>
    </dependency>

    <!-- Servlet API (requerido por Spark) -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```


## 🧠 Arquitectura (MCS)  
<br>  
Capa	Descripción	Ejemplo
<br>
Modelo (Model)	Define la estructura de datos de los artículos	Item.java
<br>
Controlador (Controller)	Maneja las rutas y solicitudes HTTP	ItemController.java
<br>
Servicio (Service)	Contiene la lógica de negocio	ItemService.java

<br>  

## 🧩 Funcionalidades

Listar artículos
Muestra todos los artículos disponibles en el sistema.

Ver detalles de un artículo
Permite visualizar información detallada de un artículo específico.

Registrar una oferta (offer)
Permite a los usuarios enviar una oferta por un artículo.

Manejo de excepciones personalizadas
Implementación de BadRequestException y NotFoundException.

## 🧪 Endpoints de la API
Método	Endpoint	Descripción  
GET	/items	Lista todos los artículos disponibles  
GET	/items/:id	Muestra los detalles de un artículo específico  
POST	/offers	Envía una oferta por un artículo
