<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Zapatillas J&R</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .form-container { margin-bottom: 20px; padding: 15px; border: 1px solid #ccc; border-radius: 5px; }
        .btn { padding: 10px 15px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; }
        .btn-crear { background-color: #28a745; }
    </style>
</head>
<body>

    <h1>Catálogo de Zapatillas J&R</h1>

    <!-- Formulario de Búsqueda (Método GET) - HU-002 -->
    <div class="form-container">
        <h2>Buscar Zapatillas por Marca</h2>
        <form action="catalogo" method="GET">
            <input type="text" name="marca" placeholder="Ingrese la marca" value="${param.marca != null ? param.marca : ''}">
            <button type="submit" class="btn">Buscar</button>
        </form>
    </div>

    <!-- Enlace para crear nueva zapatilla -->
    <p>
        <a href="catalogo?accion=crear" class="btn btn-crear">Agregar Nueva Zapatilla</a>
    </p>

    <!-- Listado de Zapatillas (HU-001) -->
    <h2>Resultados del Catálogo</h2>
    <c:choose>
        <c:when test="${not empty zapatillas}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Marca</th>
                        <th>Talla</th>
                        <th>Precio</th>
                        <th>Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iteración sobre la lista de zapatillas usando JSTL -->
                    <c:forEach var="zapatilla" items="${zapatillas}">
                        <tr>
                            <td>${zapatilla.id}</td>
                            <td>${zapatilla.nombre}</td>
                            <td>${zapatilla.marca}</td>
                            <td>${zapatilla.talla}</td>
                            <td>$${zapatilla.precio}</td>
                            <td>${zapatilla.stock}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>No se encontraron zapatillas que coincidan con la búsqueda.</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
