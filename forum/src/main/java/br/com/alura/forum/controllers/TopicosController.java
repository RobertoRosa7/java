package br.com.alura.forum.controllers;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<Topico> lista() {
        Topico topico = new Topico("Dúvida", "Dúvida de Spring Data", new Curso("Spring Data", "Java"));
        return Arrays.asList(topico, topico);
    }
}