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
@Table(name = "peserta")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Peserta extends Orang {
    
    @Id
    @NotBlank(message = "ID Peserta tidak boleh kosong")
    private String idPeserta;
    
    public Peserta(String nama, String alamat, String noHP, String idPeserta) {
        super(nama, alamat, noHP);
        this.idPeserta = idPeserta;
    }
}
