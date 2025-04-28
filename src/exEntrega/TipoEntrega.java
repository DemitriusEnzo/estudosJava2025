package exEntrega;

public enum TipoEntrega {
    ENTREGA {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) distancia / 100;
        }
    },
    ENTREGA_EXPRESSA {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) (distancia / 100) / 2;
        }
    },
    ENTREGA_INTERNACIONAL {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) (distancia / 100) + 5;
        }
    };

    public abstract int calculaTempoEntrega(double distancia);
}
