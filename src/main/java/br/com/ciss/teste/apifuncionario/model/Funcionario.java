package br.com.ciss.teste.apifuncionario.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

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

    @Pattern(regexp = "([0-9]{11})", message = "{funcionario.nis_pis.invalid}")
    @NotNull(message = "O NIS/PIS é obrigatório")
    @Column(name = "nis_pis", unique = true)
    private String nisPis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNisPis() {
        return nisPis;
    }

    public void setNisPis(String nis_pis) {
        this.nisPis = nis_pis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
