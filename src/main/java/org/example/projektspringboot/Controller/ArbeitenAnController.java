package org.example.projektspringboot.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projektspringboot.Domain.ArbeitenAn;
import org.example.projektspringboot.Repository.ArbeitenAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/arbeiten_an")
@Tag(name = "ArbeitenAn", description = "Endpoints for managing 'ArbeitenAn' entities")

public class ArbeitenAnController {
    @Autowired
    private ArbeitenAnRepository arbeitenAnRepository;

    @GetMapping
    @Operation(summary = "Get all ArbeitenAn entities", description = "Returns a list of all ArbeitenAn entities")
    public List<ArbeitenAn> getAllArbeitenAn() {
        return arbeitenAnRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbeitenAn> getArbeitenAnById(
        @Parameter(description = "ID of the ArbeitenAn to be retrieved", example = "1") @PathVariable Long id) {

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
