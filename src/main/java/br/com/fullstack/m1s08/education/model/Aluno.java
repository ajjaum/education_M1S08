package br.com.fullstack.m1s08.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aluno {

    private static Integer proximoId = 1;
    @Getter private static final List<Aluno> alunosCadastrados = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String dataNascimento;

    public static Aluno inserir(Aluno aluno) throws Exception {
        aluno.id = proximoId++;
        alunosCadastrados.add(aluno);
        return aluno;
    }

    public static boolean excluir(Aluno aluno) throws Exception {
        alunosCadastrados.remove(aluno);
        return true;
    }

    public static Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }
}
