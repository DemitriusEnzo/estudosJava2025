package ex9Entrega;

public enum TipoEntrega {
    ENTREGA {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) Math.ceil(distancia / DISTANCIA_BASE);
        }
    },
    ENTREGA_EXPRESSA {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) Math.ceil((distancia / DISTANCIA_BASE) / 2);
        }
    },
    ENTREGA_INTERNACIONAL {
        @Override
        public int calculaTempoEntrega(double distancia) {
            return (int) Math.ceil((distancia / DISTANCIA_BASE)) + 5;
        }
    };

    protected static final double DISTANCIA_BASE = 100;

    public abstract int calculaTempoEntrega(double distancia);
}
