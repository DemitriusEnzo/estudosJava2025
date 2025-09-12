package ex15Colecoes.ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Candidato> lista = new ArrayList<>();
        lista.add(new Candidato("E", 5.75, 15));
        lista.add(new Candidato("A", 9.5, 3));
        lista.add(new Candidato("C", 9.5, 10));

        lista.sort(Comparator.comparingDouble(Candidato::getNotaTecnica).reversed()
                .thenComparingInt(Candidato::getAnosExperiencia).reversed()
                .thenComparing(Candidato::getNome));

        AtomicInteger cont = new AtomicInteger(1);
        lista.forEach(c -> {
            System.out.println(cont.getAndIncrement() + "° | " + c);
        });
    }
}