package com.cookingcourse.repository;

import com.cookingcourse.model.Instruktur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrukturRepository extends JpaRepository<Instruktur, String> {
}
