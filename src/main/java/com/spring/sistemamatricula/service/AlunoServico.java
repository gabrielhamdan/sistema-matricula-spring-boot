package com.spring.sistemamatricula.service;

import com.spring.sistemamatricula.dao.AlunoRepositorio;
import com.spring.sistemamatricula.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServico {

    private AlunoRepositorio alunoRepositorio;

    @Autowired
    public AlunoServico(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }


    public List<Aluno> listarAlunos() {
        return alunoRepositorio.findAll();
    }

    public Aluno buscarAlunoPorId(int id) {
        Optional<Aluno> resultado = alunoRepositorio.findById(id);

        if(resultado.isPresent())
            return resultado.get();

        return null;
    }

    public void salvarAluno(Aluno aluno) {
        alunoRepositorio.save(aluno);
    }

    public void deletarAlunoPorId(int id) {
        alunoRepositorio.deleteById(id);
    }

}
