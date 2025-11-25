package com.cookingcourse.controller;

import com.cookingcourse.model.*;
import com.cookingcourse.service.KursusMasakService;
import com.cookingcourse.service.PembayaranService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pembayaran")
@RequiredArgsConstructor
public class PembayaranController {
    
    private final PembayaranService pembayaranService;
    private final KursusMasakService kursusMasakService;
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("pembayaranList", pembayaranService.findAll());
        return "pembayaran/list";
    }
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("kursusList", kursusMasakService.findAll());
        return "pembayaran/form";
    }
    
    @PostMapping("/save")
    public String save(@RequestParam String idPembayaran,
                       @RequestParam double jumlah,
                       @RequestParam String kursusId,
                       @RequestParam String tipePembayaran,
                       @RequestParam(required = false) String noRekening,
                       @RequestParam(required = false, defaultValue = "0") double jumlahTunai,
                       RedirectAttributes redirectAttributes) {
        
        if (idPembayaran == null || idPembayaran.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "ID Pembayaran tidak boleh kosong");
            return "redirect:/pembayaran/form";
        }
        
        if (jumlah <= 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "Jumlah harus lebih dari 0");
            return "redirect:/pembayaran/form";
        }
        
        try {
            KursusMasak kursus = kursusMasakService.findById(kursusId).orElse(null);
            
            if ("CASH".equals(tipePembayaran)) {
                pembayaranService.saveCash(idPembayaran, jumlah, kursus, noRekening);
            } else {
                pembayaranService.saveTransfer(idPembayaran, jumlah, kursus, jumlahTunai);
            }
            
            redirectAttributes.addFlashAttribute("successMessage", "Pembayaran berhasil disimpan");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menyimpan pembayaran: " + e.getMessage());
        }
        
        return "redirect:/pembayaran";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            pembayaranService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Pembayaran berhasil dihapus");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menghapus pembayaran: " + e.getMessage());
        }
        return "redirect:/pembayaran";
    }
}
