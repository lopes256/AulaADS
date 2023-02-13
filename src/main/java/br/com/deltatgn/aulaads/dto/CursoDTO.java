package br.com.deltatgn.aulaads.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoDTO {

    private Long codigoCurso;
    private String nomeCurso;
    private Date dataInicio;
    private Date dataFinal;

}
