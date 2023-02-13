package br.com.deltatgn.aulaads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.deltatgn.aulaads.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
