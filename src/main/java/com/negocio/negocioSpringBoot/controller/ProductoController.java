package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/productos/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.ok("El producto se creo correctamente.");
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> traerProductos() {
        List<Producto> listaProductos = productoService.traerProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/productos/{id_producto}")
    public ResponseEntity<Producto> traerProducto(@PathVariable Long id_producto) {
        Producto producto = productoService.traerProducto(id_producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/eliminar/{id_producto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id_producto) {
        productoService.eliminarProducto(id_producto);
        return ResponseEntity.ok("El producto se elimino correctamente.");
    }

    @PutMapping("/productos/editar/{id_producto}")
    public ResponseEntity<String> editarProducto(@PathVariable Long id_producto, @RequestBody Producto producto) {
        productoService.editarProducto(id_producto, producto.getNombre(), producto.getMarca(), producto.getCosto(), producto.getCantidad_disponible());
        return ResponseEntity.ok("El producto se edito correctamente.");
    }

    @GetMapping("/productos/falta_stock")
    public ResponseEntity<List<Producto>> traerProdPocoStock() {
        List<Producto> listaProductos = productoService.faltaStock();
        return ResponseEntity.ok(listaProductos);
    }

}
