package com.cookingcourse.controller;

import com.cookingcourse.model.Peserta;
import com.cookingcourse.service.PesertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/peserta")
@RequiredArgsConstructor
public class PesertaController {
    
    private final PesertaService pesertaService;
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("pesertaList", pesertaService.findAll());
        return "peserta/list";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("peserta", new Peserta());
        return "peserta/form";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        return pesertaService.findById(id)
                .map(peserta -> {
                    model.addAttribute("peserta", peserta);
                    return "peserta/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Peserta tidak ditemukan");
                    return "redirect:/peserta";
                });
    }
    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Peserta peserta, BindingResult result, 
                       Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "peserta/form";
        }
        
        try {
            pesertaService.save(peserta);
            redirectAttributes.addFlashAttribute("successMessage", "Peserta berhasil disimpan");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyimpan peserta: " + e.getMessage());
        }
        
        return "redirect:/peserta";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            pesertaService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Peserta berhasil dihapus");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menghapus peserta: " + e.getMessage());
        }
        return "redirect:/peserta";
    }
}
