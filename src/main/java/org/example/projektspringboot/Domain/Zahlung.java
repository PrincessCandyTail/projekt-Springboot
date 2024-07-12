package org.example.projektspringboot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "zahlung")
public class Zahlung {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String zahlungID;

    @NotNull
    private Double monatsbetrag;

    @ManyToOne
    @JoinColumn(name = "policeIDFS")
    private Police police;

    public String getZahlungID() {
        return zahlungID;
    }

    public void setZahlungID(String zahlungID) {
        this.zahlungID = zahlungID;
    }

    public @NotNull Double getMonatsbetrag() {
        return monatsbetrag;
    }

    public void setMonatsbetrag(@NotNull Double monatsbetrag) {
        this.monatsbetrag = monatsbetrag;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }
}
