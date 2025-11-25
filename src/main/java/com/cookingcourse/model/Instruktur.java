package com.cookingcourse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instruktur")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Instruktur extends Orang {
    
    @Id
    @NotBlank(message = "ID Instruktur tidak boleh kosong")
    private String idInstruktur;
    
    private String spesialisasi;
    
    public Instruktur(String nama, String alamat, String noHP, String idInstruktur, String spesialisasi) {
        super(nama, alamat, noHP);
        this.idInstruktur = idInstruktur;
        this.spesialisasi = spesialisasi;
    }
}
