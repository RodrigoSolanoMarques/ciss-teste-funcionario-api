package br.com.ciss.teste.apifuncionario.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30)
    @NotBlank(message = "Nome é obrigatório")
    @Column(unique = true)
    private String nome;

    @Size(min = 2, max = 50)
    @NotBlank(message = "Sobrenome é obrigatório")
    @Column(unique = true)
    private String sobrenome;

    @NotNull
    @Email(message = "Endereço de e-mail enviado em um formato inválido.")
    private String email;

    @CPF
    @Pattern(regexp = "([0-9]{11})", message = "{funcionario.nis_pis.invalid}")
    @NotNull(message = "O NIS/PIS é obrigatório")
    @Column(unique = true)
    private String nis_pis;
}
