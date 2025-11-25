package com.cookingcourse.service;

import com.cookingcourse.model.Pembayaran;
import com.cookingcourse.model.PembayaranCash;
import com.cookingcourse.model.PembayaranTransfer;
import com.cookingcourse.model.KursusMasak;
import com.cookingcourse.repository.PembayaranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PembayaranService {
    
    private final PembayaranRepository pembayaranRepository;
    
    public List<Pembayaran> findAll() {
        return pembayaranRepository.findAll();
    }
    
    public Optional<Pembayaran> findById(String id) {
        return pembayaranRepository.findById(id);
    }
    
    public Pembayaran saveCash(String idPembayaran, double jumlah, KursusMasak kursus, String noRekening) {
        if (idPembayaran == null || idPembayaran.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Pembayaran tidak boleh kosong");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah pembayaran harus lebih dari 0");
        }
        PembayaranCash pembayaran = new PembayaranCash(idPembayaran, jumlah, kursus, noRekening);
        return pembayaranRepository.save(pembayaran);
    }
    
    public Pembayaran saveTransfer(String idPembayaran, double jumlah, KursusMasak kursus, double jumlahTunai) {
        if (idPembayaran == null || idPembayaran.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Pembayaran tidak boleh kosong");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah pembayaran harus lebih dari 0");
        }
        PembayaranTransfer pembayaran = new PembayaranTransfer(idPembayaran, jumlah, kursus, jumlahTunai);
        return pembayaranRepository.save(pembayaran);
    }
    
    public Pembayaran save(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }
    
    public void deleteById(String id) {
        pembayaranRepository.deleteById(id);
    }
    
    public boolean existsById(String id) {
        return pembayaranRepository.existsById(id);
    }
}
