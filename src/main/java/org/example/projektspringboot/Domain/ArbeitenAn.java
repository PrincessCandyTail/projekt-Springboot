package org.example.projektspringboot.Domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name = "arbeiten_an")
public class ArbeitenAn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "policeIDFS")

    private Police police;

    @ManyToOne
    @JoinColumn(name = "versicherungsartIDFS")

    private Versicherungsart versicherungsart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

    public Versicherungsart getVersicherungsart() {
        return versicherungsart;
    }

    public void setVersicherungsart(Versicherungsart versicherungsart) {
        this.versicherungsart = versicherungsart;
    }
}
