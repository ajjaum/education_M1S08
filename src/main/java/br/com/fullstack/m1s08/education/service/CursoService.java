package br.com.fullstack.m1s08.education.service;

import br.com.fullstack.m1s08.education.model.Aluno;
import br.com.fullstack.m1s08.education.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public Curso salvar(Curso curso) throws Exception {
        if (validar(curso)) {
            return Curso.inserir(curso);
        }
        return null;
    }

    public Curso salvar(Integer id, Curso curso) throws Exception {
        if (validar(curso)) {
            Curso cadastrado = buscarPorId(id);
            cadastrado.setNome(curso.getNome());
            cadastrado.setDescricao(curso.getDescricao());
            cadastrado.setCargaHoraria(curso.getCargaHoraria());
            return cadastrado;
        }
        return null;
    }

    public List<Curso> buscarTodos() throws Exception {
        return Curso.getCursosCadastrados();
    }

    public Curso buscarPorId(Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    private boolean validar(Curso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() < 100) {
            throw new Exception("Carga horária não informada ou menor que 100");
        }

        return true;
    }

    public boolean excluir(Integer id) throws Exception {
        Curso curso = buscarPorId(id);
        return Curso.excluir(curso);
    }

    public Curso adicionarAluno(Integer id, Integer professorId) throws Exception {
        Curso curso = buscarPorId(id);
        Aluno aluno = alunoService.buscarPorId(professorId);
        Curso.adicionarAluno(curso, aluno);
        return curso;
    }
}
