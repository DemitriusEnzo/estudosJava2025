package ex14Exception;

import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensorComErro;

    public SistemaMonitoramento() {
        this.sensoresValidos = new ArrayList<>();
        this.sensorComErro = new ArrayList<>();
    }

    public void processarSensores(List<Sensor> listaSensor, List<List<Double>> dados) {
        for (int i = 0; i < listaSensor.size(); i++) {
            Sensor sensor = listaSensor.get(i);
            List<Double> leitura = dados.get(i);

            try {
                sensor.registrarLeitura(leitura);
                sensoresValidos.add(sensor);
            } catch (LeituraInvalidaException | IllegalArgumentException e) {
                sensorComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
            }
        }
    }

    public void exibirRelatorio() {
        System.out.println("===== Sensores válidos =====");
        for (Sensor sensor : sensoresValidos) {
            System.out.println("Sensor: " + sensor.getId());
            System.out.println();
        }

        System.out.println("===== Sensores com erro =====");
        for (ErroSensor sensor : sensorComErro) {
            System.out.println("Sensor com erro: " + sensor.getIdSensor());
            System.out.println("Erro: " + sensor.getMensagemErro());
            System.out.println();
        }
    }
}
