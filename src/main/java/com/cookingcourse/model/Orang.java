package com.cookingcourse.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Orang {
    
    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;
    
    private String alamat;
    
    private String noHP;
}
