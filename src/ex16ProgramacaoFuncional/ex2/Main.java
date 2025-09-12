package ex16ProgramacaoFuncional.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empregado> lista = new ArrayList<>();
        lista.add(new Empregado("D", 15000, 15));
        lista.add(new Empregado("A", 2000, 2));
        lista.add(new Empregado("C", 200000, 1));

        lista.stream().map(e -> new Empregado(e.nome(), (e.salario() * (e.anosExperiencia() >= 5 ? 1.20 : 1.10)), e.anosExperiencia())).forEach(System.out::println);
    }
}
