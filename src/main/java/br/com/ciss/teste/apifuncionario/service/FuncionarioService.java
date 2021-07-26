package br.com.ciss.teste.apifuncionario.service;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import br.com.ciss.teste.apifuncionario.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
}
