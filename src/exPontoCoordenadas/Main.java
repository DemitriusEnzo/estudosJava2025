package exPontoCoordenadas;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner on = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");
        Ponto p1 = new Ponto();
        Ponto p2 = new Ponto();

        System.out.println("Digite as coordenadas x e y do primeiro ponto: ");
        p1.x = on.nextInt();
        p1.y = on.nextInt();

        System.out.println("Digite as coordenadas x e y do segundo ponto: ");
        p2.x = on.nextInt();
        p2.y = on.nextInt();

        System.out.println();
        System.out.println("distância entre o ponto p1 e p2: " + df.format(p1.calcularDistancia(p2)));
        System.out.println("distância entre o ponto p2 e p1: " + df.format(p2.calcularDistancia(p1)));

        System.out.println();
        System.out.println("distância de p1 até a origem: " + df.format(p1.calcularDistanciaAteOrigem()));
        System.out.println("distância de p2 até a origem: " + df.format(p2.calcularDistanciaAteOrigem()));

        System.out.println();
        Ponto maisProximo = Ponto.maisPertoDaOrigem(p1, p2);
        System.out.println("ponto mais próximo da oriem: ");
        System.out.println("x = " + maisProximo.x + ", y = " + maisProximo.y);

        on.close();
    }
}
