package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConjuntoConvidados {

    Set<Convidado> listaConvidados;

    public ConjuntoConvidados() {
        this.listaConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        listaConvidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        for(Convidado convidado: listaConvidados){
            if(convidado.getCodigoConvite() == codigoConvite){
                listaConvidados.remove(convidado);
            }
        }
    }

    public int contarConvidados(){
        return listaConvidados.size();
    }

    public void exibirConvidados(){
        for(Convidado convidado: listaConvidados){
            System.out.println(convidado);
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoConvidados
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        // Exibindo o número de convidados no conjunto (deve ser zero)
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        // Adicionando convidados ao conjunto
        conjuntoConvidados.adicionarConvidado("Alice", 1234);
        conjuntoConvidados.adicionarConvidado("Bob", 1235);
        conjuntoConvidados.adicionarConvidado("Charlie", 1235);
        conjuntoConvidados.adicionarConvidado("David", 1236);

        // Exibindo os convidados no conjunto
        System.out.println("Convidados no conjunto:");
        conjuntoConvidados.exibirConvidados();

        // Exibindo o número atualizado de convidados no conjunto
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        // Removendo um convidado do conjunto por código de convite
        conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");

        // Exibindo os convidados atualizados no conjunto
        System.out.println("Convidados no conjunto após a remoção:");
        conjuntoConvidados.exibirConvidados();
    }
}
