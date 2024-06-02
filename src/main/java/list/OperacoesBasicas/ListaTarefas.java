package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    ArrayList<Tarefa> listaTarefas;

    public ListaTarefas(){
        this.listaTarefas = new ArrayList<>();
    }
    public void adicionarTarefa(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasARemover = new ArrayList<>();
        for(Tarefa tarefa : listaTarefas){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefasARemover.add(tarefa);
            }
        }

        listaTarefas.removeAll(tarefasARemover);
    }

    public int obterNumeroTotalTarefas(){
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(listaTarefas);
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());

        lista.adicionarTarefa("Tarefa 1");
        lista.adicionarTarefa("Tarefa 1");
        lista.adicionarTarefa("Tarefa 2");

        System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());

        lista.removerTarefa("Tarefa 1");
        System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());

        lista.obterDescricoesTarefas();
    }

}
