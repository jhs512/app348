package com.ll.exam.app348.book.service;

import com.ll.exam.app348.book.entity.Book;
import com.ll.exam.app348.book.repository.MyBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final MyBookRepository myBookRepository;

    @Transactional
    public List<Book> findAllByMemberId(Long memberId) {
        return myBookRepository.findAllByMemberId(memberId);
    }
}
