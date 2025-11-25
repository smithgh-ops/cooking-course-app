package com.cookingcourse.service;

import com.cookingcourse.model.Instruktur;
import com.cookingcourse.repository.InstrukturRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstrukturService {
    
    private final InstrukturRepository instrukturRepository;
    
    public List<Instruktur> findAll() {
        return instrukturRepository.findAll();
    }
    
    public Optional<Instruktur> findById(String id) {
        return instrukturRepository.findById(id);
    }
    
    public Instruktur save(Instruktur instruktur) {
        return instrukturRepository.save(instruktur);
    }
    
    public void deleteById(String id) {
        instrukturRepository.deleteById(id);
    }
    
    public boolean existsById(String id) {
        return instrukturRepository.existsById(id);
    }
}
