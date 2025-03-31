package ex05;

public enum TipoTarifa {
    ESTUDANTE {
        @Override
        public double calcularTarifaComDesconto(double tarifaBase) {
            return tarifaBase * 0.5;
        }
    },
    PROFESSOR {
        @Override
        public double calcularTarifaComDesconto(double tarifaBase) {
            return tarifaBase * 0.5;
        }
    },
    NORMAL {
        @Override
        public double calcularTarifaComDesconto(double tarifaBase) {
            return tarifaBase;
        }
    };

    public abstract double calcularTarifaComDesconto(double tarifaBase);
}
