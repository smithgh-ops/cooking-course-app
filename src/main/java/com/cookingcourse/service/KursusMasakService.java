package com.cookingcourse.service;

import com.cookingcourse.model.KursusMasak;
import com.cookingcourse.repository.KursusMasakRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KursusMasakService {
    
    private final KursusMasakRepository kursusMasakRepository;
    
    public List<KursusMasak> findAll() {
        return kursusMasakRepository.findAll();
    }
    
    public Optional<KursusMasak> findById(String id) {
        return kursusMasakRepository.findById(id);
    }
    
    public KursusMasak save(KursusMasak kursusMasak) {
        return kursusMasakRepository.save(kursusMasak);
    }
    
    public void deleteById(String id) {
        kursusMasakRepository.deleteById(id);
    }
    
    public boolean existsById(String id) {
        return kursusMasakRepository.existsById(id);
    }
}
