package com.negocio.negocioSpringBoot.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente_Venta implements Serializable{

    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public Cliente_Venta() {
    }

    public Cliente_Venta(Long codigo_venta, Double total, int cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
