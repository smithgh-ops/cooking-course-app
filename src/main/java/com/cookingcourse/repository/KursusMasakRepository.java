package com.cookingcourse.repository;

import com.cookingcourse.model.KursusMasak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursusMasakRepository extends JpaRepository<KursusMasak, String> {
}
