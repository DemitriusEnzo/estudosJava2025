package ex12Geral.modelos.cliente;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String contato, String cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += super.toString();
        aux += "CPF: " + cpf;
        return aux;
    }
}
