package com.cookingcourse.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CASH")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PembayaranCash extends Pembayaran {
    
    private String noRekening;
    
    public PembayaranCash(String idPembayaran, double jumlah, KursusMasak kursus, String noRekening) {
        super(idPembayaran, jumlah, kursus);
        this.noRekening = noRekening;
    }
    
    @Override
    public String prosesPembayaran() {
        return "Pembayaran Cash sebesar Rp " + String.format("%,.0f", getJumlah()) + 
               " telah diproses dengan nomor rekening: " + noRekening;
    }
}
