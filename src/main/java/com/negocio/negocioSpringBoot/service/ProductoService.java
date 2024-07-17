package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.model.Producto;
import com.negocio.negocioSpringBoot.repository.IProductoRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository produRepo;

    @Override
    public void crearProducto(Producto producto) {
        produRepo.save(producto);
    }

    @Override
    public List<Producto> traerProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto traerProducto(Long id_producto) {
        return produRepo.findById(id_producto).orElse(null);
    }

    @Override
    public void editarProducto(Producto producto) {
        produRepo.save(producto);
    }

    @Override
    public void eliminarProducto(Long id_producto) {
        produRepo.deleteById(id_producto);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = this.traerProductos();
        List<Producto> listaPocoStock = new ArrayList<Producto>();

        for (Producto produc : listaProductos) {
            if (produc.getCantidad_disponible() < 5) {
                listaPocoStock.add(produc);
            }
        }

        return listaPocoStock;
    }
}
