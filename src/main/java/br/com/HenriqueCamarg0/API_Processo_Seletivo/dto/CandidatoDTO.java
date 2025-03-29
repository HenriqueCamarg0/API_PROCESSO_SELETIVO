package br.com.HenriqueCamarg0.API_Processo_Seletivo.dto;

import lombok.Data;

@Data
public class CandidatoDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Double salarioPretendido;
    private String telefone;
    private String linkedin;
    private String gitHub;

}
