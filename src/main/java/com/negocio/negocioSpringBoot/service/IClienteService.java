package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.model.Cliente;
import java.util.List;

public interface IClienteService {

    public void crearCliente(Cliente cliente);

    public List<Cliente> traerClientes();

    public Cliente traerCliente(Long id_cliente);

    public void editarCliente(Cliente cliente);
    
    public void eliminarCliente(Long id_cliente);

}
