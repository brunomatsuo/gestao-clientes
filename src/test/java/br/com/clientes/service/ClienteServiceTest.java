package br.com.clientes.service;

import br.com.clientes.model.Cliente;
import br.com.clientes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll() {
        Cliente cliente1 = new Cliente(UUID.randomUUID(), "Brasil", "SP", "São Paulo", "12345678900", null, "Bruno II", LocalDate.of(1985, 7, 25), "Rua Teste", "5555-5555", "teste@email.com");
        Cliente cliente2 = new Cliente(UUID.randomUUID(), "Panamá", "WW", "Panama City", null, "FT59462", "Pablo Manito", LocalDate.of(1992, 6, 13), "Rua Papito", "5555-5225", "teste2@email.com");
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        Mockito.when(clienteRepository.findAll()).thenReturn(List.of(cliente1, cliente2));

        List<Cliente> clienteList = clienteRepository.findAll();

        assertEquals(clientes, clienteList);
    }

    @Test
    void getById() {
        Cliente cliente = new Cliente(UUID.randomUUID(), "Panamá", "WW", "Panama City", null, "FT59462", "Pablo Manito", LocalDate.of(1992, 6, 13), "Rua Papito", "5555-5225", "teste2@email.com");
        clienteRepository.save(cliente);

        Mockito.when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));

        Cliente result = clienteRepository.findById(cliente.getId()).orElse(null);

        assertEquals(cliente, result);
    }

    @Test
    void createCliente() {
        Cliente cliente = new Cliente(UUID.randomUUID(), "Panamá", "WW", "Panama City", null, "FT59462", "Pablo Manito", LocalDate.of(1992, 6, 13), "Rua Papito", "5555-5225", "teste2@email.com");

        Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteRepository.save(cliente);

        assertEquals(cliente, result);
    }

    @Test
    void updateCliente() {
        Cliente cliente = new Cliente(UUID.randomUUID(), "Panamá", "WW", "Panama City", null, "FT59462", "Pablo Manito", LocalDate.of(1992, 6, 13), "Rua Papito", "5555-5225", "teste2@email.com");
        clienteRepository.save(cliente);

        cliente.setNome("Pablito da Mama");

        Mockito.when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));

        clienteRepository.save(cliente);
        Cliente result = clienteRepository.findById(cliente.getId()).orElse(null);

        assertEquals(cliente, result);
    }

    @Test
    void deleteCliente() {
        Cliente cliente = new Cliente(UUID.randomUUID(), "Panamá", "WW", "Panama City", null, "FT59462", "Pablo Manito", LocalDate.of(1992, 6, 13), "Rua Papito", "5555-5225", "teste2@email.com");
        clienteRepository.save(cliente);

        Mockito.when(clienteRepository.findById(cliente.getId())).thenReturn(null);

        clienteRepository.deleteById(cliente.getId());
        Optional<Cliente> result = clienteRepository.findById(cliente.getId());

        assertEquals(null, result);
    }
}
