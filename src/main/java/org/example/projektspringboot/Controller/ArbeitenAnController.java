package org.example.projektspringboot.Controller;


import org.example.projektspringboot.Domain.ArbeitenAn;
import org.example.projektspringboot.Repository.ArbeitenAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/arbeiten_an")
public class ArbeitenAnController {
    @Autowired
    private ArbeitenAnRepository arbeitenAnRepository;

    @GetMapping
    public List<ArbeitenAn> getAllArbeitenAn() {
        return arbeitenAnRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbeitenAn> getArbeitenAnById(@PathVariable Long id) {
        Optional<ArbeitenAn> arbeitenAn = arbeitenAnRepository.findById(id);
        if (arbeitenAn.isPresent()) {
            return ResponseEntity.ok(arbeitenAn.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ArbeitenAn createArbeitenAn(@RequestBody ArbeitenAn arbeitenAn) {
        return arbeitenAnRepository.save(arbeitenAn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArbeitenAn> updateArbeitenAn(@PathVariable Long id, @RequestBody ArbeitenAn arbeitenAnDetails) {
        Optional<ArbeitenAn> arbeitenAn = arbeitenAnRepository.findById(id);
        if (arbeitenAn.isPresent()) {
            ArbeitenAn updatedArbeitenAn = arbeitenAn.get();
            updatedArbeitenAn.setPolice(arbeitenAnDetails.getPolice());
            updatedArbeitenAn.setVersicherungsart(arbeitenAnDetails.getVersicherungsart());
            return ResponseEntity.ok(arbeitenAnRepository.save(updatedArbeitenAn));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArbeitenAn(@PathVariable Long id) {
        if (arbeitenAnRepository.existsById(id)) {
            arbeitenAnRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
