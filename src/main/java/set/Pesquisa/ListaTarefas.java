package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        for(Tarefa tarefa : tarefaSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefaSet.remove(tarefa);
            }
        }
    }

    public void exibirTarefas(){
        for(Tarefa tarefa: tarefaSet){
            System.out.println(tarefa);
        }
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa tarefa: tarefaSet){
            if(!tarefa.isConcluida()){
                tarefasConcluidas.add(tarefa);
            }
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for(Tarefa tarefa: tarefaSet){
            if(tarefa.isConcluida()){
                tarefaSet.add(tarefa);
            }
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa tarefa: tarefaSet){
           if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
               tarefa.setConcluida(true);
           }
        }
    }

    public void marcarTarefaPendente(String descricao){
        for(Tarefa tarefa : tarefaSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefa.setConcluida(false);
            }
        }
    }

    public void limparListaTarefas(){
        tarefaSet.clear();
    }
}
