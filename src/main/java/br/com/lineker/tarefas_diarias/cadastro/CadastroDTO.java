package br.com.lineker.tarefas_diarias.cadastro;

import jakarta.validation.constraints.Email;

import java.util.UUID;

public record CadastroDTO( UUID id,
                           String nomeCompleto,
                           String email,
                           String senha) {

}
