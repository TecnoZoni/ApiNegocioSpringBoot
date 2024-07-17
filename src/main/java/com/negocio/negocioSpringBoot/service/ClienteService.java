package com.negocio.negocioSpringBoot.service;

import com.negocio.negocioSpringBoot.model.Cliente;
import com.negocio.negocioSpringBoot.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienRepo;

    @Override
    public void crearCliente(Cliente cliente) {
        clienRepo.save(cliente);
    }

    @Override
    public List<Cliente> traerClientes() {
        return clienRepo.findAll();
    }

    @Override
    public Cliente traerCliente(Long id_cliente) {
        return clienRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        clienRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id_cliente) {
        clienRepo.deleteById(id_cliente);
    }
}
