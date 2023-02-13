package br.com.deltatgn.aulaads.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AulasId implements Serializable {

    private static final long serialVersionUID = -8383857710790100792L;

    @EqualsAndHashCode.Include
    @Column(name = "codigo_professor")
    private Long codigoProfessor;

    @EqualsAndHashCode.Include
    @Column(name = "codigo_curso")
    private Long codigoCurso;

}
