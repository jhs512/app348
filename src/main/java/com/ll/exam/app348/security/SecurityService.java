package com.ll.exam.app348.security;

import com.ll.exam.app348.member.entity.Member;
import com.ll.exam.app348.member.repository.MemberRepository;
import com.ll.exam.app348.security.entity.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SecurityService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자가 없습니다."));

        return new MemberContext(
                member.getId(),
                member.getUsername(),
                member.getPasswd(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

    }
}
