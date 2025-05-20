package ex12Geral.modelos.aeroporto;

public class Assento {
    private int numero;
    private boolean disponivel;

    public Assento(int numero) {
        this.numero = numero;
        this.disponivel = true;
    }

    public Assento() {}

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "" + numero;
    }
}
