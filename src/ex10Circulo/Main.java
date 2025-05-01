package ex10Circulo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Forma> formas = new ArrayList<>();

        formas.add(new Circulo(2, 2, 5));
        formas.add(new Cilindro(1, 1, 2, 2));
        formas.add(new Circulo(2, 2, 5));
        formas.add(new Cilindro(3, 3 , 3, 3));

        for(Forma f : formas) {
            System.out.println(f.getClass());
            System.out.println(f);
            System.out.println("area: " + f.calcularArea());
            if(f instanceof  Cilindro) {
                System.out.println("volume: " + ((Cilindro) f).calcularVolume());
            }
            System.out.println("------------------------");
        }
    }
}
