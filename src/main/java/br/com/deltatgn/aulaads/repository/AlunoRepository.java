package br.com.deltatgn.aulaads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.deltatgn.aulaads.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
