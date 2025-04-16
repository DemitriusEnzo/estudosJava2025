package ex07;

import java.util.Arrays;

public class Controle {
    private Empregado[] empregados = new Empregado[4];

    public void inserirEmpregado(Empregado empregado) {
        boolean inserido = false;
        for (int i = 0; i < empregados.length; i++) {
            if (empregados[i] == null) {
                empregados[i] = empregado;
                inserido = true;
                System.out.println("Empregado inserido.");
                break;
            }
        }
        if (!inserido)
            System.out.println("Lista de empregados cheia.");
    }

    public Empregado pesquisarEmpregado(long matricula) {
        return Arrays.stream(empregados).filter(e -> e.getMatricula() == matricula).findFirst().orElse(null);
    }

    public String listarEmpregados() {
        StringBuilder aux = new StringBuilder();
        Arrays.stream(empregados).filter(e -> e != null).forEach(e -> aux.append(e + "\n"));
        return aux.toString();
    }
}
