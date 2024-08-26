package br.com.lineker.tarefas_diarias.cadastro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;
    @GetMapping
    public List<CadastroModel> getAllCadastroModel(){
        return cadastroService.listarTodos();
    }
    @GetMapping("/{id}")
    public Optional<CadastroModel> buscar (@PathVariable UUID id){
        return cadastroService.buscar(id);
    }
    @PostMapping
    public CadastroModel createCadastroModel(@RequestBody CadastroModel cadastroModel){
        return cadastroService.salvar(cadastroModel);
    }
    @PutMapping("/{id}")
    public CadastroModel atualizar(@PathVariable UUID id, @RequestBody CadastroModel cadastroModel) {
        return cadastroService.atualizar(id, cadastroModel);
    }
    @DeleteMapping("/{id}")
    public void deleteCadastroModel(@PathVariable UUID id){
     cadastroService.deletar(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody CadastroModel cadastroModel) {
        Optional<CadastroModel> usuarioAutenticado = cadastroService.autenticar(cadastroModel.getEmail(), cadastroModel.getSenha());
        if (usuarioAutenticado.isPresent()) {
            return "Login bem-sucedido!";
        } else {
            return "Falha no login. Verifique suas credenciais.";
        }
    }

}
