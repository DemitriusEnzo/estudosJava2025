package ex07;

import java.util.Scanner;

public class Util {
    private static Controle controle = new Controle();
    private static Scanner on = new Scanner(System.in);

    public void menu() {
        int opc;
        System.out.println(menuOpcoes());

        while (true) {
            System.out.print("opcao - >");
            opc = on.nextInt();
            switch (opc) {
                case 1 -> cadastrarEmpregado();
                case 2 -> pesquisarEmpregado();
                case 3 -> listarEmpregados();
            }
            System.out.println("\n" + menuOpcoes());
        }
    }

    private void listarEmpregados() {
        System.out.println("Lista de empregados: ");
        String lista = controle.listarEmpregados();
        System.out.println(lista);
    }

    private void pesquisarEmpregado() {
        System.out.println("Insira o numero de matricula: ");
        long matricula = on.nextLong();
        Empregado pesquisado = controle.pesquisarEmpregado(matricula);
        String dados = pesquisado == null ? "Não encontrado" : pesquisado.toString();
        System.out.println(dados);
    }

    private void cadastrarEmpregado() {
        System.out.println("Insira a matricula");
        long matricula = on.nextInt();
        on.nextLine();
        System.out.println("Insira o nome");
        String nome = on.nextLine();
        System.out.println("Qual o tipo de empregado? (Horista = 1 / Comissionado = 2)");
        int resposta = on.nextInt();
        switch (resposta) {
            case 1 -> {
                System.out.println("Insira total horas");
                int totalHoras = on.nextInt();
                System.out.println("Insira valor hora");
                double valorHora = on.nextDouble();
                Empregado e = new EmpregadoHorista(matricula, nome, totalHoras, valorHora);
                controle.inserirEmpregado(e);
            }
            case 2 -> {
                System.out.println("Insira total vendas");
                int totalVendas = on.nextInt();
                System.out.println("Insira valor de comissao");
                double valorComissao = on.nextDouble();
                Empregado e = new EmpregadoHorista(matricula, nome, totalVendas, valorComissao);
                controle.inserirEmpregado(e);
            }
        }
    }
    private String menuOpcoes() {
        return "1 - Inserir empregado." +
                "\n2 - Pesquisar empregado" +
                "\n3 - Listar empregados";
    }
}
