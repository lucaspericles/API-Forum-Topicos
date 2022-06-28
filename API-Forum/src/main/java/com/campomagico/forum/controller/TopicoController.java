package com.campomagico.forum.controller;

import com.campomagico.forum.dto.TopicoDto;
import com.campomagico.forum.form.AtualizacaoTopicoForm;
import com.campomagico.forum.form.TopicoForm;
import com.campomagico.forum.model.TopicoModel;
import com.campomagico.forum.repository.CursoRepository;
import com.campomagico.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @GetMapping
    public List<TopicoDto> listar(){
    List<TopicoModel> topicoModels = topicoRepository.findAll();
        return TopicoDto.converter(topicoModels);
    }

    @PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		TopicoModel topicoModel = form.converter(cursoRepository);
		topicoRepository.save(topicoModel);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoModel.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topicoModel));
	}

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){

       TopicoModel topicoModel = form.atualizar(id, topicoRepository);
       return ResponseEntity.ok(new TopicoDto(topicoModel)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
