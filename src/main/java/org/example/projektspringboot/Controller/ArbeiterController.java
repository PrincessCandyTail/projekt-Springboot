package org.example.projektspringboot.Controller;

import org.example.projektspringboot.Domain.Arbeiter;
import org.example.projektspringboot.Repository.ArbeiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arbeiter")
public class ArbeiterController {
    @Autowired
    private ArbeiterRepository arbeiterRepository;

    @GetMapping
    public List<Arbeiter> getAllArbeiter() {
        return arbeiterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arbeiter> getArbeiterById(@PathVariable Long id) {
        Optional<Arbeiter> arbeiter = arbeiterRepository.findById(id);
        if (arbeiter.isPresent()) {
            return ResponseEntity.ok(arbeiter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Arbeiter createArbeiter(@RequestBody Arbeiter arbeiter) {
        return arbeiterRepository.save(arbeiter);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Arbeiter> updateArbeiter(@PathVariable Long id, @RequestBody Arbeiter arbeiterDetails) {
        Optional<Arbeiter> arbeiter = arbeiterRepository.findById(id);
        if (arbeiter.isPresent()) {
            Arbeiter updatedArbeiter = arbeiter.get();
            updatedArbeiter.setName(arbeiterDetails.getName());
            updatedArbeiter.setAbteilung(arbeiterDetails.getAbteilung());
            return ResponseEntity.ok(arbeiterRepository.save(updatedArbeiter));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArbeiter(@PathVariable Long id) {
        if (arbeiterRepository.existsById(id)) {
            arbeiterRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
