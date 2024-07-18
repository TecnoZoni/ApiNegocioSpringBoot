package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.dto.Cliente_Venta;
import com.negocio.negocioSpringBoot.model.Cliente;
import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.model.Venta;
import com.negocio.negocioSpringBoot.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public void crearVenta(Venta venta) {
        ventaRepo.save(venta);
    }
    
    @Override
    public List<Venta> traerVentas() {
        return ventaRepo.findAll();
    }
    
    @Override
    public Venta traerVenta(Long id_venta) {
        return ventaRepo.findById(id_venta).orElse(null);
    }
    
    @Override
    public void editarVenta(Long codigo_venta, LocalDate nuevaFecha_venta, Double nuevoTotal, List<Producto> nuevaListaProductos, Cliente nuevoCliente) {
        Venta vent = this.traerVenta(codigo_venta);
        
        vent.setFecha_venta(nuevaFecha_venta);
        vent.setTotal(nuevoTotal);
        vent.setListaProductos(nuevaListaProductos);
        vent.setUnCliente(nuevoCliente);
        
        this.crearVenta(vent);
    }
    
    @Override
    public void eliminarVenta(Long id_venta) {
        ventaRepo.deleteById(id_venta);
    }
    
    @Override
    public List<Producto> productosVenta(Long id_venta) {
        
        Venta venta = this.traerVenta(id_venta);
        List<Producto> listaProdcutos = venta.getListaProductos();
        
        return listaProdcutos;
    }
    
    @Override
    public String ventasDia(LocalDate fecha_venta) {
        double totalVentas = 0;
        int ventas = 0;
        List<Venta> listaVentas = this.traerVentas();
        
        for (Venta venta : listaVentas) {
            if (venta.getFecha_venta() == fecha_venta) {
                ventas = ventas + 1;
                totalVentas = totalVentas + venta.getTotal();
            }
        }
        
        return "En la fecha " + fecha_venta + " hubo " + ventas + " ventas y se gano $" + totalVentas;
    }
    
    @Override
    public Cliente_Venta ventaMayor() {
        List<Venta> listaVentas = this.traerVentas();
        Venta ventaMayor = new Venta();
        Cliente_Venta datosVenta = new Cliente_Venta();
        
        for (Venta venta : listaVentas) {
            if (venta.getTotal() > ventaMayor.getTotal()) {
                ventaMayor = venta;
            }
        }
        
        datosVenta.setCodigo_venta(ventaMayor.getCodigo_venta());
        datosVenta.setTotal(ventaMayor.getTotal());
        datosVenta.setCantidadProductos(ventaMayor.getListaProductos().size());
        datosVenta.setNombreCliente(ventaMayor.getUnCliente().getNombre());
        datosVenta.setApellidoCliente(ventaMayor.getUnCliente().getApellido());
        
        return datosVenta;
    }
}
