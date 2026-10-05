package com.estudiante.controldespensaapi.despensa.controller;

import com.estudiante.controldespensaapi.despensa.model.Producto;
import com.estudiante.controldespensaapi.despensa.model.ResumenInventario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")


public class ProductoController {


    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        agregarProductoSeguro(new Producto(100L, "Leche", "Lácteos", 5, 2.50));//dos productos de la misma categoría.
        agregarProductoSeguro(new Producto(25L, "Queso Blanco", "Lácteos", 2, 4.00));//dos productos de la misma categoría, dos productos con cantidad igual o menor que tres.
        agregarProductoSeguro(new Producto(33L, "Arroz", "Granos", 10, 1.80));
        agregarProductoSeguro(new Producto(42L, "Frijoles Negros", "Granos", 3, 2.00));//dos productos con cantidad igual o menor que tres.
        agregarProductoSeguro(new Producto(547L, "Detergente Líquido", "Limpieza", 4, 8.50));
        agregarProductoSeguro(new Producto(64L, "Jugo de Naranja", "Bebidas", 6, 3.00));
    }

    private void agregarProductoSeguro(Producto nuevo) {
        for (Producto p : productos) {
            if (p.getId().equals(nuevo.getId())) {
                throw new IllegalArgumentException("Ya existe un producto con el ID: " + nuevo.getId());
            }
        }
        productos.add(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return ResponseEntity.ok(producto);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Producto> filtrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                filtrados.add(producto);
            }
        }
        return ResponseEntity.ok(filtrados);
    }

    @GetMapping("/stock-bajo")
    public ResponseEntity<List<Producto>> obtenerStockBajo() {
        List<Producto> stockBajo = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCantidad() <= 3) {
                stockBajo.add(producto);
            }
        }
        return ResponseEntity.ok(stockBajo);
    }


    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {
        if (productos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Producto productoMayorValor = productos.get(0);
        double mayorSubtotal = productoMayorValor.calcularSubtotal();

        for (Producto producto : productos) {
            double subtotalActual = producto.calcularSubtotal();
            if (subtotalActual > mayorSubtotal) {
                mayorSubtotal = subtotalActual;
                productoMayorValor = producto;
            }
        }

        return ResponseEntity.ok(productoMayorValor);
    }

    @GetMapping("/resumen")
    public ResponseEntity<ResumenInventario> obtenerResumen() {
        int cantidadProductos = productos.size();
        int totalUnidades = 0;
        double valorTotal = 0.0;

        for (Producto producto : productos) {
            totalUnidades += producto.getCantidad();
            valorTotal += producto.calcularSubtotal();
        }

        ResumenInventario resumen = new ResumenInventario(cantidadProductos, totalUnidades, valorTotal);
        return ResponseEntity.ok(resumen);
    }
}