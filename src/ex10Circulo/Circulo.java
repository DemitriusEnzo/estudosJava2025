package ex10Circulo;

public class Circulo extends Forma {

    public Circulo(int x, int y, double raio) {
        super(x, y, raio);
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
