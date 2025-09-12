package ex15Colecoes.ex2;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Aluno> lista = new HashSet<>();
        lista.add(new Aluno(10, "A", "A"));
        lista.add(new Aluno(20, "B", "B"));
        lista.add(new Aluno(10, "C", "C"));
        lista.add(new Aluno(30, "D", "D"));
        lista.forEach(System.out::println);

        Set<Aluno> listadois = new HashSet<>();
        listadois.add(new Aluno(30, "D", "D"));
        listadois.add(new Aluno(20, "B", "B"));
        listadois.add(new Aluno(40, "E", "E"));

        System.out.println("----");
        Set<Aluno> uniao = new HashSet<>(lista);
        uniao.addAll(listadois);
        uniao.forEach(System.out::println);

    }
}
