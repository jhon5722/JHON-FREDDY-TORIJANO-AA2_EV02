<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Nueva Zapatilla</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        form { max-width: 400px; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        label { display: block; margin-top: 10px; }
        input[type="text"], input[type="number"] { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; }
        button { margin-top: 20px; padding: 10px 15px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; }
        .error { color: red; margin-top: 10px; }
    </style>
</head>
<body>

    <h1>Agregar Nueva Zapatilla</h1>

    <!-- Muestra mensaje de error si existe -->
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <!-- Formulario de Creación (Método POST) - HU-003, HU-004 -->
    <form action="${pageContext.request.contextPath}/catalogo" method="POST">
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>

        <label for="marca">Marca:</label>
        <input type="text" id="marca" name="marca" required>

        <label for="talla">Talla:</label>
        <input type="number" id="talla" name="talla" required min="30" max="50">

        <label for="precio">Precio:</label>
        <input type="number" id="precio" name="precio" required min="0.01" step="0.01">

        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" required min="0">

        <button type="submit">Guardar Zapatilla</button>
    </form>
    
    <p><a href="${pageContext.request.contextPath}/catalogo">Volver al Catálogo</a></p>

</body>
</html>
