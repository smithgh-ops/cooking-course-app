package com.cookingcourse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pembayaran")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipe_pembayaran")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pembayaran {
    
    @Id
    @NotBlank(message = "ID Pembayaran tidak boleh kosong")
    private String idPembayaran;
    
    @Positive(message = "Jumlah harus lebih dari 0")
    private double jumlah;
    
    @ManyToOne
    @JoinColumn(name = "kursus_id")
    private KursusMasak kursus;
    
    public abstract String prosesPembayaran();
}
