package ex12Geral.modelos.aeroporto;

import ex12Geral.modelos.cliente.Cliente;

public class Reserva {
    private Cliente cliente;
    private Assento assento;
    private double valor;
    private double valorFinal;

    public Reserva(Cliente cliente, Assento assento, double valor, double valorFinal) {
        this.cliente = cliente;
        this.assento = assento;
        this.valor = valor;
        this.valorFinal = valorFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "Reserva: \n" +
                "Cliente -> " + cliente + "\n" +
                "Assento -> " + assento + "\n" +
                "Valor -> " + valor + "\n" +
                "ValorFinal -> " + valorFinal;
    }
}
