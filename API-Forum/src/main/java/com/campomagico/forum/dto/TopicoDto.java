package com.campomagico.forum.dto;

import com.campomagico.forum.model.TopicoModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(TopicoModel topicoModel){
        this.id = topicoModel.getId();
        this.titulo = topicoModel.getTitulo();
        this.mensagem = topicoModel.getMensagem();
        this.dataCriacao = topicoModel.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<TopicoModel> topicoModels) {
        return topicoModels.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getData() {
        return dataCriacao;
    }

    public void setData(LocalDate data) {
        this.dataCriacao = LocalDateTime.from(data);
    }
}
