package br.com.deltatgn.aulaads.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.deltatgn.aulaads.dto.AlunoDTO;
import br.com.deltatgn.aulaads.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        List<AlunoDTO> lista = alunoService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{codigoAluno}")
    @Transactional(readOnly = true)
    public AlunoDTO pesquisar(@PathVariable Long codigoAluno) {
        return alunoService.findById(codigoAluno);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO salvarNovoAluno(@RequestBody @Validated AlunoDTO alunoDTO) {
        return alunoService.salvarAlunoDTO(alunoDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO alterarAluno(@RequestBody @Validated AlunoDTO alunoDTO) {
        return alunoService.updateAluno(alunoDTO);
    }

    @DeleteMapping("/{codigoAluno}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable Long codigoAluno) {
        alunoService.deleteAlunoDTO(codigoAluno);
    }
}
