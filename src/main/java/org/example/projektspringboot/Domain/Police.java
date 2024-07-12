package org.example.projektspringboot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity

@Table(name = "police")
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String policeID;

    @NotBlank
    private String policenummer;

    @ManyToOne
    @JoinColumn(name = "kundeIDFS")
    @JsonIgnore

    private Kunde kunde;

    @ManyToOne
    @JoinColumn(name = "versicherungIDFS")
    @JsonIgnore
    private Versicherungsart versicherungsart;

    @OneToMany(mappedBy = "police")
    @JsonIgnore
    private List<Zahlung> zahlungen;

    @OneToOne
    @JoinColumn(name = "arbeiterIDFS")
    private Arbeiter arbeiter;

    public String getPoliceID() {
        return policeID;
    }

    public void setPoliceID(String policeID) {
        this.policeID = policeID;
    }

    public @NotBlank String getPolicenummer() {
        return policenummer;
    }

    public void setPolicenummer(@NotBlank String policenummer) {
        this.policenummer = policenummer;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Versicherungsart getVersicherungsart() {
        return versicherungsart;
    }

    public void setVersicherungsart(Versicherungsart versicherungsart) {
        this.versicherungsart = versicherungsart;
    }

    public List<Zahlung> getZahlungen() {
        return zahlungen;
    }

    public void setZahlungen(List<Zahlung> zahlungen) {
        this.zahlungen = zahlungen;
    }

    public Arbeiter getArbeiter() {
        return arbeiter;
    }

    public void setArbeiter(Arbeiter arbeiter) {
        this.arbeiter = arbeiter;
    }
}