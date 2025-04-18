package exEmpregados;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

public class Util {
    private static Controle controle = new Controle();
    private static Scanner on = new Scanner(System.in);

    public void menu() {
        int opc;

        while (true) {
            try {
                opc = parseInt(showInputDialog(menuOpcoes()));
                if(opc == 4) break;
                switch (opc) {
                    case 1 -> cadastrarEmpregado();
                    case 2 -> pesquisarEmpregado();
                    case 3 -> listarEmpregados();
                    default -> showMessageDialog(null, "Opcao invalida.");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Apenas numeros sao validos.");
            }
        }
    }

    private void listarEmpregados() {
        String lista = controle.listarEmpregados();
        showMessageDialog(null, "Lista: \n" + lista);
    }

    private void pesquisarEmpregado() {
        long matricula = parseLong(showInputDialog("Insira o numero de matricula:"));
        Empregado pesquisado = controle.pesquisarEmpregado(matricula);
        String dados = pesquisado == null ? "Não encontrado" : pesquisado.toString();
        showMessageDialog(null, "Empregado: \n" + dados);
    }

    private void cadastrarEmpregado() {
        long matricula = parseLong(showInputDialog("Insira o numero de matricula: "));
        String nome = showInputDialog("Insira o nome: ");
        int resposta = parseInt(showInputDialog("Qual o tipo de empregado? (Horista = 1 / Comissionado = 2)"));
        switch (resposta) {
            case 1 -> {
                int totalHoras = parseInt(showInputDialog("Insira o total de horas:"));
                double valorHora = parseDouble(showInputDialog("Insira o valor da hora:"));
                Empregado e = new EmpregadoHorista(matricula, nome, totalHoras, valorHora);
                controle.inserirEmpregado(e);
            }
            case 2 -> {
                int totalVendas = parseInt(showInputDialog("Insira o total de vendas:"));
                double valorComissao = parseDouble(showInputDialog("Insira o valor de comissao:"));
                Empregado e = new EmpregadoComissionado(matricula, nome, totalVendas, valorComissao);
                controle.inserirEmpregado(e);
            }
        }
    }

    private String menuOpcoes() {
        return "1 - Inserir empregado." +
                "\n2 - Pesquisar empregado" +
                "\n3 - Listar empregados" +
                "\n4 - Encerrar";
    }
}
