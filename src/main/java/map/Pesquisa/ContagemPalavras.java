package main.java.map.Pesquisa;

import java.util.*;

public class ContagemPalavras {
    Map<String, Integer> contagemPalavras;

    public ContagemPalavras(){
        this.contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        contagemPalavras.remove(palavra);
    }

    public void exibirContagemPalavras(){
        System.out.println(contagemPalavras);
    }

    public String encontrarPalavraMaisFrequente(){

        Optional<Integer> integerOptional= contagemPalavras.values().stream().max(new ComparatorContagemPalavra());
        for(Map.Entry<String, Integer> entrada : contagemPalavras.entrySet()){
            if(Objects.equals(entrada.getValue(), integerOptional.get())){
                return entrada.getKey();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.contagemPalavras.size() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        contagemLinguagens.exibirContagemPalavras();
        System.out.println("A linguagem mais frequente é: " + contagemLinguagens.encontrarPalavraMaisFrequente());
    }


}

class ComparatorContagemPalavra implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1,o2);
    }
}


