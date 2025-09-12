package ex16ProgramacaoFuncional.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class exercicio01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("enzo");
        nomes.add("alvaro");
        nomes.add("Almo");
        nomes.add("alcool");
        nomes.add("cavalo");

        List<String> nomesA = nomes.stream().filter(n -> n.startsWith("a") || n.startsWith("A")).map(n -> n.toUpperCase()).sorted().collect(Collectors.toList());
        nomesA.forEach(System.out::println);

    }
}