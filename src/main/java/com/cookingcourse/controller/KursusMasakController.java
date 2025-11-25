package com.cookingcourse.controller;

import com.cookingcourse.model.KursusMasak;
import com.cookingcourse.service.KursusMasakService;
import com.cookingcourse.service.InstrukturService;
import com.cookingcourse.service.PesertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/kursus")
@RequiredArgsConstructor
public class KursusMasakController {
    
    private final KursusMasakService kursusMasakService;
    private final InstrukturService instrukturService;
    private final PesertaService pesertaService;
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("kursusList", kursusMasakService.findAll());
        return "kursus/list";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("kursus", new KursusMasak());
        model.addAttribute("instrukturList", instrukturService.findAll());
        model.addAttribute("pesertaList", pesertaService.findAll());
        return "kursus/form";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        return kursusMasakService.findById(id)
                .map(kursus -> {
                    model.addAttribute("kursus", kursus);
                    model.addAttribute("instrukturList", instrukturService.findAll());
                    model.addAttribute("pesertaList", pesertaService.findAll());
                    return "kursus/form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Kursus tidak ditemukan");
                    return "redirect:/kursus";
                });
    }
    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute KursusMasak kursus, BindingResult result, 
                       @RequestParam(required = false) String instrukturId,
                       @RequestParam(required = false) String pesertaId,
                       Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("instrukturList", instrukturService.findAll());
            model.addAttribute("pesertaList", pesertaService.findAll());
            return "kursus/form";
        }
        
        try {
            if (instrukturId != null && !instrukturId.isEmpty()) {
                instrukturService.findById(instrukturId).ifPresent(kursus::setObjInstruktur);
            }
            if (pesertaId != null && !pesertaId.isEmpty()) {
                pesertaService.findById(pesertaId).ifPresent(kursus::setObjPeserta);
            }
            
            kursusMasakService.save(kursus);
            redirectAttributes.addFlashAttribute("successMessage", "Kursus berhasil disimpan");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyimpan kursus: " + e.getMessage());
        }
        
        return "redirect:/kursus";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            kursusMasakService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Kursus berhasil dihapus");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menghapus kursus: " + e.getMessage());
        }
        return "redirect:/kursus";
    }
}
