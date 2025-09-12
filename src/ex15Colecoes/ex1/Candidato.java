package ex15Colecoes.ex1;

public class Candidato {
    private String nome;
    private double notaTecnica;
    private int anosExperiencia;

    public Candidato(String nome, double notaTecnica, int anosExperiencia) {
        this.nome = nome;
        this.notaTecnica = notaTecnica;
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public String toString() {
        return String.format("Nome = %s | Nota técnica = %.2f | Anos de experiência = %d", nome, notaTecnica, anosExperiencia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaTecnica() {
        return notaTecnica;
    }

    public void setNotaTecnica(double notaTecnica) {
        this.notaTecnica = notaTecnica;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}
