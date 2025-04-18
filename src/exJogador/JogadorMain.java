package exJogador;

import java.util.Scanner;

public class JogadorMain {
    public static void main(String[] args) {
        Scanner on = new Scanner(System.in);
        Jogador j = new Jogador();
        System.out.println("Informe o nome do jogador: ");
        j.setNome(on.nextLine());

        for(int i = 0; i < 3; ++i) {
            System.out.println("Qual a pontuação da " + (i + 1) + "° rodada?");
            j.setPontuacao(i, on.nextInt());
        }

        System.out.println(j);
    }
}
