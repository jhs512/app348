package com.ll.exam.app348.init;

import com.ll.exam.app348.book.entity.Book;
import com.ll.exam.app348.book.repository.MyBookRepository;
import com.ll.exam.app348.member.entity.Member;
import com.ll.exam.app348.member.repository.MemberRepository;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {
    @Bean
    public CommandLineRunner devInitData(MyBookRepository myBookRepository, MemberRepository memberRepository) {
        return args -> {
            Member member = memberRepository.save(new Member("user1", "{noop}1234"));
            myBookRepository.save(new Book("안녕", member));
            myBookRepository.save(new Book("안녕1", member));
            myBookRepository.save(new Book("안녕2", member));
            myBookRepository.save(new Book("안녕3", member));
            myBookRepository.save(new Book("안녕4", member));
        };
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShop API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}
