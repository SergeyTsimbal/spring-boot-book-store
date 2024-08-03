package com.example.springbootbookstore.mapper;

import com.example.springbootbookstore.config.MapperConfig;
import com.example.springbootbookstore.dto.BookDto;
import com.example.springbootbookstore.dto.CreateBookRequestDto;
import com.example.springbootbookstore.model.Book;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    List<BookDto> toBookDto(List<Book> books);
}
