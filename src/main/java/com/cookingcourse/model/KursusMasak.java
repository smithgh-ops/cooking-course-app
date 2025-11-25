package com.cookingcourse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kursus_masak")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KursusMasak {
    
    @Id
    @NotBlank(message = "ID Kursus tidak boleh kosong")
    private String idKursus;
    
    @NotBlank(message = "Nama Kursus tidak boleh kosong")
    private String namaKursus;
    
    @Positive(message = "Biaya harus lebih dari 0")
    private double biaya;
    
    @ManyToOne
    @JoinColumn(name = "instruktur_id")
    private Instruktur objInstruktur;
    
    @ManyToOne
    @JoinColumn(name = "peserta_id")
    private Peserta objPeserta;
}
