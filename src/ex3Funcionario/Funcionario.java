package ex3Funcionario;

public class Funcionario {
    private final String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void alteraCargo(String cargoNovo) {
        this.cargo = cargoNovo;
    }

    public void aumentarSalarioCargoFunc(String cargo, double percentual) {
        if (this.cargo.equals(cargo)) {
            aumentarSalarioFunc(percentual);
        } else {
            System.out.println("Os cargos não coincidem!");
        }

    }

    public void aumentarSalarioFunc(double percentual) {
        this.salario += this.salario * percentual;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
