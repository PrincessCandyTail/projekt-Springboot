package org.example.projektspringboot.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "arbeiter")
public class Arbeiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arbeiterID;

    @NotBlank
    private String name;

    @NotBlank
    private String abteilung;

    @OneToOne(mappedBy = "arbeiter")
    private Police police;
}
