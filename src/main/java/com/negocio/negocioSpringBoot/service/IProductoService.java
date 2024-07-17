package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.model.Producto;
import java.util.List;

public interface IProductoService {

    public void crearProducto(Producto producto);

    public List<Producto> traerProductos();

    public Producto traerProducto(Long id_producto);

    public void editarProducto(Producto producto);

    public void eliminarProducto(Long id_producto);

    public List<Producto> faltaStock();
}
