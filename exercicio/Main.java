package exercicio;
import java.util.Comparator;
import java.util.List;

// Listar todas as pessoas
// Listar as 10 primeiras pessoas
// Listar as pessoas que são do Brasil
// Listar as pessoas do Brasil com o nome em Uppercase e suas idades
// Listar as pessoas que são do Brasil, em ordem de nome
// Listar as pessoas que são do Brasil, em ordem de idade
// Contar quantas pessoas tem mais de 45 anos
// Calcular a média de idade das pessoas

// filter() --> seleciona apenas uma parte dos dados. Para isso a expressão lambda deve
//    retornar verdadeiro ou falso.
// verdadeiro para os itens que farão pate do resultado, e falso caso contrário

// map() --> aplicado para transformar os dados de entrada, gerando um novo conjunto de saída

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Dados.getPessoas();

        // Listar todas as pessoas:
        System.out.println("Lista de todas as pessoas:");
        pessoas.stream().forEach(System.out::println);

        // Listar as 10 primeiras pessoas:
        System.out.println("\nAs 10 primeiras pessoas da lista:");
        pessoas.stream()
                .limit(10)
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil:
        System.out.println("\nPessoas do Brasil:");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .forEach(System.out::println);

        // Listar as pessoas do Brasil com o nome em Uppercase e suas idades:
        System.out.println("\nPessoas do Brasil com nome maiusculo e idade:");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .map( p -> p.getNome().toUpperCase() + ", " + p.getIdade())
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de nome:
        System.out.println("\nPessoas do Brasil em ordem de nome:");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de idade:
        System.out.println("\nPessoas do Brasil em ordem de idade:");
        pessoas.stream()
                .filter(p -> p.getPais().equals("Brazil"))
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .forEach(System.out::println);

        
        // Contar quantas pessoas tem mais de 45 anos:
        long pessoasAcimaDe45Anos = pessoas.stream()
        .filter(p -> p.getIdade() > 45)
        .count();
        System.out.println("\nQuantidade de pessoas com mais de 45 anos: " + pessoasAcimaDe45Anos);

        // Listar quantas pessoas tem mais de 45 anos:
        System.out.println("\nPessoas com mais de 45 anos:");
        pessoas.stream()
                .filter(p -> p.getIdade() > 45)
                .forEach(System.out::println);

         // Calcular a média de idade das pessoas:
         double mediaIdade = pessoas.stream()
                .mapToDouble(Pessoa::getIdade)
                .average()
                .orElse(0);
        System.out.println("\nMédia de idade das pessoas: " + mediaIdade);
 }


    }


