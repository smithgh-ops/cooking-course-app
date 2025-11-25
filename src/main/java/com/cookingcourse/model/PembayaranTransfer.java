package com.cookingcourse.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("TRANSFER")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PembayaranTransfer extends Pembayaran {
    
    private double jumlahTunai;
    
    public PembayaranTransfer(String idPembayaran, double jumlah, KursusMasak kursus, double jumlahTunai) {
        super(idPembayaran, jumlah, kursus);
        this.jumlahTunai = jumlahTunai;
    }
    
    @Override
    public String prosesPembayaran() {
        return "Pembayaran Transfer sebesar Rp " + String.format("%,.0f", getJumlah()) + 
               " telah diproses. Jumlah tunai yang dibayarkan: Rp " + String.format("%,.0f", jumlahTunai);
    }
}
