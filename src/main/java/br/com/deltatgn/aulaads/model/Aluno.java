package br.com.deltatgn.aulaads.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "cadastro", name = "aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAluno;

    @Column(name = "nome_aluno", length = 50)
    private String nomeAluno;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    public Aluno() {
    }

    public Aluno(Long codigoAluno, String nomeAluno, Date dataCadastro) {
        this.codigoAluno = codigoAluno;
        this.nomeAluno = nomeAluno;
        this.dataCadastro = dataCadastro;
    }

    public Long getCodigoAluno() {
        return codigoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setCodigoAluno(Long codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
