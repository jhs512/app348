package com.ll.exam.app348.book.entity;

import com.ll.exam.app348.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = LAZY)
    private Member member;

    public Book(String content, Member member) {
        this.content = content;
        this.member = member;
    }
}
