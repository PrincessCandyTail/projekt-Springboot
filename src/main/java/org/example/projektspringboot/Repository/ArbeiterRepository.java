package org.example.projektspringboot.Repository;

import org.example.projektspringboot.Domain.Arbeiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbeiterRepository extends JpaRepository<Arbeiter, Long> {

}
