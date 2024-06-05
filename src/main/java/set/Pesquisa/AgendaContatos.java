package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> conjuntoContatos;

    public AgendaContatos() {
        this.conjuntoContatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        conjuntoContatos.add(new Contato(nome, numero));
    }

    public void sxibirContatos(){
        for(Contato contato: conjuntoContatos){
            System.out.println(contato);
        }
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosEcontrados = new HashSet<>();
        for(Contato contato: conjuntoContatos){
            if(contato.getNome().equalsIgnoreCase(nome)){
                contatosEcontrados.add(contato);
            }
        }

        return contatosEcontrados;
    }

    public void atualizarNumeroContato(String nome, int novoNumero){
        for(Contato contato: conjuntoContatos){
            if(contato.getNome().equalsIgnoreCase(nome)){
                contato.setNumero(novoNumero);
            }
        }
    }
}
