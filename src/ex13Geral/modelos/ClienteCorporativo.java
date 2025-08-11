package ex13Geral.modelos;

import ex13Geral.interfaces.Descontavel;

public class ClienteCorporativo extends Cliente implements Descontavel {
    private String cnpj;
    private static final double desconto = 0.20;

    public ClienteCorporativo(String nome, String contato, String cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    @Override
    public double aplicarDesconto(double valor) {
        return valor - (valor * desconto);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCNPJ: " + cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
