package ex03;

public class Ponto {
    int x;
    int y;

    public double calcularDistancia(Ponto p) {
        return Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
    }

    public double calcularDistanciaAteOrigem() {
        Ponto origem = new Ponto();
        origem.x = 0;
        origem.y = 0;
        return calcularDistancia(origem);
    }

    public static Ponto maisPertoDaOrigem(Ponto p1, Ponto p2) {
        double dp1 = p1.calcularDistanciaAteOrigem();
        double dp2 = p2.calcularDistanciaAteOrigem();
        return dp1 < dp2 ? p1 : p2;
    }
}
