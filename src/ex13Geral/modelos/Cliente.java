package ex13Geral.modelos;

public abstract class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Cliente " + nome + "\nContato: " + contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}
