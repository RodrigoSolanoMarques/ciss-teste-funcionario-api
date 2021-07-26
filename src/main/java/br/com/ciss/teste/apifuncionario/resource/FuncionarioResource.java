package br.com.ciss.teste.apifuncionario.resource;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import br.com.ciss.teste.apifuncionario.repository.FuncionarioRepository;
import br.com.ciss.teste.apifuncionario.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Api(value = "Funcionario")
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService service;

    @ApiOperation(value = "Mostra lista de funcionarios")
    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    @ApiOperation(value = "Cria um funcionario")
    @PostMapping
    public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario) {

        Funcionario funcionarioCriado = service.savar(funcionario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(funcionarioCriado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(funcionarioCriado);
    }

    @ApiOperation(value = "Busca um funcionario pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPeloId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Busca um funcionario pelo NIS/PIS")
    @GetMapping("/nispis/{nisPis}")
    public ResponseEntity<Funcionario> buscarPeloNisPis(@PathVariable String nisPis) {
        return repository.findByNisPis(nisPis)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Atualiza um funcionario")
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Funcionario funcionario) {

        Funcionario funcionarioSalvo = service.atualizar(id, funcionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }

    @ApiOperation(value = "Remove um funcionario")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
