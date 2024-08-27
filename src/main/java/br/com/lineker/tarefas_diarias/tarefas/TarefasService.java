package br.com.lineker.tarefas_diarias.tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefasService {
    @Autowired
    private TarefasRepository tarefasRepository;

    public List<TarefasModel>listarTodos(){
        return tarefasRepository.findAll();
    }
    public Optional<TarefasModel>buscar(Long id){
        return tarefasRepository.findById(id);
    }
    public TarefasModel salvar(TarefasModel tarefasModel){
        return  tarefasRepository.save(tarefasModel);
    }
    public void deletar(Long id){
        tarefasRepository.deleteById(id);
    }
    public Boolean finalizado(Long id) {
        return tarefasRepository.getReferenceById(id).isFinalizado();
    }

    public TarefasModel atualizar(Long id, TarefasModel tarefasAtualizadas) {
        Optional<TarefasModel> tarefaExistente = tarefasRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            TarefasModel tarefa = tarefaExistente.get();
            tarefa.setSupervisor(tarefasAtualizadas.getSupervisor());
            tarefa.setTecnico(tarefasAtualizadas.getTecnico());
            tarefa.setContrato(tarefasAtualizadas.getContrato());
            tarefa.setPrazoFinal(tarefasAtualizadas.getPrazoFinal());
            tarefa.setFinalizado(tarefasAtualizadas.isFinalizado());
            return tarefasRepository.save(tarefa);
        } else {
            System.out.println("Tarefa não localizada!");
            return null;
        }
    }

}
