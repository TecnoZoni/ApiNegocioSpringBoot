package com.negocio.negocioSpringBoot.controller;

import com.negocio.negocioSpringBoot.model.Cliente;
import com.negocio.negocioSpringBoot.service.IClienteService;
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
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/clientes/crear")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        clienteService.crearCliente(cliente);
        return ResponseEntity.ok("El cliente se creo correctamente");
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerClientes() {
        List<Cliente> listaClientes = clienteService.traerClientes();
        return ResponseEntity.ok(listaClientes);
    }

    @GetMapping("/clientes/{id_cliente}")
    public ResponseEntity<Cliente> traerCliente(@PathVariable Long id_cliente) {
        Cliente cliente = clienteService.traerCliente(id_cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public ResponseEntity<String> eliminarCLiente(@PathVariable Long id_cliente) {
        clienteService.eliminarCliente(id_cliente);
        return ResponseEntity.ok("El cliente se elimino correctamente.");
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public ResponseEntity<String> editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente) {
        clienteService.editarCliente(id_cliente, cliente.getNombre(), cliente.getApellido(), cliente.getDni());
        return ResponseEntity.ok("El cliente se edito correctamente.");
    }
}
