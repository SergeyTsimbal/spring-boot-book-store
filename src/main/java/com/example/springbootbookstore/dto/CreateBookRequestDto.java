package com.example.springbootbookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookRequestDto {
    @NotBlank
    @Size(max = 255)
    private String title;
    @NotBlank
    @Size(max = 255)
    private String author;
    @NotBlank
    @Size(max = 255)
    private String isbn;
    @NotNull
    @Min(value = 0)
    private BigDecimal price;
    private String description;
    private String coverImage;
}
