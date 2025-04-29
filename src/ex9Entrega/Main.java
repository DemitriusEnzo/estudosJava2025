package ex9Entrega;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Entrega> lista = new ArrayList<>();
        lista.add(new Entrega("RJ", 600));
        lista.add(new Entrega("NYC", 10000));

        for (Entrega entrega : lista) {
            System.out.println(entrega);
        }
    }
}
