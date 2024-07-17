package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void crearVenta(Venta venta);

    public List<Venta> traerVentas();

    public Venta traerVenta(Long id_venta);

    public void editarVenta(Venta venta);

    public void eliminarVenta(Long id_venta);

    public List<Producto> productosVenta(Long id_venta);

    public String ventasDia(LocalDate fecha_venta);
}