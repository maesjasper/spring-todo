package edu.ap.todoapp;

import edu.ap.todoapp.repos.TodoRepository;
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
    CommandLineRunner doOnStart(@Autowired UI ui, @Autowired TodoRepository todoRepository) {
        return evt -> {
            todoRepository.findAll().forEach(todo -> System.out.println(todo.getBeschrijving() + " " +  todo.getId()));
            //ui.setVisible(true);
        };
    }
}
