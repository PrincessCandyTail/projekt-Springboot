package org.example.projektspringboot.Repository;

import org.example.projektspringboot.Domain.Zahlung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahlungRepository extends JpaRepository<Zahlung, Long> {}