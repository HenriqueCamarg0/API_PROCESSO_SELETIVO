package br.com.HenriqueCamarg0.API_Processo_Seletivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.HenriqueCamarg0.API_Processo_Seletivo.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
