package ex07;

public class Main {
    public static void main(String[] args) {
        EmpregadoComissionado e1 = new EmpregadoComissionado(11, "A", 150, 10);
        EmpregadoHorista e2 = new EmpregadoHorista(22, "B", 500, 10);
        EmpregadoComissionado e3 = new EmpregadoComissionado(33, "C", 230, 8);
        EmpregadoHorista e4 = new EmpregadoHorista(44, "D", 300, 15);

        Controle controle = new Controle();
        controle.inserirEmpregado(e1);
        controle.inserirEmpregado(e2);
        controle.inserirEmpregado(e3);
        controle.inserirEmpregado(e4);

        System.out.println("\n//// ÁREA DE PESQUISA");
        Empregado pesquisado = controle.pesquisarEmpregado(11);
        System.out.println(pesquisado);
        System.out.println("\n//// LISTA DE EMPREGADOS");
        String lista = controle.listarEmpregados();
        System.out.println(lista);
    }
}
