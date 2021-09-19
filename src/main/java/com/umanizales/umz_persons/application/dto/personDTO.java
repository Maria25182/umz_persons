package com.umanizales.umz_persons.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class personDTO {

    @NotNull
    @NotBlank
    @Size(min=2,max = 20)
    private String name;
    private String identification;
    @Positive
    private byte age;
}
