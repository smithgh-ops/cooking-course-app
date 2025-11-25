package com.cookingcourse.repository;

import com.cookingcourse.model.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, String> {
}
