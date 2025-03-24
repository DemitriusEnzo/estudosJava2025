package ex05;

public class Tarifa {
    private double tarifaBase;
    private TipoTarifa tipoTarifa;

    public Tarifa(double tarifaBase, TipoTarifa tipoTarifa) {
        this.tarifaBase = tarifaBase;
        this.tipoTarifa = tipoTarifa;
    }

    public void aumentarTarifa(double aumento) {
        if (aumento > 0) {
            this.tarifaBase += aumento;
        } else {
            System.out.println("Aumento inválido.");
        }

    }

    public double getTarifaBase() {
        return this.tarifaBase;
    }

    public TipoTarifa getTipoTarifa() {
        return this.tipoTarifa;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "tarifaBase=" + tarifaBase +
                ", tipoTarifa=" + tipoTarifa +
                '}';
    }
}
