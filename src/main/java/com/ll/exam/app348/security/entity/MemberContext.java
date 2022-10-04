package com.ll.exam.app348.security.entity;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class MemberContext extends User {
    @Getter
    private Long id;

    public MemberContext(Long id, String username, String passwd, List<SimpleGrantedAuthority> roles) {
        super(username, passwd, roles);
        this.id = id;
    }
}
