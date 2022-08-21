package br.com.alura.forum.DTO;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TopicoDTO {
    private final Long id;
    private final String titulo;
    private final String mensagem;
    private final LocalDateTime dataCriacao;

    public TopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static Page<TopicoDTO> converter(Page<Topico> asList) {
        return asList.map(TopicoDTO::new);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
