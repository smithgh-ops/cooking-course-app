package com.cookingcourse.repository;

import com.cookingcourse.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesertaRepository extends JpaRepository<Peserta, String> {
}
