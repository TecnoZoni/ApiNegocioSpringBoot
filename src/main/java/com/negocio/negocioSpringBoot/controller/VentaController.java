package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.model.Cliente;
import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.model.Venta;
import com.negocio.negocioSpringBoot.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
    
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
        ventaService.crearVenta(venta);
        return "Venta creada correctamente";
    }
    
    @GetMapping("/ventas")
    public List<Venta> traerVentas() {
        return ventaService.traerVentas();
    }
    
    @GetMapping("/ventas/{id_venta}")
    public Venta traerVenta(@PathVariable Long id_venta) {
        return ventaService.traerVenta(id_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/id_venta")
    public String eliminarVenta(@PathVariable Long id_venta) {
        ventaService.eliminarVenta(id_venta);
        return "Venta eliminada correctamente";
    }
    
    @PutMapping("/ventas/editar/{id_venta}")
    public String editarVenta(@PathVariable Long id_venta,
            @RequestParam(required = false, name = "fecha_venta") LocalDate nuevaFecha_venta,
            @RequestParam(required = false, name = "nuevoTotal") double nuevoTotal,
            @RequestParam(required = false, name = "nuevaListaProductos") List<Producto> nuevaListaProductos,
            @RequestParam(required = false, name = "NuevoCliente") Cliente nuevoCliente) {
        
        ventaService.editarVenta(id_venta, nuevaFecha_venta, nuevoTotal, nuevaListaProductos, nuevoCliente);
        
        return "Venta editada correctamente";
    }
}
