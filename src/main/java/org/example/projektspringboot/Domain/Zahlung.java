package org.example.projektspringboot.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "zahlung")
public class Zahlung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zahlungID;

    @NotNull
    private Double monatsbetrag;

    @ManyToOne
    @JoinColumn(name = "policeIDFS")
    private Police police;
}
