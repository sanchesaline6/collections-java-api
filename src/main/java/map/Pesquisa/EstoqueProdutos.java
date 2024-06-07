package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EstoqueProdutos {
    Map<Long, Produto> estoqueProdutos;

    public EstoqueProdutos(){
        this.estoqueProdutos = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutos.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutos);
    }

    public double calcularValorTotalEstoque(){
        double totalEstoque = 0.0;
        for(Produto produto : estoqueProdutos.values()){
            double produtoTotal = produto.getPreco() * produto.getQuantidade();
            totalEstoque += produtoTotal;
        }

        return totalEstoque;
    }

    public Optional<Produto> obterProdutoMaisCaro(){
        Optional<Produto> produtoMaisCaro = Optional.empty();
        if(!estoqueProdutos.isEmpty()){
            produtoMaisCaro = estoqueProdutos.values().stream().max(new ComparatorPorPreco());
            
        }
        return produtoMaisCaro;
    }
    public Optional<Produto> obterProdutoMaisBarato(){
        Optional<Produto> produtoMaisBarato = Optional.empty();
        if(!estoqueProdutos.isEmpty()){
            produtoMaisBarato = estoqueProdutos.values().stream().min(new ComparatorPorPreco());

        }
        return produtoMaisBarato;
    }

    public Optional<Produto> obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Optional<Produto> produtoMaiorQuantidadeValorTotalNoEstoque = Optional.empty();
        if(!estoqueProdutos.isEmpty()){
            produtoMaiorQuantidadeValorTotalNoEstoque = estoqueProdutos.values().stream().max(new ComparatorPorValorTotalProduto());

        }
        return produtoMaiorQuantidadeValorTotalNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Exibe o estoque vazio
        estoque.exibirProdutos();

        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500);
        estoque.adicionarProduto(2L, "Mouse", 5, 25);
        estoque.adicionarProduto(3L, "Monitor", 10, 400);
        estoque.adicionarProduto(4L, "Teclado", 2, 40);

        // Exibe os produtos no estoque
        estoque.exibirProdutos();

        // Calcula e exibe o valor total do estoque
        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        // Obtém e exibe o produto mais caro
        Optional<Produto> produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        // Obtém e exibe o produto mais barato
        Optional<Produto> produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        // Obtém e exibe o produto com a maior quantidade em valor no estoque
        Optional<Produto> produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
