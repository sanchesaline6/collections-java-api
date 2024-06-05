package main.java.set.OperacoesBasicas;

import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> listaPalavras;

    public void adicionarPalavra(String palavra){
        listaPalavras.add(palavra);
    }

    public void removerPalavra(String palavra){
        for(String palavraARemover: listaPalavras){
            if(palavraARemover.equalsIgnoreCase(palavra)){
                listaPalavras.remove(palavra);
            }
        }
    }

    public boolean verificarPalavra(String palavra){
        return listaPalavras.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        for(String palavra: listaPalavras){
            System.out.println(palavra);
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavrasUnicas();
    }
}
