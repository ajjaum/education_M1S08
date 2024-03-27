package br.com.fullstack.m1s08.education.controller;

import br.com.fullstack.m1s08.education.model.Aluno;
import br.com.fullstack.m1s08.education.model.Curso;
import br.com.fullstack.m1s08.education.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    /**Buscar todos**/
    @GetMapping
    public List<Curso> get() throws Exception {
        return cursoService.buscarTodos();
    }

    /**Busca por ID**/
    @GetMapping("{id}")
    public Curso getId(@PathVariable Integer id) throws Exception {
        return cursoService.buscarPorId(id);
    }

    /** Criação **/
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    /** Edição **/
    @PutMapping("{id}")
    public Curso put(@PathVariable Integer id, @RequestBody Curso curso) throws Exception {
        return cursoService.salvar(id, curso);
    }

    /** Exclusão **/
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return cursoService.excluir(id);
    }

    /** Adicionar aluno a um curso **/
    @PostMapping("{id}/add-aluno")
    public Curso postAluno(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return cursoService.adicionarAluno(id, aluno.getId());
    }

    /** Adicionar aluno a um curso com PATH VARIABLE / PATH PARAM */
    @PostMapping("{id}/add-aluno/{alunoId}")
    public Curso postAlunoPorId(@PathVariable Integer id, @PathVariable Integer alunoId) throws Exception {
        return cursoService.adicionarAluno(id, alunoId);
    }
}
