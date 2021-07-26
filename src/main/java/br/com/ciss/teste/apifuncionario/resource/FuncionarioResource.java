package br.com.ciss.teste.apifuncionario.resource;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import br.com.ciss.teste.apifuncionario.repository.FuncionarioRepository;
import br.com.ciss.teste.apifuncionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPeloId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Funcionario funcionario) {

        Funcionario funcionarioSalvo = service.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }
}
