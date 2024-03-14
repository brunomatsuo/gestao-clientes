package br.com.clientes.model.dto;

import br.com.clientes.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
public class ClienteDTO {
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

    public static ClienteDTO entityToDto(Cliente cliente) {
        if(cliente != null) {
            ClienteDTO dto = buildMapper().convertValue(cliente, ClienteDTO.class);
            return dto;
        }
        return null;
    }

    private static ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule=new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE));
        mapper.registerModule(javaTimeModule);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }
}
