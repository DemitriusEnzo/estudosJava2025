package ex13Exception;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Double> leituras;
    private String id;

    public Sensor(String id) {
        this.id = id;
        leituras = new ArrayList<>();
    }

    public void registrarLeitura(List<Double> leitura) throws LeituraInvalidaException {
        if(leituras.size() != 100) {
            throw new IllegalArgumentException("O total de leituras deve ser 100!");
        }

        for (int i = 0; i < leituras.size(); i++) {
            double temp = leituras.get(i);
            if(temp < -60 || temp > 60) {
                throw new LeituraInvalidaException(i, temp);
            }
        }
        this.leituras = leitura;
    }

    public String getId() {
        return id;
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "leituras=" + leituras +
                ", id='" + id + '\'' +
                '}';
    }
}
