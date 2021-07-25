package br.com.ciss.teste.apifuncionario.repository;

import br.com.ciss.teste.apifuncionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
