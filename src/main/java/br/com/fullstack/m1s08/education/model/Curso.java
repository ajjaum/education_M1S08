package br.com.fullstack.m1s08.education.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Curso {

    private static Integer proximoId = 1;
    @Getter private static final List<Curso> cursosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;
    private List<Aluno> alunos = new ArrayList<>();

    public static Curso inserir(Curso curso) throws Exception {
        curso.id = proximoId++;
        cursosCadastrados.add(curso);
        return curso;
    }

    public static boolean excluir(Curso curso) throws Exception {
        cursosCadastrados.remove(curso);
        return true;
    }

    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : cursosCadastrados) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    public static void adicionarAluno(Curso curso, Aluno aluno) throws Exception {
        curso.getAlunos().add(aluno);
    }
}
