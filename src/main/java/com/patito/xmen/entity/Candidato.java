package com.patito.xmen.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Clase manejo repositorio
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Entity
@Table(name="candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty
    @Column(unique = true)
    String dna;

    Boolean esMutante;

    @Transient
    public String []elementos(){
        String[] split = dna.split(";");
        return split;
    }
}
