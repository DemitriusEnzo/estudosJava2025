package exEmpregados;

public abstract class Empregado {
    protected long matricula;
    protected String nome;

    protected Empregado(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    protected abstract double calcularSalario();

    @Override
    public String toString() {
        return "Nome: " + nome + "\nMatricula: " + matricula;
    }

    public long getMatricula() {
        return matricula;
    }
}
