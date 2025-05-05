package ex10Forma;

public class Cilindro extends Forma implements Volume {
    private double altura;

    public Cilindro(int x, int y, double raio, double altura) {
        super(x, y, raio);
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * Math.PI * Math.pow(raio, 2) + 2 * Math.PI * raio * altura;
    }

    public double calcularVolume() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
