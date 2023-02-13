package br.com.deltatgn.aulaads.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "aulas")
public class Aulas {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private AulasId aulasId;


//    private Professor professor;

}
