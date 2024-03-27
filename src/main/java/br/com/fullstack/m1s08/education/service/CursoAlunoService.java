package br.com.fullstack.m1s08.education.service;

import br.com.fullstack.m1s08.education.model.Aluno;
import br.com.fullstack.m1s08.education.model.Curso;
import org.springframework.stereotype.Service;

@Service
public class CursoAlunoService extends AlunoService{

    private final CursoService cursoService;

    public CursoAlunoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public boolean removerAluno(Integer id) throws Exception {
        Aluno aluno = buscarPorId(id);
        for(Curso curso : cursoService.buscarTodos()) {
            curso.getAlunos().remove(aluno);
        }
        return excluir(aluno);
    }
}
