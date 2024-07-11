package org.example.projektspringboot.Repository;

import org.example.projektspringboot.Domain.Police;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoliceRepositroy extends JpaRepository<Police, Long> {
    List<Police> findByPolicenummer(String policenummer);
}
