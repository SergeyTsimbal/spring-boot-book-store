package com.example.springbootbookstore.service;

import com.example.springbootbookstore.dto.BookDto;
import com.example.springbootbookstore.dto.CreateBookRequestDto;
import com.example.springbootbookstore.exception.EntityNotFoundException;
import com.example.springbootbookstore.mapper.BookMapper;
import com.example.springbootbookstore.model.Book;
import com.example.springbootbookstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toBookDto(bookRepository.findAll());
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto requestDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));

        existingBook.setTitle(requestDto.getTitle());
        existingBook.setAuthor(requestDto.getAuthor());
        existingBook.setIsbn(requestDto.getIsbn());
        existingBook.setPrice(requestDto.getPrice());
        existingBook.setDescription(requestDto.getDescription());
        existingBook.setCoverImage(requestDto.getCoverImage());

        return bookMapper.toDto(bookRepository.save(existingBook));
    }

}

