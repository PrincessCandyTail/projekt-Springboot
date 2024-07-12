package org.example.projektspringboot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity

@Table(name = "kunde")
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String vorname;

    @NotBlank
    private String adresse;

    private Boolean versicherbar;

    @Column(name = "`alter`")
    private int alter;

    @ManyToOne
    @JoinColumn(name = "arbeiter_id")
    @JsonIgnore
    private Arbeiter arbeiter;

    @OneToMany(mappedBy = "kunde")
    @JsonIgnore
    private List<Police> policen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getVorname() {
        return vorname;
    }

    public void setVorname(@NotBlank String vorname) {
        this.vorname = vorname;
    }

    public @NotBlank String getAdresse() {
        return adresse;
    }

    public void setAdresse(@NotBlank String adresse) {
        this.adresse = adresse;
    }

    public Boolean getVersicherbar() {
        return versicherbar;
    }

    public void setVersicherbar(Boolean versicherbar) {
        this.versicherbar = versicherbar;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public Arbeiter getArbeiter() {
        return arbeiter;
    }

    public void setArbeiter(Arbeiter arbeiter) {
        this.arbeiter = arbeiter;
    }

    public List<Police> getPolicen() {
        return policen;
    }

    public void setPolicen(List<Police> policen) {
        this.policen = policen;
    }

}
