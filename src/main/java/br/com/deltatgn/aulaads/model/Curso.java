package br.com.deltatgn.aulaads.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "cadastro", name = "curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_curso")
    private Long codigoCurso;

    @Column(name = "nome_curso", length = 100, nullable = false)
    private String nomeCurso;

    @Column(name = "hora_aula")
    private Integer horaAula;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_final")
    private Date dataFinal;

}
