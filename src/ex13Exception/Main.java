package ex13Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Sensor> listaSensor = new ArrayList<>();
        List<List<Double>> listaLeitura = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            listaSensor.add(new Sensor(String.valueOf(i)));
            listaLeitura.add(gerar(i));
        }

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processarSensores(listaSensor, listaLeitura);
        sistema.exibirRelatorio();
    }

    private static List<Double> gerar(int i) {
        Random rd = new Random();
        int total = 100;
        int limite = 60;
        List<Double> lista = new ArrayList<>();

        switch (i) {
            case 2 -> total = total / 2;
            case 3 -> limite = limite * 3;
        }

        for (int j = 0; j < total; j++) {
            lista.add(rd.nextDouble(-limite, limite));
        }

        return lista;
    }
}
