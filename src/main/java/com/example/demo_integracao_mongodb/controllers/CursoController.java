package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Curso;
import com.example.demo_integracao_mongodb.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void gravar(@RequestBody Curso curso) {
        this.cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> buscarTodos() {
        return this.cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable String id) {
        return this.cursoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Curso curso) {
        if (this.cursoRepository.existsById(id)) {
            curso.setId(id);
            this.cursoRepository.save(curso);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.cursoRepository.deleteById(id);
    }
}
