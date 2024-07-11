package org.example.projektspringboot.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "police")
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policeID;

    @NotBlank
    private String policenummer;

    @ManyToOne
    @JoinColumn(name = "kundeIDFS")
    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "versicherungIDFS")
    private Versicherungsart versicherungsart;

    @OneToMany(mappedBy = "police")
    private List<Zahlung> zahlungen;

    @OneToOne
    @JoinColumn(name = "arbeiterIDFS")
    private Arbeiter arbeiter;
}