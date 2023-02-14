package br.com.deltatgn.aulaads.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.deltatgn.aulaads.dto.AlunoDTO;
import br.com.deltatgn.aulaads.model.Aluno;
import br.com.deltatgn.aulaads.repository.AlunoRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoDTO> findAll() {
        List<Aluno> lista = alunoRepository.findAll();
        return lista.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());
    }

    public AlunoDTO findById(Long codigoAluno) {
        Aluno aluno = alunoRepository.findById(codigoAluno).orElseThrow(() -> {
            log.debug("Pesquisar -> Código: {}, Aluno não encontrado.", codigoAluno);
            return new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Código: " + codigoAluno + ", Aluno não encontrado.");
        });

        return new AlunoDTO(aluno);
    }

    public AlunoDTO updateAluno(AlunoDTO alunoDTO) {
        return alunoRepository.findById(alunoDTO.getCodigoAluno()).map(aluno -> {
            aluno.setCodigoAluno(alunoDTO.getCodigoAluno());
            aluno.setNomeAluno(alunoDTO.getNomeAluno().toUpperCase());

            return new AlunoDTO(alunoRepository.save(aluno));
        }).orElseThrow(() -> {
            log.debug("Alterar -> Código: {} - {}, Aluno não encontrado.", alunoDTO.getCodigoAluno(),
                    alunoDTO.getNomeAluno().toUpperCase());
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Código: " + alunoDTO.getCodigoAluno() + " - "
                    + alunoDTO.getNomeAluno().toUpperCase() + ", Aluno não encontrado.");
        });
    }

    public AlunoDTO salvarAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNomeAluno(alunoDTO.getNomeAluno().toUpperCase());
        aluno.setDataCadastro(alunoDTO.getDataCadastro());

        return new AlunoDTO(alunoRepository.save(aluno));
    }

    public void deleteAlunoDTO(Long codigoAluno) {
        alunoRepository.findById(codigoAluno).map(aluno -> {
            alunoRepository.deleteById(codigoAluno);
            return Void.TYPE;
        }).orElseThrow(() -> {
            log.debug("Alterar -> Código: {}, Aluno não encontrado.", codigoAluno);
            return new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Código: " + codigoAluno + ", Aluno não encontrado.");
        });
    }

}
