package ex12Geral.modelos.cliente;

import ex12Geral.interfaces.Descontavel;

import java.io.Serializable;
import java.util.Random;

public class PessoaJuridica extends Cliente implements Descontavel {
    private String cnpj;

    public PessoaJuridica(String nome, String contato, String cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    @Override
    public double getDesconto(double valorOriginal) {
        return ((valorOriginal * new Random().nextInt(10) + 1)/100);
    }

    @Override
    public String getIdentificador() {
        return cnpj;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += super.toString();
        aux += "CNPJ: " + cnpj;
        return aux;
    }
}
