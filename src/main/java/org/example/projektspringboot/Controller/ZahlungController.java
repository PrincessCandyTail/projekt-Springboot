package org.example.projektspringboot.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projektspringboot.Domain.Zahlung;
import org.example.projektspringboot.Repository.ZahlungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zahlungen")
@Tag(name = "ZahlungController", description = "Endpoints for managing 'ZahlungController' entities")

public class ZahlungController {


    @Autowired
    private ZahlungRepository zahlungRepository;

    @GetMapping
    public List<Zahlung> getAllZahlungen() {
        return zahlungRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zahlung> getZahlungById(@PathVariable Long id) {
        Optional<Zahlung> zahlung = zahlungRepository.findById(id);
        if (zahlung.isPresent()) {
            return ResponseEntity.ok(zahlung.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Zahlung createZahlung(@RequestBody Zahlung zahlung) {
        return zahlungRepository.save(zahlung);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zahlung> updateZahlung(@PathVariable Long id, @RequestBody Zahlung zahlungDetails) {
        Optional<Zahlung> zahlung = zahlungRepository.findById(id);
        if (zahlung.isPresent()) {
            Zahlung updatedZahlung = zahlung.get();
            updatedZahlung.setMonatsbetrag(zahlungDetails.getMonatsbetrag());
            updatedZahlung.setPolice(zahlungDetails.getPolice());
            return ResponseEntity.ok(zahlungRepository.save(updatedZahlung));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZahlung(@PathVariable Long id) {
        if (zahlungRepository.existsById(id)) {
            zahlungRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
