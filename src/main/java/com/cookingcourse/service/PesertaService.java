package com.cookingcourse.service;

import com.cookingcourse.model.Peserta;
import com.cookingcourse.repository.PesertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PesertaService {
    
    private final PesertaRepository pesertaRepository;
    
    public List<Peserta> findAll() {
        return pesertaRepository.findAll();
    }
    
    public Optional<Peserta> findById(String id) {
        return pesertaRepository.findById(id);
    }
    
    public Peserta save(Peserta peserta) {
        return pesertaRepository.save(peserta);
    }
    
    public void deleteById(String id) {
        pesertaRepository.deleteById(id);
    }
    
    public boolean existsById(String id) {
        return pesertaRepository.existsById(id);
    }
}
