package exFuncionario;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Enzo", "Diretor", 5000);
        System.out.println(funcionario);
        funcionario.aumentarSalarioFunc(0.05);
        System.out.println(funcionario);
        funcionario.aumentarSalarioCargoFunc("Diretor", 0.05);
        System.out.println(funcionario);
        funcionario.aumentarSalarioCargoFunc("CEO", 0.1);
        System.out.println(funcionario);
        funcionario.alteraCargo("CEO");
        System.out.println(funcionario);
        funcionario.aumentarSalarioCargoFunc("CEO", 0.5);
        System.out.println(funcionario);
    }
}
