package com.example.springbootbookstore.repository.specification;

import com.example.springbootbookstore.dto.BookSearchParametersDto;
import com.example.springbootbookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> build(BookSearchParametersDto params) {
        Specification<Book> specification = (root, query, cb) -> cb.conjunction();

        if (params.title() != null && !params.title().isBlank()) {
            specification = specification.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("title")), "%"
                            + params.title().toLowerCase() + "%"));
        }
        if (params.author() != null && !params.author().isBlank()) {
            specification = specification.and((root, query, cb) ->
                    cb.like(cb.lower(root.get("author")), "%"
                            + params.author().toLowerCase() + "%"));
        }
        if (params.isbn() != null && !params.isbn().isBlank()) {
            specification = specification.and((root, query, cb) ->
                    cb.equal(root.get("isbn"), params.isbn()));
        }

        return specification;
    }
}
