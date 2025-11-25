package com.cookingcourse.controller;

import com.cookingcourse.model.Instruktur;
import com.cookingcourse.service.InstrukturService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/instruktur")
@RequiredArgsConstructor
public class InstrukturController {
    
    private final InstrukturService instrukturService;
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("instrukturList", instrukturService.findAll());
        return "instruktur/list";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("instruktur", new Instruktur());
        return "instruktur/form";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        return instrukturService.findById(id)
                .map(instruktur -> {
                    model.addAttribute("instruktur", instruktur);
                    return "instruktur/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Instruktur tidak ditemukan");
                    return "redirect:/instruktur";
                });
    }
    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Instruktur instruktur, BindingResult result, 
                       Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "instruktur/form";
        }
        
        try {
            instrukturService.save(instruktur);
            redirectAttributes.addFlashAttribute("successMessage", "Instruktur berhasil disimpan");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyimpan instruktur: " + e.getMessage());
        }
        
        return "redirect:/instruktur";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            instrukturService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Instruktur berhasil dihapus");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menghapus instruktur: " + e.getMessage());
        }
        return "redirect:/instruktur";
    }
}
