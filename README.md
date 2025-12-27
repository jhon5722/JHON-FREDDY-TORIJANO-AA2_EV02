[README.md](https://github.com/user-attachments/files/24352099/README.md)
# Proyecto: Módulo de Catálogo - Zapatillas J&R (Servlets y JSP)

Este proyecto implementa el módulo de gestión y consulta del catálogo de productos (zapatillas) para la tienda online "Zapatillas J&R", utilizando la arquitectura tradicional de aplicaciones web Java con **Servlets** como controladores y **JSP** (JavaServer Pages) como vistas.

## 1. Tecnologías Utilizadas

| Componente | Tecnología | Versión | Propósito |
| :--- | :--- | :--- | :--- |
| **Controlador** | Java Servlets | Jakarta Servlet 6.0 | Maneja las peticiones HTTP (GET y POST). |
| **Vista** | JSP (JavaServer Pages) | Jakarta JSP 3.1 | Genera el contenido HTML dinámico. |
| **Librería de Etiquetas** | JSTL | Jakarta JSTL 3.0 | Facilita la lógica de presentación en las JSP. |
| **Lenguaje** | Java | 17 | Lenguaje de programación principal. |
| **Persistencia** | ZapatillaDAO | N/A | Simulación de acceso a datos con lista en memoria. |
| **Build Tool** | Maven | Última | Gestión de dependencias y empaquetado (WAR). |

## 2. Estructura del Módulo (Patrón MVC)

El proyecto sigue el patrón Modelo-Vista-Controlador (MVC):

*   **Modelo:** `com.zapatillasjyr.catalogo.Zapatilla` (POJO) y `com.zapatillasjyr.catalogo.ZapatillaDAO` (Acceso a Datos).
*   **Controlador:** `com.zapatillasjyr.catalogo.CatalogoServlet`.
*   **Vistas:** Archivos JSP ubicados en `src/main/webapp/vistas/` (`catalogo.jsp` y `crear.jsp`).

## 3. Implementación de Métodos HTTP y Formularios

El `CatalogoServlet` maneja las siguientes interacciones, cumpliendo con los requisitos de la evidencia:

| Método HTTP | URL | Propósito | Vista/Formulario |
| :--- | :--- | :--- | :--- |
| `GET` | `/catalogo` | Muestra el listado de zapatillas y el formulario de búsqueda. | `catalogo.jsp` |
| `GET` | `/catalogo?marca=Nike` | **Búsqueda (GET):** Filtra el listado por marca. | `catalogo.jsp` |
| `GET` | `/catalogo?accion=crear` | Muestra el formulario para crear una nueva zapatilla. | `crear.jsp` |
| `POST` | `/catalogo` | **Creación (POST):** Procesa los datos del formulario de `crear.jsp` y guarda la nueva zapatilla. | Redirige a `/catalogo` |

## 4. Estándares de Codificación y Comentarios

El código fuente utiliza comentarios **Javadoc** en todas las clases Java (`Zapatilla`, `ZapatillaDAO`, `CatalogoServlet`) para documentar su propósito, métodos y atributos. Se adhiere a las convenciones de nomenclatura de Java.

## 5. Instrucciones de Ejecución

1.  **Requisitos:** Tener instalado Java Development Kit (JDK) 17 o superior y Maven. Se requiere un servidor de aplicaciones compatible con Jakarta EE (como Apache Tomcat 10+).
2.  **Compilación:** Navegar a la carpeta raíz del proyecto (`/home/ubuntu/zapatillas_jyr_servlet`) y ejecutar:
    ```bash
    mvn clean package
    ```
3.  **Despliegue:** El comando anterior generará un archivo WAR (`target/catalogo-servlet.war`). Despliegue este archivo en su servidor de aplicaciones Tomcat.
4.  **Acceso:** Una vez desplegado, acceda a la aplicación en su navegador, típicamente en: `http://localhost:8080/catalogo-servlet/`.

## 6. Enlace al Repositorio Git

El proyecto ha sido versionado utilizando Git. El historial de commits refleja la creación de artefactos y la implementación del código.

**Enlace del Repositorio:** [[ENLACE_DEL_REPOSITORIO_A_GENERAR](https://github.com/jhon5722/JHON-FREDDY-TORIJANO-AA2_EV02)]

---
