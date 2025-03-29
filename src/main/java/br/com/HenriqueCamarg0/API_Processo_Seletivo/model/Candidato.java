package br.com.HenriqueCamarg0.API_Processo_Seletivo.model;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
@Table(name = "candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Column(nullable = false)
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Column(nullable = false)
    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "O salário pretendido não pode ser nulo")
    @Positive(message = "O salário pretendido deve ser positivo")
    private Double salarioPretendido;

    @Column(nullable = false)
    @NotNull(message = "O telefone não pode ser nulo")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @Column(nullable = false)
    @NotNull(message = "O LinkedIn não pode ser nulo")
    @Pattern(regexp = "https://www\\.linkedin\\.com/.*", message = "O LinkedIn deve ser uma URL válida")
    private String linkedin;

    @Column(nullable = false)
    @NotNull(message = "O GitHub não pode ser nulo")
    @Pattern(regexp = "https://github\\.com/.*", message = "O GitHub deve ser uma URL válida")
    private String gitHub;

    private StatusCandidato status = StatusCandidato.EM_ANALISE;


}
