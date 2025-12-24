package com.zapatillasjyr.catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase DAO (Data Access Object) para la gestión de Zapatillas.
 * Simula la persistencia de datos utilizando una lista en memoria.
 * 
 * @author Manus AI
 */
public class ZapatillaDAO {

    private static final List<Zapatilla> catalogo = new ArrayList<>();
    private static int nextId = 1;

    // Bloque estático para inicializar el catálogo con datos de ejemplo
    static {
        catalogo.add(new Zapatilla(nextId++, "Air Max 270", "Nike", 42, 150.00, 10));
        catalogo.add(new Zapatilla(nextId++, "Ultraboost 22", "Adidas", 40, 180.00, 15));
        catalogo.add(new Zapatilla(nextId++, "Classic Leather", "Reebok", 41, 85.00, 20));
        catalogo.add(new Zapatilla(nextId++, "RS-X3", "Puma", 43, 110.00, 8));
    }

    /**
     * Obtiene todas las zapatillas del catálogo.
     * 
     * @return Lista de todas las zapatillas.
     */
    public List<Zapatilla> obtenerTodas() {
        return catalogo;
    }

    /**
     * Busca zapatillas por marca.
     * 
     * @param marca La marca a buscar (ignorando mayúsculas/minúsculas).
     * @return Lista de zapatillas que coinciden con la marca.
     */
    public List<Zapatilla> buscarPorMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            return obtenerTodas();
        }
        String marcaLower = marca.toLowerCase();
        return catalogo.stream()
                .filter(z -> z.getMarca().toLowerCase().contains(marcaLower))
                .collect(Collectors.toList());
    }

    /**
     * Guarda una nueva zapatilla en el catálogo.
     * 
     * @param zapatilla El objeto zapatilla a guardar.
     */
    public void guardar(Zapatilla zapatilla) {
        zapatilla.setId(nextId++);
        catalogo.add(zapatilla);
    }
}
