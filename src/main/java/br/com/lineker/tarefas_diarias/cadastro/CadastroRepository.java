package br.com.lineker.tarefas_diarias.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CadastroRepository extends JpaRepository <CadastroModel, UUID> {
   Optional<CadastroModel>  findByEmail(String email);

}
