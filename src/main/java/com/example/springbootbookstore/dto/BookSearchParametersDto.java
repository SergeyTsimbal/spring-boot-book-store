package com.example.springbootbookstore.dto;

public record BookSearchParametersDto(
        String title,
        String author,
        String isbn
) {}
