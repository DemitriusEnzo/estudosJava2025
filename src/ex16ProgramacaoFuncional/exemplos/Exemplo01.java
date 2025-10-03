package ex16ProgramacaoFuncional.exemplos;

import java.util.stream.IntStream;

public class Exemplo01 {
    public static void main(String[] args) {
        int[] x = {10, 5, 7, 6, 4, 2, 1};
        IntStream fluxo = IntStream.of(x);

        // imprimir apenas os números ímpares
//        fluxo.filter(valor -> valor % 2 != 0)
//                .map(valor -> valor + 10)
//                .forEach(System.out::println);

        // imprimir a soma dos elementos do vetor
        int resultado = fluxo.reduce(0, (total, i) -> total + i);
        System.out.println(resultado);
    }
}
