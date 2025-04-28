package exEntrega;

import java.util.ArrayList;

public class MainEnum {
    public static void main(String[] args) {
        ArrayList<EntregaEnum> lista = new ArrayList<>();
        lista.add(new EntregaEnum("RJ", 600, TipoEntrega.ENTREGA));
        lista.add(new EntregaEnum("NYC", 10000, TipoEntrega.ENTREGA_INTERNACIONAL));
        lista.add(new EntregaEnum("BA", 3000, TipoEntrega.ENTREGA_EXPRESSA));

        System.out.println(lista);

        lista.remove(0);
        System.out.println(lista);
    }
}
