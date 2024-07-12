package org.example.projektspringboot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "versicherungsart")
public class Versicherungsart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String versicherungsartID;

    @NotBlank
    private String art;

    @OneToMany(mappedBy = "versicherungsart")
    @JsonIgnore
    private List<Police> policen;

    @OneToMany(mappedBy = "versicherungsart")
    @JsonIgnore
    private List<ArbeitenAn> arbeitenAn;

    public String getVersicherungsartID() {
        return versicherungsartID;
    }

    public void setVersicherungsartID(String versicherungsartID) {
        this.versicherungsartID = versicherungsartID;
    }

    public @NotBlank String getArt() {
        return art;
    }

    public void setArt(@NotBlank String art) {
        this.art = art;
    }

    public List<Police> getPolicen() {
        return policen;
    }

    public void setPolicen(List<Police> policen) {
        this.policen = policen;
    }

    public List<ArbeitenAn> getArbeitenAn() {
        return arbeitenAn;
    }

    public void setArbeitenAn(List<ArbeitenAn> arbeitenAn) {
        this.arbeitenAn = arbeitenAn;
    }
}
