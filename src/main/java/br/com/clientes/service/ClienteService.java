package br.com.clientes.service;

import br.com.clientes.model.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente getById(String id);
    Cliente save(Cliente cliente);
    Cliente edit(Cliente cliente, String id);
    void remove(String id);
}
