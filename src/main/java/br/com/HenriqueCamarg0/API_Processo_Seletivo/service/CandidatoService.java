package br.com.HenriqueCamarg0.API_Processo_Seletivo.service;


import java.util.List;

import org.springframework.stereotype.Service;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.dto.CandidatoDTO;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.model.Candidato;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.model.StatusCandidato;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    //Cadastro de candidato
    public Candidato cadastrar(CandidatoDTO dto) {
        Candidato candidato = new Candidato();
        candidato.setNome(dto.getNome()); 
        candidato.setEmail(dto.getEmail());
        candidato.setTelefone(dto.getTelefone());
        candidato.setCpf(dto.getCpf());
        candidato.setSalarioPretendido(dto.getSalarioPretendido());
        candidato.setLinkedin(dto.getLinkedin());
        candidato.setGitHub(dto.getGitHub());

        return candidatoRepository.save(candidato); 
    }

    //Atualizar candidato
    public Candidato atualizar(Long id, CandidatoDTO dto) {
        Candidato candidato = candidatoRepository.findById(id).orElseThrow();
        candidato.setNome(dto.getNome());
        candidato.setEmail(dto.getEmail());
        candidato.setTelefone(dto.getTelefone());
        candidato.setCpf(dto.getCpf());
        candidato.setSalarioPretendido(dto.getSalarioPretendido());
        candidato.setLinkedin(dto.getLinkedin());
        candidato.setGitHub(dto.getGitHub());
        candidato.setStatus(StatusCandidato.EM_ANALISE);

        return candidatoRepository.save(candidato);
    }

    //Listar todos os candidatos
    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    //Buscar candidato por ID
    public Candidato buscarPorId(Long id) {
        return candidatoRepository.findById(id).orElseThrow();
    }

    //Deletar candidato
    public void deletar(Long id) {
        candidatoRepository.deleteById(id);
    }
}
