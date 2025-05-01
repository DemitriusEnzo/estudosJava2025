package ex10Circulo;

public abstract class Forma {
    protected int x;
    protected int y;
    protected double raio;

    protected Forma(int x, int y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    protected abstract double calcularArea();

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                ", area=" + calcularArea();
    }
}
