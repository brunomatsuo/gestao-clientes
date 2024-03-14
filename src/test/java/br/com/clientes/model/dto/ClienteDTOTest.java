package br.com.clientes.model.dto;

import br.com.clientes.model.Cliente;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClienteDTOTest {

    private final Cliente cliente = new Cliente(UUID.randomUUID(), "Brasil", "SP", "São Paulo", "12345678900", null, "Bruno II", LocalDate.of(1985, 7, 25), "Rua Teste", "5555-5555", "teste@email.com");
    private final ClienteDTO clienteDTO = new ClienteDTO(UUID.randomUUID(), "Brasil", "SP", "São Paulo", "12345678900", null, "Bruno II", LocalDate.of(1985, 7, 25), "Rua Teste", "5555-5555", "teste@email.com");

    @Test
    void entityToDto() {
        ClienteDTO newClienteDTO = ClienteDTO.entityToDto(cliente);
        clienteDTO.setId(newClienteDTO.getId());

        assertEquals(newClienteDTO, clienteDTO);
    }

    @Test
    void getId() {
        assertThat(clienteDTO.getId()).isNotNull();
    }

    @Test
    void getPaisOrigem() {
        assertEquals(clienteDTO.getPaisOrigem(), "Brasil");
    }

    @Test
    void getEstado() {
        assertEquals(clienteDTO.getEstado(), "SP");
    }

    @Test
    void getCidade() {
        assertEquals(clienteDTO.getCidade(), "São Paulo");
    }

    @Test
    void getCpf() {
        assertEquals(clienteDTO.getCpf(), "12345678900");
    }

    @Test
    void getPassaporte() {
        assertEquals(clienteDTO.getPassaporte(), null);
    }

    @Test
    void getNome() {
        assertEquals(clienteDTO.getNome(), "Bruno II");
    }

    @Test
    void getDataNascimento() {
        assertEquals(clienteDTO.getDataNascimento(), LocalDate.of(1985, 7, 25));
    }

    @Test
    void getEndereco() {
        assertEquals(clienteDTO.getEndereco(), "Rua Teste");
    }

    @Test
    void getTelefone() {
        assertEquals(clienteDTO.getTelefone(), "5555-5555");
    }

    @Test
    void getEmail() {
        assertEquals(clienteDTO.getEmail(), "teste@email.com");
    }
}