package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return "El producto se creo correctamente.";
    }

    @GetMapping("/productos")
    public List<Producto> traerProductos() {
        return productoService.traerProductos();
    }

    @GetMapping("/productos/{id_producto}")
    public Producto traerProducto(@PathVariable Long id_producto) {
        return productoService.traerProducto(id_producto);
    }

    @DeleteMapping("/productos/eliminar/{id_producto}")
    public String eliminarProducto(@PathVariable Long id_producto) {
        productoService.eliminarProducto(id_producto);
        return "El producto se elimino correctamente.";
    }

    @PutMapping("/productos/editar/{id_producto}")
    public String editarProducto(@PathVariable Long id_producto,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "costo") Double nuevoCosto,
            @RequestParam(required = false, name = "cantidad_disponible") Double nuevaCantidad_disponible) {

        productoService.editarProducto(id_producto, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad_disponible);

        return "El producto se edito correctamente.";
    }

}
