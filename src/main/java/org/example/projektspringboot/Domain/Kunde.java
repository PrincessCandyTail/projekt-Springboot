package org.example.projektspringboot.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "kunde")
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kundeID;

    @NotBlank
    private String name;

    @NotBlank
    private String vorname;

    @NotBlank
    private String adresse;

    private Boolean versicherbar;

    private int alter;

    @ManyToOne
    @JoinColumn(name = "arbeiterIDFS")
    private Arbeiter arbeiter;

    @OneToMany(mappedBy = "kunde")
    private List<Police> policen;

}
