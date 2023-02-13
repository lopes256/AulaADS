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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "cadastro", name = "professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_professor")
    private Long codigoProfessor;

    @Column(name = "nome_professor", length = 100, nullable = false)
    private String nomeProfessor;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

}
