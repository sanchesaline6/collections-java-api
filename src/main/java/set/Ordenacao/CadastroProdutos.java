package main.java.set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    Set<Produto> produtoSet;

    public CadastroProdutos(){
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(int cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(nome, cod, preco, quantidade));
    }

    public void exibirProdutosPorNome(){
        Set<Produto> produtosOrdenadosPorNome = new TreeSet<>(produtoSet);
        for(Produto produto: produtosOrdenadosPorNome){
            System.out.println(produto);
        }
    }

    public void exibirProdutosPorPreco(){
        Set<Produto> produtosOrdenadosPorPreco = new TreeSet<>(new ComparatorProdutoPreco());
        produtosOrdenadosPorPreco.addAll(produtoSet);

        for(Produto produto: produtosOrdenadosPorPreco){
            System.out.println(produto);
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionarProduto(1, "Produto 5", 15d, 5);
        cadastroProdutos.adicionarProduto(2, "Produto 0", 20d, 10);
        cadastroProdutos.adicionarProduto(1, "Produto 3", 10d, 2);
        cadastroProdutos.adicionarProduto(9, "Produto 9", 2d, 2);

        System.out.println(cadastroProdutos.produtoSet);

        System.out.println("Ordenando Por Nome do Produto");
        cadastroProdutos.exibirProdutosPorNome();
        System.out.println("Ordenando Por Preço do Produto");
        cadastroProdutos.exibirProdutosPorPreco();
    }
}
