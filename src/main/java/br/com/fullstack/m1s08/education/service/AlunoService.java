package br.com.fullstack.m1s08.education.service;

import br.com.fullstack.m1s08.education.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    public Aluno salvar(Aluno aluno) throws Exception {
        if (validar(aluno)) {
            return Aluno.inserir(aluno);
        }
        return null;
    }

    public Aluno salvar(Integer id, Aluno aluno) throws Exception {
        if (validar(aluno)) {
            Aluno cadastrado = buscarPorId(id);
            cadastrado.setNome(aluno.getNome());
            cadastrado.setDataNascimento(aluno.getDataNascimento());
            return cadastrado;
        }
        return null;
    }

    public List<Aluno> buscarTodos() {
        return Aluno.getAlunosCadastrados();
    }

    public Aluno buscarPorId(Integer id) throws Exception {
        return Aluno.buscarPorId(id);
    }

    private boolean validar(Aluno aluno) throws Exception{
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }
        if (aluno.getDataNascimento() == null || aluno.getDataNascimento().isEmpty()) {
            throw new Exception("Data de aniversário é obrigatória");
        }
        return true;
    }

    public boolean excluir(Integer id) throws Exception {
        Aluno aluno = buscarPorId(id);
        return excluir(aluno);
    }

    public boolean excluir(Aluno aluno) throws Exception {
        return Aluno.excluir(aluno);
    }
}
