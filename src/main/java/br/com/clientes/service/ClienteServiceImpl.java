package br.com.clientes.service;

import br.com.clientes.model.Cliente;
import br.com.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getById(String id) {
        UUID convertedId = UUID.fromString(id);
        return clienteRepository.findById(convertedId).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        Cliente existe = new Cliente();
        if(cliente.getCpf() != null) {
            existe = clienteRepository.findByCpf(cliente.getCpf()).orElse(null);
        }
        if(cliente.getPassaporte() != null) {
            existe = clienteRepository.findByPassaporte(cliente.getPassaporte()).orElse(null);
        }
        if(existe == null) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente edit(Cliente cliente, String id) {
        UUID convertedId = UUID.fromString(id);
        Cliente existe = clienteRepository.findById(convertedId).orElse(null);
        if(existe != null) {
            cliente.setId(existe.getId());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void remove(String id) {
        UUID convertedId = UUID.fromString(id);
        Cliente existe = clienteRepository.findById(convertedId).orElse(null);
        if(existe != null) {
            clienteRepository.deleteById(convertedId);
        }
    }
}
