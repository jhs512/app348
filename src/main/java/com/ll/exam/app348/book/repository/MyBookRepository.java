package com.ll.exam.app348.book.repository;

import com.ll.exam.app348.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyBookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByMemberId(Long memberId);
}
