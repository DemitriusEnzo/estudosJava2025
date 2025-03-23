package ex05;

public enum TipoTarifa {
    ESTUDANTE(0.5),
    PROFESSOR(0.5),
    NORMAL(1.0);

    private final double desconto;

    TipoTarifa(double desconto) {
        this.desconto = desconto;
    }

    public double calcularTarifaComDesconto(double tarifaBase) {
        return tarifaBase * this.desconto;
    }
}
