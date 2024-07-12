package org.example.projektspringboot.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "arbeiter")
public class Arbeiter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String arbeiterID;

    @NotBlank
    private String name;

    @NotBlank
    private String abteilung;

    @OneToOne(mappedBy = "arbeiter")
    @JsonIgnore

    private Police police;

    public String getArbeiterID() {
        return arbeiterID;
    }

    public void setArbeiterID(String arbeiterID) {
        this.arbeiterID = arbeiterID;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(@NotBlank String abteilung) {
        this.abteilung = abteilung;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }
}
