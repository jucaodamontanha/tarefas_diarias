package br.com.lineker.tarefas_diarias.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {


    @Autowired
    private TarefasService tarefasService;

    @GetMapping
    public List<TarefasModel> listarTodos() {
        return tarefasService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefasModel> buscar(@PathVariable Long id) {
        Optional<TarefasModel> tarefa = tarefasService.buscar(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TarefasModel salvar(@RequestBody TarefasModel tarefasModel) {
        return tarefasService.salvar(tarefasModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefasModel> atualizar(@PathVariable Long id, @RequestBody TarefasModel tarefasAtualizadas) {
        TarefasModel tarefaAtualizada = tarefasService.atualizar(id, tarefasAtualizadas);
        if (tarefaAtualizada != null) {
            return ResponseEntity.ok(tarefaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefasService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/finalizado")
    public ResponseEntity<Boolean> finalizado(@PathVariable Long id) {
        Boolean isFinalizado = tarefasService.finalizado(id);
        return ResponseEntity.ok(isFinalizado);
    }
}

