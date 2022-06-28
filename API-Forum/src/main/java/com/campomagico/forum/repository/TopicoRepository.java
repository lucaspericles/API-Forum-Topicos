package com.campomagico.forum.repository;

import com.campomagico.forum.model.TopicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<TopicoModel, Long> {
}
