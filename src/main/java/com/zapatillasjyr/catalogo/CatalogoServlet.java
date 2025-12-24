package com.zapatillasjyr.catalogo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet principal que actúa como controlador para el módulo de catálogo.
 * Maneja las peticiones GET (listar y buscar) y POST (crear nueva zapatilla).
 * 
 * @author Manus AI
 */
@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
    
    private ZapatillaDAO zapatillaDAO;

    /**
     * Inicializa el DAO al iniciar el Servlet.
     */
    @Override
    public void init() throws ServletException {
        super.init();
        this.zapatillaDAO = new ZapatillaDAO();
    }

    /**
     * Maneja las peticiones GET. Se utiliza para:
     * 1. Listar todas las zapatillas.
     * 2. Buscar zapatillas por marca (si se proporciona el parámetro 'marca').
     * 3. Redirigir al formulario de creación (si se proporciona el parámetro 'accion=crear').
     * 
     * @param request Petición HTTP.
     * @param response Respuesta HTTP.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if ("crear".equals(accion)) {
            // HU-003: Mostrar Formulario de Creación
            request.getRequestDispatcher("/vistas/crear.jsp").forward(request, response);
            return;
        }

        String marca = request.getParameter("marca");
        List<Zapatilla> zapatillas;

        if (marca != null && !marca.trim().isEmpty()) {
            // HU-002: Buscar Zapatilla por marca
            zapatillas = zapatillaDAO.buscarPorMarca(marca);
        } else {
            // HU-001: Consultar Catálogo completo
            zapatillas = zapatillaDAO.obtenerTodas();
        }

        request.setAttribute("zapatillas", zapatillas);
        request.getRequestDispatcher("/vistas/catalogo.jsp").forward(request, response);
    }

    /**
     * Maneja las peticiones POST. Se utiliza para:
     * 1. Procesar el formulario de creación de una nueva zapatilla.
     * 
     * @param request Petición HTTP.
     * @param response Respuesta HTTP.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HU-004: Crear Zapatilla (Procesar formulario)
        try {
            // 1. Obtener parámetros del formulario
            String nombre = request.getParameter("nombre");
            String marca = request.getParameter("marca");
            int talla = Integer.parseInt(request.getParameter("talla"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            // 2. Crear el objeto modelo
            Zapatilla nuevaZapatilla = new Zapatilla(0, nombre, marca, talla, precio, stock);

            // 3. Guardar en el DAO
            zapatillaDAO.guardar(nuevaZapatilla);

            // 4. Redirigir al catálogo actualizado (Patrón Post/Redirect/Get)
            response.sendRedirect(request.getContextPath() + "/catalogo");

        } catch (NumberFormatException e) {
            // Manejo de error simple para datos inválidos
            request.setAttribute("error", "Error en el formato de los datos ingresados.");
            request.getRequestDispatcher("/vistas/crear.jsp").forward(request, response);
        }
    }
}
