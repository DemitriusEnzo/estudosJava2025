package ex9Entrega;

public class EntregaInternacional extends Entrega {

    public EntregaInternacional(String destino, double distancia) {
        super(destino, distancia);
    }

    @Override
    public int calcularTempoEntrega() {
        return super.calcularTempoEntrega() + 5;
    }
}
