package main.java.list.OperacoesBasicas;

import java.util.ArrayList;

public class CatalogoLivros {

    private ArrayList<Livro> listaLivros;

    public CatalogoLivros(ArrayList<Livro> listaLivros) {
        this.listaLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        listaLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public ArrayList<Livro> pesquisarPorAutor(String autor){
        ArrayList<Livro> livrosEncontrados = new ArrayList<>();
        for(Livro livro: listaLivros){
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public ArrayList<Livro> pesquisarPorIntervalosAnos(int anoInicial, int anoFinal){
        ArrayList<Livro> livrosEncontrados = new ArrayList<>();
        for(Livro livro: listaLivros){
            if(livro.getAnoPublicacao() >= anoFinal && livro.getAnoPublicacao() <= anoFinal){
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public ArrayList<Livro> pesquisarPorTitulo(String titulo){
        ArrayList<Livro> livrosEncontrados = new ArrayList<>();
        for(Livro livro: listaLivros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }
}
