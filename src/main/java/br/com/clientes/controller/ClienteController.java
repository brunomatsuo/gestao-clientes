package br.com.clientes.controller;

import br.com.clientes.model.Cliente;
import br.com.clientes.model.dto.ClienteDTO;
import br.com.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity getAll() {
        List<ClienteDTO> clientes = clienteService.getAll().stream().map(ClienteDTO::entityToDto).collect(Collectors.toList());
        if(clientes.size() > 0) {
            return ResponseEntity.ok(clientes);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        ClienteDTO cliente = ClienteDTO.entityToDto(clienteService.getById(id));
        if(cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Cliente cliente) {
        ClienteDTO created = ClienteDTO.entityToDto(clienteService.save(cliente));
        if(created != null) {
            return ResponseEntity.created(URI.create(created.getId().toString())).body(created);
        }
        return ResponseEntity.badRequest().body("Ocorreu um erro ao criar o cliente. Verifique os dados inseridos.");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Cliente cliente, @PathVariable String id) {
        ClienteDTO edited = ClienteDTO.entityToDto(clienteService.edit(cliente, id));
        if(edited != null) {
            return ResponseEntity.ok(edited);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        clienteService.remove(id);
        return ResponseEntity.ok().build();
    }

}
