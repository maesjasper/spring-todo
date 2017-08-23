package edu.ap.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TodoappApplication.class)
                .headless(false)
                .run(args);
    }

    @Bean
    CommandLineRunner doOnStart(@Autowired UI ui) {
        return evt -> {
            ui.setVisible(true);
        };
    }
}
