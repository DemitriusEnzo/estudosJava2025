package exAluno;

import java.util.Scanner;

public class AlunoMain {
    public static void main(String[] args) {
        Scanner on = new Scanner(System.in);
        System.out.println("Informe o nome do aluno: ");
        String nome = on.nextLine();
        System.out.println("Informe o rm do aluno: ");
        int rm = on.nextInt();
        on.nextLine();
        Aluno aluno = new Aluno(nome, rm);

        for(int i = 0; i < 3; ++i) {
            System.out.println("Informe a disciplina " + (i + 1));
            aluno.setDisciplina(i, on.nextLine());
        }

        for(int i = 0; i < 3; ++i) {
            System.out.println();
            String disciplina = aluno.getDisciplina(i);
            System.out.println("Informe as notas da disciplina " + disciplina);

            for(int j = 0; j < 2; ++j) {
                System.out.println("Nota " + (j + 1));
                double nota = on.nextDouble();
                aluno.setNota(i, j, nota);
            }
        }

        aluno.exibirDados();
    }
}
