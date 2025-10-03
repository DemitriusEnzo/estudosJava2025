package ex16ProgramacaoFuncional.ex3;

import java.util.*;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> contador = new HashMap<>();
        String frase;

        System.out.print("Informe uma frase --> ");
        frase = sc.nextLine();

        for(char c : frase.toLowerCase().toCharArray()) {
            if(Character.isLetter(c)) {
                //int aux = contador.get(c);
                contador.put(c, contador.getOrDefault(c, 0) + 1);
            }
        }

        // impressão dos elementos do mapa na ordem natural
        for(Map.Entry<Character, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        // impressão com os elementos do map em ordem alfabética
        System.out.println();
        Set<Character> chave = contador.keySet();
        TreeSet<Character> arvore = new TreeSet<>(chave);
        for(Character c : arvore) {
            System.out.println(c + " --> " + contador.get(c));
        }
    }
}
