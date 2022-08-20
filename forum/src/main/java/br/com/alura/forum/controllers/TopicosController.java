package br.com.alura.forum.controllers;

import br.com.alura.forum.DTO.DetalhesTopicoDTO;
import br.com.alura.forum.DTO.TopicoDTO;
import br.com.alura.forum.form.AtualizaTopicoForm;
import br.com.alura.forum.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    @Transactional
    public Page<TopicoDTO> lista(
            @RequestParam(required = false) String nomeCurso,
            @PageableDefault(sort = "dataCriacao", direction = Sort.Direction.ASC, page = 0, size = 10)
            Pageable paginacao) {

        Page<Topico> topicos;
        if (nomeCurso != null) {
            topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
        } else {
            topicos = topicoRepository.findAll(paginacao);
        }
        return TopicoDTO.converter(topicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder builder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = builder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> topicos = this.findAnyOne(id);
        return topicos.map(value -> ResponseEntity.ok(new DetalhesTopicoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaTopicoForm form) {
        Optional<Topico> optional = this.findAnyOne(id);
        return optional.map((topico -> ResponseEntity.ok(new TopicoDTO(form.atualizar(optional.get()))))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Topico> optional = this.findAnyOne(id);
        return optional.map(topico -> {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Optional<Topico> findAnyOne(Long id) {
        return topicoRepository.findById(id);
    }
}