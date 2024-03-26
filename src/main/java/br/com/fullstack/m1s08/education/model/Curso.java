package br.com.fullstack.m1s08.education.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Curso {

    private static Integer proximoId = 1;
    @Getter
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;

    public static Curso salvar(Curso curso) throws Exception{
        if (validar(curso)) {
            curso.id = proximoId++;
            cursosCadastrados.add(curso);
        }
        return curso;
    }

    public static Curso salvar(Integer id, Curso curso) throws Exception{
        if (validar(curso)) {
            Curso cadastrado = buscarPorId(id);
            cadastrado.setNome(curso.getNome());
            cadastrado.setDescricao(curso.getDescricao());
            cadastrado.setCargaHoraria(curso.getCargaHoraria());
            return cadastrado;
        }
        return null;
    }

    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : cursosCadastrados) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    private static boolean validar(Curso curso) throws Exception{
        if (curso.getNome() == null || curso.getNome().isEmpty()) {
            throw new Exception("Nome é obrigatório");
        }
        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() < 100) {
            throw new Exception("Carga horária não informada ou menor do que 100 horas.");
        }
        return true;
    }
}
