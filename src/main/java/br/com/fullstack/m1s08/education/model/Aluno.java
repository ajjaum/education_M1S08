package br.com.fullstack.m1s08.education.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Aluno {

    private static Integer proximoId = 1;
    @Getter private static List<Aluno> alunosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private String dataNascimento;

    public static Aluno salvar(Aluno aluno) throws Exception{
        if (validar(aluno)) {
            aluno.id = proximoId++;
            alunosCadastrados.add(aluno);
        }
        return aluno;
    }

    public static Aluno salvar(Integer id, Aluno aluno) throws Exception{
        if (validar(aluno)) {
            Aluno cadastrado = buscarPorId(id);
            cadastrado.setNome(aluno.getNome());
            cadastrado.setDataNascimento(aluno.getDataNascimento());
            return cadastrado;
            }
        return null;
    }

    public static Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }

    private static boolean validar(Aluno aluno) throws Exception{
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }
        if (aluno.getDataNascimento() == null || aluno.getDataNascimento().isEmpty()) {
            throw new Exception("Data de aniversário é obrigatória");
        }
        return true;
    }
}
