package org.example.projektspringboot.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "kunde")
public class Versicherungsart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long versicherungsartID;

    @NotBlank
    private String art;

    @OneToMany(mappedBy = "versicherungsart")
    private List<Police> policen;

    @OneToMany(mappedBy = "versicherungsart")
    private List<ArbeitenAn> arbeitenAn;

}
