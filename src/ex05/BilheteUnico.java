package ex05;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;

public class BilheteUnico {
    private Usuario usuario;
    private Tarifa tarifa;
    private int nBilhete;
    private double saldo;

    public BilheteUnico(Usuario usuario, Tarifa tarifa, int nBilhete) {
        this.usuario = usuario;
        this.tarifa = tarifa;
        this.nBilhete = nBilhete;
    }

    public void consultarSaldo() {
        showMessageDialog(null, "Saldo atual: " + this.saldo);
    }

    public void passarCatraca() {
        double tarifaComDesconto = this.tarifa.getTipoTarifa().calcularTarifaComDesconto(this.tarifa.getTarifaBase());
        if (this.saldo >= tarifaComDesconto) {
            this.saldo -= tarifaComDesconto;
            System.out.println("Passagem realizada com sucesso! Tarifa descontada: " + tarifaComDesconto);
        } else {
            System.out.println("Saldo insuficiente para realizar a passagem.");
        }

    }

    public void carregarBilhete() {
        double valor = parseDouble(showInputDialog(null, "Insira o valor de recarga."));
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Bilhete carregado com sucesso! Novo saldo: " + this.saldo);
        } else {
            System.out.println("Valor inválido para carregar o bilhete.");
        }

    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Tarifa getTarifa() {
        return this.tarifa;
    }

    @Override
    public String toString() {
        return "BilheteUnico: " +
                "\n\t" + usuario +
                ", \ntarifa: " + tarifa +
                ", \nnBilhete: " + nBilhete +
                ", \nsaldo: " + saldo +
                "\n";
    }
}
