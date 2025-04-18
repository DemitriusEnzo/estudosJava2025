package exAluno;

public class Aluno {
    private int rm;
    private String nome;
    private String[] disciplinas = new String[3];
    private double[][] notas = new double[3][2];

    public Aluno(String nome, int rm) {
        this.nome = nome;
        this.rm = rm;
    }

    public void setDisciplina(int index, String disciplina) {
        this.disciplinas[index] = disciplina;
    }

    public String getDisciplina(int index) {
        return this.disciplinas[index];
    }

    public void setNota(int disciplina, int prova, double nota) {
        this.notas[disciplina][prova] = nota;
    }

    public double getMedia(int i) {
        return (this.notas[i][0] + this.notas[i][1]) / 2;
    }

    public static boolean verificaAprovacao(double media) {
        return media >= 6;
    }

    public void exibirDados() {
        System.out.print("Nome: " + this.nome);
        System.out.print("RM: " + this.rm);
        System.out.println("\n");

        for(int i = 0; i < 3; ++i) {
            String disciplina = this.disciplinas[i];
            System.out.println("Disciplina: " + disciplina);

            for(int j = 0; j < 2; ++j) {
                System.out.println("\tNota: " + this.notas[i][j]);
            }

            System.out.println();
            System.out.println("Média de notas de " + disciplina + ": " + getMedia(i));
            String status = verificaAprovacao(getMedia(i)) ? "Aprovado" : "Reprovado";
            System.out.println(status + "\n");
        }

    }
}
