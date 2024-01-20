package com.spring.sistemamatricula.controller;

import com.spring.sistemamatricula.entity.Aluno;
import com.spring.sistemamatricula.service.AlunoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoServico alunoServico;

    public AlunoController(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @GetMapping("/lista")
    public String listaAlunos(Model model) {
        List<Aluno> alunos = alunoServico.listarAlunos();

        model.addAttribute("alunos", alunos);

        return "alunos/lista-alunos";
    }

}
