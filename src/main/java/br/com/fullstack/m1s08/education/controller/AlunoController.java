package br.com.fullstack.m1s08.education.controller;


import br.com.fullstack.m1s08.education.model.Aluno;
import br.com.fullstack.m1s08.education.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**Buscar todos**/
    @GetMapping
    public List<Aluno> get() {
        return alunoService.buscarTodos();
    }

    /**Busca por ID**/
    @GetMapping("{id}")
    public Aluno getId(@PathVariable Integer id) throws Exception {
        return alunoService.buscarPorId(id);
    }

    /** Criação **/
    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

    /** Edição **/
    @PutMapping("{id}")
    public Aluno put(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return alunoService.salvar(id, aluno);
    }
    /** Exclusão **/
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return alunoService.excluir(id);
    }
}
