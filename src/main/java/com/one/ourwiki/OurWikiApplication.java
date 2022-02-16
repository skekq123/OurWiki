package com.one.ourwiki;

import com.one.ourwiki.initialData.InitialData;
import com.one.ourwiki.repository.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OurWikiApplication {


    public static void main(String[] args) {
        SpringApplication.run(OurWikiApplication.class, args);

    }

}
