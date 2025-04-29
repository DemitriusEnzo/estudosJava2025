package ex1Jogador;

import java.util.Arrays;

public class Jogador {
    private String nome;
    private double[] pontuacao = new double[3];

    public Jogador(String nome, double[] pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public Jogador() {
    }

    public double somaPontuacao() {
        return Arrays.stream(this.pontuacao).sum();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontuacao(int index, double pontuacao) {
        this.pontuacao[index] = pontuacao;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", pontuacao=" + Arrays.toString(pontuacao) +
                ", somaPontuacao=" + somaPontuacao() +
                '}';
    }
}
