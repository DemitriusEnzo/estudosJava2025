package ex9Entrega;

public class Entrega {
    private String destino;
    private double distancia;

    public Entrega(String destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public int calcularTempoEntrega() {
        return (int) (distancia / 100);
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
}
