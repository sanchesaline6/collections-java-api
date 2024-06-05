package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    Set<Aluno> alunoSet;

    public GerenciadorAlunos(){
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        alunoSet.removeIf(aluno -> aluno.getMatricula().equals(matricula));
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosOrdeanosPorNome = new TreeSet<>(alunoSet);
        for(Aluno aluno: alunosOrdeanosPorNome){
            System.out.println(aluno);
        }
    }

    public void exibirAlunosPorNota(){
        Set<Aluno> alunosOrdenadosPorNota = new TreeSet<>(new ComparatorNotaAluno());
        alunosOrdenadosPorNota.addAll(alunoSet);
        for(Aluno aluno: alunosOrdenadosPorNota){
            System.out.println(aluno);
        }
    }

    public void exibirAlunos(){
        for(Aluno aluno: alunoSet){
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        gerenciadorAlunos.adicionarAluno("Aline", 1L, 8.0);
        gerenciadorAlunos.adicionarAluno("João Gabriel", 2L, 7.0);
        gerenciadorAlunos.adicionarAluno("Ana Clara", 1L, 9.0);
        gerenciadorAlunos.adicionarAluno("Ana Maria", 3L, 6.0);

        System.out.println("Ordena pelo Nome do Aluno");
        gerenciadorAlunos.exibirAlunosPorNome();

        System.out.println("Ordena pela Nota do Aluno");
        gerenciadorAlunos.exibirAlunosPorNota();

        gerenciadorAlunos.removerAluno(3L);
        System.out.println("Mostra alunos após remoção");
        gerenciadorAlunos.exibirAlunos();
    }
}
