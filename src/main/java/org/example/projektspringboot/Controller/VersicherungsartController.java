package org.example.projektspringboot.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projektspringboot.Domain.Versicherungsart;
import org.example.projektspringboot.Repository.VersicherungsartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/versicherungsarten")
@Tag(name = "VersicherungsartController", description = "Endpoints for managing 'VersicherungsartController' entities")


public class VersicherungsartController {

    @Autowired
    private VersicherungsartRepository versicherungsartRepository;

    @GetMapping
    public List<Versicherungsart> getAllVersicherungsarten() {
        return versicherungsartRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Versicherungsart by ID", description = "Fetch the details of a specific contract")


    public ResponseEntity<Versicherungsart> getVersicherungsartById(@PathVariable Long id) {
        Optional<Versicherungsart> versicherungsart = versicherungsartRepository.findById(id);
        if (versicherungsart.isPresent()) {
            return ResponseEntity.ok(versicherungsart.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Versicherungsart createVersicherungsart(@RequestBody Versicherungsart versicherungsart) {
        return versicherungsartRepository.save(versicherungsart);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Versicherungsart> updateVersicherungsart(@PathVariable Long id,
                                                                   @RequestBody Versicherungsart versicherungsartDetails) {
        Optional<Versicherungsart> versicherungsart = versicherungsartRepository.findById(id);
        if (versicherungsart.isPresent()) {
            Versicherungsart updatedVersicherungsart = versicherungsart.get();
            updatedVersicherungsart.setArt(versicherungsartDetails.getArt());
            return ResponseEntity.ok(versicherungsartRepository.save(updatedVersicherungsart));
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVersicherungsart(@PathVariable Long id) {
        if (versicherungsartRepository.existsById(id)) {
            versicherungsartRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
