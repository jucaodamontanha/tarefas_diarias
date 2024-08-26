package br.com.lineker.tarefas_diarias.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public List<CadastroModel> listarTodos() {
        return cadastroRepository.findAll();
    }
    public Optional<CadastroModel> buscar(UUID id){
        return cadastroRepository.findById(id);
    }

    public CadastroModel salvar(CadastroModel cadastroModel) {
        return cadastroRepository.save(cadastroModel);
    }

    public CadastroModel atualizar(UUID id, CadastroModel cadastroModel) {
        return cadastroRepository.findById(id).map(existingCadastro -> {
            existingCadastro.setNomeCompleto(cadastroModel.getNomeCompleto());
            existingCadastro.setEmail(cadastroModel.getEmail());
            existingCadastro.setSenha(cadastroModel.getSenha());
            return cadastroRepository.save(existingCadastro);
        }).orElseThrow(() -> new RuntimeException("Cadastro não encontrado"));
    }
    public void deletar (UUID id){
        cadastroRepository.deleteById(id);
    }

    public Optional<CadastroModel> autenticar(String email, String senha) {
        return cadastroRepository.findByEmail(email).filter(cadastro -> cadastro.getSenha().equals(senha));
    }
}
