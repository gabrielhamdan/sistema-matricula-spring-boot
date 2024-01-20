package com.spring.sistemamatricula.dao;

import com.spring.sistemamatricula.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorio extends JpaRepository<Aluno, Integer>  {
}
