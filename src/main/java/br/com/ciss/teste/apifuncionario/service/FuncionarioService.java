package br.com.ciss.teste.apifuncionario.service;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import br.com.ciss.teste.apifuncionario.repository.FuncionarioRepository;
import br.com.ciss.teste.apifuncionario.service.exception.RegistroJaCadastradoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Funcionario funcionarioSalvo = repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id");
        return repository.save(funcionarioSalvo);
    }

    public Funcionario savar(Funcionario funcionario) {

        Optional<Funcionario> funcionarioSalvo = repository.findByNisPis(funcionario.getNisPis());

        if (funcionarioSalvo.isPresent()) {
            throw new RegistroJaCadastradoException();
        }

        return repository.save(funcionario);
    }
}
