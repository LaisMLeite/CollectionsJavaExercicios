package br.com;

import java.util.*;

public class ExercicioSetLinguagemFavorita {

    public static void main(String[] args) {

        Set<LinguagemFavorita> minhasLinguagens = new LinkedHashSet() {{
            add(new LinguagemFavorita("Java", 1960, "Intellij"));
            add(new LinguagemFavorita("Javascript", 1980, "VSCode"));
            add(new LinguagemFavorita("C", 2000, "Eclipse"));
        }};

        System.out.println("-- Ordem de inserção --");
        //System.out.println(minhasLinguagens); usando toString pois o LinkedHashMap já ordena na ordem de inserção
        for (LinguagemFavorita linguagem : minhasLinguagens){
            System.out.println(linguagem.getNome() + " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }
        System.out.println();


        System.out.println(" -- Ordem Natural (Nome) -- ");
        Set <LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(new ComparatorGenero2());
        //tem que ser Tree Set porque ele trabalha com ordem natural e pode implementarcomparator
        minhasLinguagens2.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem : minhasLinguagens2){
            System.out.println(linguagem.getNome() + " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }
        System.out.println();


        System.out.println(" -- Ordem de IDE -- ");
        Set <LinguagemFavorita> minhasLinguagens3 = new TreeSet<>(new ComparatorIDE());
        minhasLinguagens3.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem : minhasLinguagens3){
            System.out.println(linguagem.getNome()+ " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }
        System.out.println();

        System.out.println(" -- Ano de Criação e IDE --");
        Set <LinguagemFavorita> minhasLinguagens4 = new TreeSet<>(new ComparatorAnoIDE());
        minhasLinguagens4.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem : minhasLinguagens4){
            System.out.println(linguagem.getNome()+ " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }
        System.out.println();

        System.out.println(" -- Ano de criação e nome -- ");
        Set <LinguagemFavorita> minhasLinguagens5 = new TreeSet<>(new ComparatorAnoDeCriacaoNome());
        minhasLinguagens5.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem : minhasLinguagens5){
            System.out.println(linguagem.getNome()+ " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }

        System.out.println(" -- Nome/Ano de Criação/IDE --");
        Set<LinguagemFavorita> minhasLinguagens6 = new TreeSet<>(new ComparatorNomeAnoDeCriacaoIDE());
        minhasLinguagens6.addAll(minhasLinguagens);
        for (LinguagemFavorita linguagem : minhasLinguagens6){
            System.out.println(linguagem.getNome()+ " - "
                    + linguagem.getAnoDeCriação() + " - "
                    + linguagem.getIDE());
        }
        System.out.println();


        System.out.println("Exibir as linguagens uma abaixo da outra: ");
        for (LinguagemFavorita linguagem : minhasLinguagens){
            System.out.println(linguagem.getNome());
        }

    }
}

class ComparatorAnoDeCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoDeCriacao = Integer.compare(l1.getAnoDeCriação(), l2.getAnoDeCriação());
        if (anoDeCriacao !=0) return anoDeCriacao;
        return l1.getNome().compareTo(l2.getNome());
    }
}


class ComparatorAnoIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoDeCriacao = Integer.compare(l1.getAnoDeCriação(), l2.getAnoDeCriação());
        if (anoDeCriacao != 0) return anoDeCriacao;
        return l1.getIDE().compareTo(l2.getIDE());


    }
}

class ComparatorGenero2 implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        return nome;
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int IDE = l1.getIDE().compareTo(l2.getIDE());
        return IDE;
    }
}

class ComparatorNomeAnoDeCriacaoIDE implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome()); //STRING compareTo
        if (nome != 0) return nome;
        int anoDeCriacao = Integer.compare(l1.getAnoDeCriação(), l2.getAnoDeCriação()); //INT Integer.compare
        if (anoDeCriacao !=0) return anoDeCriacao;

        return l1.getIDE().compareTo(l2.getIDE());

    }
}

class LinguagemFavorita implements Comparable <LinguagemFavorita> { //o implements é para o comparable
    private String nome;
    private Integer anoDeCriação;
    private String IDE;

    public LinguagemFavorita(String nome, Integer anoDeCriação, String IDE) {
        this.nome = nome;
        this.anoDeCriação = anoDeCriação;
        this.IDE = IDE;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriação() {
        return anoDeCriação;
    }

    public String getIDE() {
        return IDE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriação, that.anoDeCriação) && Objects.equals(IDE, that.IDE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriação, IDE);
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriação=" + anoDeCriação +
                ", IDE='" + IDE + '\'' +
                '}';
    }


    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        int ano = Integer.compare(this.getAnoDeCriação(), linguagem.getAnoDeCriação());
        if (ano != 0) return ano;

        else return this.getNome().compareTo(linguagem.getNome());


    }
}

