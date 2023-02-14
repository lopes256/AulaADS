package br.com.deltatgn.aulaads.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.deltatgn.aulaads.dto.ProfessorDTO;
import br.com.deltatgn.aulaads.model.Professor;
import br.com.deltatgn.aulaads.repository.ProfessorRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorDTO> findAll() {
        List<Professor> lista = professorRepository.findAll();
        return lista.stream().map(x -> new ProfessorDTO(x)).collect(Collectors.toList());
    }

    public ProfessorDTO findById(Long codigoProfessor) {
        Professor professor = professorRepository.findById(codigoProfessor).orElseThrow(() -> {
            log.debug("Pesquisar -> Código: {}, Professor não encontrado.", codigoProfessor);
            return new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Código: " + codigoProfessor + ", Proferssor não encontrado.");
        });

        return new ProfessorDTO(professor);
    }

    public ProfessorDTO updaProfessor(ProfessorDTO professorDTO) {
        return professorRepository.findById(professorDTO.getCodigoProfessor()).map(professor -> {
            professor.setCodigoProfessor(professorDTO.getCodigoProfessor());
            professor.setNomeProfessor(professorDTO.getNomeProfessor().toUpperCase());

            return new ProfessorDTO(professorRepository.save(professor));
        }).orElseThrow(() -> {
            log.debug("Alterar -> Código: {} - {}, Professor não encontrado.", professorDTO.getCodigoProfessor(),
                    professorDTO.getNomeProfessor().toUpperCase());
            return new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Código: " + professorDTO.getCodigoProfessor() + " - "
                            + professorDTO.getNomeProfessor().toUpperCase() + ", Professor não encontrado.");
        });
    }

    public ProfessorDTO salvaProfessorDTO(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setNomeProfessor(professorDTO.getNomeProfessor().toUpperCase());
        professor.setDataCadastro(new Date());

        return new ProfessorDTO(professorRepository.save(professor));
    }

    public void deleteProfessor(Long codigoProfessor) {
        professorRepository.findById(codigoProfessor).map(professor -> {
            professorRepository.deleteById(codigoProfessor);
            return Void.TYPE;
        }).orElseThrow(() -> {
            log.debug("Alterar -> Código: {}, Professor não encontrado.", codigoProfessor);
            return new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Código: " + codigoProfessor + ", Professor não encontrado.");
        });
    }
}
