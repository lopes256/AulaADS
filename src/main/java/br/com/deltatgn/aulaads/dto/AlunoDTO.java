package br.com.deltatgn.aulaads.dto;

import java.util.Date;

import br.com.deltatgn.aulaads.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoDTO {

    private Long codigoAluno;
    private String nomeAluno;
    private Date dataCadastro;

    public AlunoDTO(Aluno aluno) {
        codigoAluno = aluno.getCodigoAluno();
        nomeAluno = aluno.getNomeAluno().toUpperCase();
        dataCadastro = aluno.getDataCadastro();
    }
    
}
