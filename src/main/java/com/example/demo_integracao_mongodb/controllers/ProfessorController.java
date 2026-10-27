package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Professor;
import com.example.demo_integracao_mongodb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public void gravar(@RequestBody Professor professor) {
        this.professorRepository.save(professor);
    }

    @GetMapping
    public List<Professor> buscarTodos() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor buscarPorId(@PathVariable String id) {
        return this.professorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Professor professor) {
        if (this.professorRepository.existsById(id)) {
            professor.setId(id);
            this.professorRepository.save(professor);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.professorRepository.deleteById(id);
    }
}
