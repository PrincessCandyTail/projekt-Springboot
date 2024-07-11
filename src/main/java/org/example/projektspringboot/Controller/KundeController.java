package org.example.projektspringboot.Controller;

import org.example.projektspringboot.Domain.Kunde;
import org.example.projektspringboot.Repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kunden")
public class KundeController {
    @Autowired
    private KundeRepository kundeRepository;


    @GetMapping
    public List<Kunde> getAllKunden() {
        return kundeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable Long id) {
        Optional<Kunde> kunde = kundeRepository.findById(id);
        if (kunde.isPresent()) {
            return ResponseEntity.ok(kunde.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Kunde createKunde(@RequestBody Kunde kunde) {
        return kundeRepository.save(kunde);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kunde> updateKunde(@PathVariable Long id, @RequestBody Kunde kundeDetails) {
        Optional<Kunde> kunde = kundeRepository.findById(id);
        if (kunde.isPresent()) {
            Kunde updatedKunde = kunde.get();
            updatedKunde.setName(kundeDetails.getName());
            updatedKunde.setVorname(kundeDetails.getVorname());
            updatedKunde.setAdresse(kundeDetails.getAdresse());
            updatedKunde.setVersicherbar(kundeDetails.getVersicherbar());
            updatedKunde.setAlter(kundeDetails.getAlter());
            return ResponseEntity.ok(kundeRepository.save(updatedKunde));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKunde(@PathVariable Long id) {
        if (kundeRepository.existsById(id)) {
            kundeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

