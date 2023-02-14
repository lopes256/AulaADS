package br.com.deltatgn.aulaads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.deltatgn.aulaads.dto.ProfessorDTO;
import br.com.deltatgn.aulaads.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProfessorDTO>> listarProfessores() {
        List<ProfessorDTO> lista = professorService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{codigoProfessor}")
    @Transactional(readOnly = true)
    public ProfessorDTO pesquisar(@PathVariable Long codigoProfessor) {
        return professorService.findById(codigoProfessor);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO salvaProfessorDTO(@RequestBody ProfessorDTO professorDTO) {
        return professorService.salvaProfessorDTO(professorDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO alteraProfessor(ProfessorDTO professorDTO) {
        return professorService.updaProfessor(professorDTO);
    }

    @DeleteMapping("/{codigoProfessor}")
    public void deleteProfessor(@PathVariable Long codigoProfessor) {
        professorService.deleteProfessor(codigoProfessor);
    }

}
