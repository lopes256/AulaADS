package br.com.deltatgn.aulaads.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorDTO {
    
    private Long codigoProfessor;
    private String nomeProfessor;
    private Date dataCadastro;
}
