package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livrosMap;

    public LivrariaOnline(){
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro){
        livrosMap.put(link,livro);
    }

    public void removerLivro(String titulo){
        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()){
            if(entry.getValue().getAutor().equalsIgnoreCase(titulo)){
                livrosMap.remove(entry.getKey());
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorLivroPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor(){
        List<Map.Entry<String, Livro>> livrosParaOrdernarPorAutor = new ArrayList<>(livrosMap.entrySet());

        Collections.sort(livrosParaOrdernarPorAutor, new ComparatorLivroPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        livrosOrdenadosPorAutor.putAll(livrosMap);

        return livrosOrdenadosPorAutor;
    }
    public List<Livro> pesquisarLivrosPorAutor(String autor){
        List<Livro> livrosAutorPesquisado = new ArrayList<>();

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()){
            if(entry.getValue().getAutor().equalsIgnoreCase(autor)){
                livrosAutorPesquisado.add(entry.getValue());
            }
        }

        return livrosAutorPesquisado;
    }

    public Livro obterLivroMaisCaro(){
         Optional<Map.Entry<String,Livro>> livroMaisCaro = livrosMap.entrySet().stream().max(new ComparatorLivroPorPreco());
        return livroMaisCaro.map(Map.Entry::getValue).orElse(null);

    }

    public Livro obterLivroMaisBarato(){
        Optional<Map.Entry<String,Livro>> livroMaisBarato = livrosMap.entrySet().stream().min(new ComparatorLivroPorPreco());
        return livroMaisBarato.map(Map.Entry::getValue).orElse(null);
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livrosMap);

    }
}
