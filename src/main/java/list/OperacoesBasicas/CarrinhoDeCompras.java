package main.java.list.OperacoesBasicas;

import java.util.ArrayList;

public class CarrinhoDeCompras {
    ArrayList<Item> carrinhoCompras;

    public CarrinhoDeCompras(){
        this.carrinhoCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        this.carrinhoCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        carrinhoCompras.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    public double calculaValorTotal(){
        double total = 0.0;
        for(Item item: carrinhoCompras){
            total += item.getPreco() * item.getQuantidade();
        }

        return total;
    }

    public void exibirItens(){
        for(Item item: carrinhoCompras){
            System.out.println( item);
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Pepsi Lata", 2.69, 7);
        carrinho.adicionarItem("Pão Francês", 0.50, 10);
        carrinho.adicionarItem("Bombom", 1.00, 10);

        System.out.println("Total da compra: " + carrinho.calculaValorTotal());

        carrinho.exibirItens();
        carrinho.removerItem("Bombom");

        System.out.println("Total da compra: " + carrinho.calculaValorTotal());

        carrinho.exibirItens();

    }
}
