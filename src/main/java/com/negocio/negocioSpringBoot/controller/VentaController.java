package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.dto.Cliente_Venta;
import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.model.Venta;
import com.negocio.negocioSpringBoot.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @PostMapping("/ventas/crear")
    public ResponseEntity<String> crearVenta(@RequestBody Venta venta) {
        venta.setFecha_venta(LocalDate.now());
        ventaService.crearVenta(venta);
        return ResponseEntity.ok("Venta creada correctamente");
    }

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> traerVentas() {
        List<Venta> ventas = ventaService.traerVentas();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/ventas/{id_venta}")
    public ResponseEntity<Venta> traerVenta(@PathVariable Long id_venta) {
        Venta venta = ventaService.traerVenta(id_venta);
        return ResponseEntity.ok(venta);
    }

    @DeleteMapping("/ventas/eliminar/id_venta")
    public ResponseEntity<String> eliminarVenta(@PathVariable Long id_venta) {
        ventaService.eliminarVenta(id_venta);
        return ResponseEntity.ok("Venta eliminada correctamente");
    }

    @PutMapping("/ventas/editar/{id_venta}")
    public ResponseEntity<String> editarVenta(@PathVariable Long id_venta, @RequestBody Venta nuevaVenta) {
        ventaService.editarVenta(id_venta, nuevaVenta.getTotal(), nuevaVenta.getListaProductos(), nuevaVenta.getUnCliente());
        return ResponseEntity.ok("Venta editada correctamente");
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public ResponseEntity<List<Producto>> traerProdVenta(@PathVariable Long codigo_venta) {
        List<Producto> listaProducVenta = ventaService.productosVenta(codigo_venta);
        return ResponseEntity.ok(listaProducVenta);
    }

    @GetMapping("/ventas/mayor_venta")
    public ResponseEntity<Cliente_Venta> traerMayorVenta() {
        Cliente_Venta clienVenta = ventaService.ventaMayor();
        return ResponseEntity.ok(clienVenta);
    }

    @GetMapping("/ventas/dia/{fecha_venta}")
    public ResponseEntity<String> traerTotalVentas(@PathVariable String fecha_venta) {
        LocalDate fecha = LocalDate.parse(fecha_venta);
        String mensaje = ventaService.ventasDia(fecha);
        return ResponseEntity.ok(mensaje);
    }

}
