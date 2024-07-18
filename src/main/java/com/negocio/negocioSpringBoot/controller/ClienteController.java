package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.model.Cliente;
import com.negocio.negocioSpringBoot.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return "El cliente se creo correctamente";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> traerClientes() {
        return clienteService.traerClientes();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente) {
        return clienteService.traerCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String eliminarCLiente(@PathVariable Long id_cliente) {
        clienteService.eliminarCliente(id_cliente);
        return "El cliente se elimino correctamente.";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public String editarCliente(@PathVariable Long id_cliente,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni) {
        
        clienteService.editarCliente(id_cliente, nuevoNombre, nuevoApellido, nuevoDni);
        
        return "El cliente se edito correctamente.";
    }
}
