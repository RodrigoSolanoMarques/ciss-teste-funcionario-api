package br.com.ciss.teste.apifuncionario.repository;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNisPis(String nisPis);
}
