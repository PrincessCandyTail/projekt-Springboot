package org.example.projektspringboot.Domain;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "arbeiten_an")
public class ArbeitenAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "policeIDFS")
    private Police police;

    @ManyToOne
    @JoinColumn(name = "versicherungsartIDFS")
    private Versicherungsart versicherungsart;

}
