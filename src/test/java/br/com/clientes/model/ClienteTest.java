package br.com.clientes.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ClienteTest {

    private final Cliente cliente = new Cliente(UUID.randomUUID(), "Brasil", "SP", "São Paulo", "12345678900", null, "Bruno II", LocalDate.of(1985, 7, 25), "Rua Teste", "5555-5555", "teste@email.com");

    @Test
    void shouldGetId() {
        assertThat(cliente.getId()).isNotNull();
    }

    @Test
    void shouldGetPais() {
        assertThat(cliente.getPaisOrigem()).isNotNull();
    }

    @Test
    void shouldGetEstado() {
        assertThat(cliente.getEstado()).isNotNull();
    }

    @Test
    void shouldGetCidade() {
        assertThat(cliente.getCidade()).isNotNull();
    }

    @Test
    void shouldGetCpf() {
        assertThat(cliente.getCpf()).isNotNull();
    }

    @Test
    void shouldGetPassaporte() {
        assertThat(cliente.getPassaporte()).isNull();
    }

    @Test
    void shouldGetNome() {
        assertThat(cliente.getNome()).isNotNull();
    }

    @Test
    void shouldGetDataNascimento() {
        assertThat(cliente.getDataNascimento()).isNotNull();
    }

    @Test
    void shouldGetEndereco() {
        assertThat(cliente.getEndereco()).isNotNull();
    }

    @Test
    void shouldGetTelefone() {
        assertThat(cliente.getTelefone()).isNotNull();
    }

    @Test
    void shouldGetEmail() {
        assertThat(cliente.getEmail()).isNotNull();
    }
}
