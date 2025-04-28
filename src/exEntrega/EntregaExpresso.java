package exEntrega;

public class EntregaExpresso extends Entrega {
    public EntregaExpresso(String destino, double distancia) {
        super(destino, distancia);
    }

    @Override
    public int calcularTempoEntrega() {
        return super.calcularTempoEntrega() / 2;
    }
}
