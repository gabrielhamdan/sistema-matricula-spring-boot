package com.spring.sistemamatricula.controller;

import com.spring.sistemamatricula.entity.Aluno;
import com.spring.sistemamatricula.service.AlunoServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cadastrarAluno")
    public String cadastrarAluno (Model model){
        Aluno aluno = new Aluno();

        model.addAttribute("aluno", aluno);

        return "alunos/form-aluno";
    }

    @PostMapping("/salvarAluno")
    public String salvar(@ModelAttribute("aluno") Aluno aluno) {
        alunoServico.salvarAluno(aluno);

        return "redirect:/alunos/lista";
    }

    @GetMapping("/alterarAluno")
    public String alterarAluno(@RequestParam("alunoId") int id, Model model) {
        Aluno aluno = alunoServico.buscarAlunoPorId(id);

        model.addAttribute("aluno", aluno);

        return "alunos/form-aluno";
    }

    @GetMapping("/deletarAluno")
    public String deletarAluno(@RequestParam("alunoId") int id) {
        alunoServico.deletarAlunoPorId(id);

        return "redirect:/alunos/lista";
    }

}
