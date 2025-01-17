# Catálogo de Libros - Proyecto Java con Spring Boot

Este proyecto es una aplicación desarrollada en Java utilizando Spring Boot que permite interactuar con un catálogo de libros. La aplicación se conecta a la API de Gutendex para obtener información de libros y utiliza PostgreSQL como base de datos para persistir los datos relacionados con los libros y autores.

---

## Características principales
- **Conexión a la API de Gutendex**: Obtiene datos de libros mediante solicitudes HTTP.
- **Base de datos PostgreSQL**: Persistencia de datos para libros y autores.
- **Menú interactivo**: Permite al usuario seleccionar opciones como:
  - Buscar libros por título.
  - Listar todos los libros.
  - Listar autores.
  - Listar autores vivos en un año determinado.
- **Análisis de JSON**: Utiliza Jackson para procesar y transformar las respuestas JSON en objetos Java.

---

## Requisitos previos
1. **Java**: Versión 17 o superior.
2. **Spring Boot**: Versión 3.2.3.
3. **PostgreSQL**: Configurado localmente o remotamente.
4. **Maven**: Versión 4.

---

## Configuración inicial

### Paso 1: Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/catalogo-libros.git
cd catalogo-libros
```

### Paso 2: Configurar la base de datos
1. Crea una base de datos en PostgreSQL llamada `catalogo_libros`.
2. Actualiza el archivo `application.properties` ubicado en `src/main/resources` con tus credenciales de PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_libros
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### Paso 3: Ejecutar la aplicación
1. Compila el proyecto:
```bash
mvn clean install
```
2. Inicia la aplicación:
```bash
mvn spring-boot:run
```

---

## Estructura del proyecto

### Paquetes principales
- `controller`: Maneja la interacción con el usuario (clase `MenuController`).
- `model`: Contiene las entidades de la base de datos, como `Libro` y `Autor`.
- `repository`: Interfaces para acceder a la base de datos usando Spring Data JPA.
- `service`: Lógica de negocio, como las interacciones con la API de Gutendex (clase `GutendexApiService`).

### Archivos clave
- **`CatalogoLibrosApplication.java`**: Clase principal que inicia la aplicación.
- **`application.properties`**: Configuración de la base de datos y otras propiedades de Spring Boot.

---

## API de Gutendex

### Enlace de referencia
[Gutendex API](https://gutendex.com)

### Configuración de la integración
El servicio `GutendexApiService` utiliza `HttpClient` para realizar solicitudes a la API. Asegúrate de que la API esté accesible antes de ejecutar el proyecto.

### Ejemplo de respuesta JSON
```json
{
  "title": "Pride and Prejudice",
  "authors": [
    {
      "name": "Jane Austen",
      "birth_year": 1775,
      "death_year": 1817
    }
  ]
}
```

---

## Uso
Al iniciar la aplicación, se presenta un menú interactivo con las siguientes opciones:

1. **Buscar libro por título**: Solicita al usuario que introduzca el título del libro a buscar.
2. **Listar todos los libros**: Muestra una lista completa de los libros almacenados en la base de datos.
3. **Listar autores**: Despliega todos los autores registrados.
4. **Listar autores vivos en un año**: Solicita al usuario un año y lista los autores que vivían en ese momento.

---

## Tecnologías utilizadas
- **Java** (17+)
- **Spring Boot** (3.2.3)
- **Maven**
- **PostgreSQL**
- **Gutendex API**
- **Jackson** (procesamiento de JSON)

---

## Pruebas
- Se realizaron pruebas exhaustivas para verificar el correcto funcionamiento de:
  - Conexión a la API de Gutendex.
  - Persistencia de datos en la base de datos.
  - Opciones del menú interactivo.

---

## Autores
- **Jaime Puerto**: Diseño, implementación y pruebas.

---


