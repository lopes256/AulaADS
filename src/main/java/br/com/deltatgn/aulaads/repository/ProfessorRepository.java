package br.com.deltatgn.aulaads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.deltatgn.aulaads.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
