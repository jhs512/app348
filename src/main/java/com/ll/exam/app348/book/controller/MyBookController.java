package com.ll.exam.app348.book.controller;

import com.ll.exam.app348.book.dto.BookDto;
import com.ll.exam.app348.book.entity.Book;
import com.ll.exam.app348.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/my-books")
@RequiredArgsConstructor
public class MyBookController {
    private final BookService BookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> list(Long memberId) {
        List<Book> books = BookService.findAllByMemberId(memberId);

        List<BookDto> result = books.stream().map(book -> BookDto.builder()
                        .username(book.getMember().getUsername())
                        .bookId(book.getId())
                        .memberId(book.getMember().getId())
                        .content(book.getContent())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
