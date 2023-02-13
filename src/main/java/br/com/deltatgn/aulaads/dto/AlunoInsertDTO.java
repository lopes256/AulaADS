package br.com.deltatgn.aulaads.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoInsertDTO {

    private String nomeAluno;
    private Date dataCadastro;
    
}
