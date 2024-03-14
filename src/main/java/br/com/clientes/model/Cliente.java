package br.com.clientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String paisOrigem;
    private String estado;
    private String cidade;
    private String cpf;
    private String passaporte;
    private String nome;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
}
