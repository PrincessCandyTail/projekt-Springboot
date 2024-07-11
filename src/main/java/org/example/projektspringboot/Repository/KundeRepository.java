package org.example.projektspringboot.Repository;

import org.example.projektspringboot.Domain.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KundeRepository extends JpaRepository<Kunde, Long> {
    List<Kunde> findByName(String name);
}