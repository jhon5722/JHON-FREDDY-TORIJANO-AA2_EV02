package com.zapatillasjyr.catalogo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Modelo (POJO) que representa una Zapatilla.
 * Contiene los atributos básicos del producto.
 * 
 * @author Manus AI
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zapatilla {

    /**
     * Identificador único de la zapatilla.
     */
    private int id;

    /**
     * Nombre o modelo de la zapatilla.
     */
    private String nombre;

    /**
     * Marca del fabricante (ej. Nike, Adidas).
     */
    private String marca;

    /**
     * Talla de la zapatilla (formato numérico).
     */
    private int talla;

    /**
     * Precio de venta al público.
     */
    private double precio;

    /**
     * Cantidad disponible en inventario.
     */
    private int stock;
}
