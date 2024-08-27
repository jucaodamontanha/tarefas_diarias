package br.com.lineker.tarefas_diarias.tarefas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends JpaRepository <TarefasModel,Long> {
}
