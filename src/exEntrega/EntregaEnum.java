package exEntrega;

public class EntregaEnum {
    private String destino;
    private double distancia;
    private TipoEntrega tipoEntrega;

    public EntregaEnum(String destino, double distancia, TipoEntrega tipoEntrega) {
        this.destino = destino;
        this.distancia = distancia;
        this.tipoEntrega = tipoEntrega;
    }

    public int calcularTempoEntrega() {
        return tipoEntrega.calculaTempoEntrega(distancia);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "EntregaEnum{" +
                "destino='" + destino + '\'' +
                ", distancia=" + distancia +
                ", tipoEntrega=" + tipoEntrega +
                ", tempoEntrega=" + calcularTempoEntrega() +
                '}';
    }
}
