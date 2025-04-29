package ex7Empregados;

import java.util.Arrays;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controle {
    private Empregado[] empregados = new Empregado[4];

    public void inserirEmpregado(Empregado empregado) {
        boolean inserido = false;
        for (int i = 0; i < empregados.length; i++) {
            if (empregados[i] == null) {
                empregados[i] = empregado;
                inserido = true;
                showMessageDialog(null, "Empregado inserido.");
                break;
            }
        }
        if (!inserido)
            showMessageDialog(null, "Lista de empregados cheia.");
    }

    public Empregado pesquisarEmpregado(long matricula) {
        return Arrays.stream(empregados).filter(e -> e != null && e.getMatricula() == matricula).findFirst().orElse(null);
    }

    public String listarEmpregados() {
        StringBuilder aux = new StringBuilder();
        Arrays.stream(empregados).filter(e -> e != null).forEach(e -> aux.append(e + "\n--------------\n"));
        return aux.toString();
    }
}
