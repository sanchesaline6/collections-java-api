package main.java.list.OperacoesBasicas;

import java.util.ArrayList;

public class SomaNumeros {
    private ArrayList<Integer> listaNumeros;

    public SomaNumeros(ArrayList<Integer> listaNumeros) {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for(Integer numero : listaNumeros){
            soma += numero;
        }

        return soma;
    }

    public int encontrarMaiorNumero(){
        return listaNumeros.stream().max(Integer::compare).get();
    }

    public int encontrarMenorNumero(){
        return listaNumeros.stream().min(Integer::compare).get();
    }

    public void exibirNumeros(){
        for(Integer numero: listaNumeros){
            System.out.println(numero);
        }
    }
}
