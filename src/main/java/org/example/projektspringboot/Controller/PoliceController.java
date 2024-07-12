package org.example.projektspringboot.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projektspringboot.Domain.Police;
import org.example.projektspringboot.Repository.PoliceRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policen")
@Tag(name = "PoliceController", description = "Endpoints for managing 'PoliceController' entities")

public class PoliceController {

    @Autowired

    private PoliceRepositroy policeRepository;

    @GetMapping
    public List<Police> getAllPolicen() {
        return policeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Police> getPoliceById(@PathVariable Long id) {
        Optional<Police> police = policeRepository.findById(id);
        if (police.isPresent()) {
            return ResponseEntity.ok(police.get());
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Police createPolice(@RequestBody Police police) {
        return policeRepository.save(police);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Police> updatePolice(@PathVariable Long id, @RequestBody Police policeDetails) {
        Optional<Police> police = policeRepository.findById(id);
        if (police.isPresent()) {
            Police updatedPolice = police.get();
            updatedPolice.setPolicenummer(policeDetails.getPolicenummer());
            updatedPolice.setKunde(policeDetails.getKunde());
            updatedPolice.setVersicherungsart(policeDetails.getVersicherungsart());
            updatedPolice.setArbeiter(policeDetails.getArbeiter());
            return ResponseEntity.ok(policeRepository.save(updatedPolice));
        } else {

            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolice(@PathVariable Long id) {
        if (policeRepository.existsById(id)) {
            policeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
