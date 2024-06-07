package main.java.map.Pesquisa;

import java.util.Comparator;
import java.util.Objects;

public class Produto {
    private long cod;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto( String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Double getProdutoTotal(){
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}

class ComparatorPorPreco implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

class ComparatorPorValorTotalProduto implements Comparator<Produto>{

    @Override
    public int compare(Produto o1, Produto o2) {
        return Double.compare(o1.getProdutoTotal(), o2.getProdutoTotal());
    }
}
