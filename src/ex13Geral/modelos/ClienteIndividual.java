package ex13Geral.modelos;

public class ClienteIndividual extends Cliente{
    private String cpf;

    public ClienteIndividual(String nome, String contato, String cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCPF: " + cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
