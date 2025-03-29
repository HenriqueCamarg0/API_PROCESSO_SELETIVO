package br.com.HenriqueCamarg0.API_Processo_Seletivo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.dto.CandidatoDTO;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.model.Candidato;
import br.com.HenriqueCamarg0.API_Processo_Seletivo.service.CandidatoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/formulario")
@AllArgsConstructor
@CrossOrigin
public class ControllerService {

    private final CandidatoService service; 

    @PostMapping("/cadastrar-candidato")
    public ResponseEntity<Candidato> cadastrar(@RequestBody CandidatoDTO dto) {
        Candidato candidato = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidato);
    }

    @PutMapping("/atualizar-candidato/{id}")
    public ResponseEntity<Candidato> atualizar(@PathVariable Long id, @RequestBody CandidatoDTO dto) {
        Candidato candidato = service.atualizar(id, dto);
        return ResponseEntity.ok(candidato);
    }

    @GetMapping("/lista-de-candidatos")
    public ResponseEntity<List<Candidato>> listarTodos() {
        List<Candidato> candidatos = service.listarTodos();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("/buscar-candidato/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
        Candidato candidato = service.buscarPorId(id);
        return ResponseEntity.ok(candidato);
    }

    @DeleteMapping("/deletar-candidato/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}