package ex7Empregados;

public class EmpregadoComissionado extends Empregado {
    private int totalVendas;
    private double valorComissao;

    public EmpregadoComissionado(long matricula, String nome, int totalVendas, double valorComissao) {
        super(matricula, nome);
        this.totalVendas = totalVendas;
        this.valorComissao = valorComissao;
    }

    @Override
    public double calcularSalario() {
        return totalVendas * valorComissao / 100;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Total de Vendas: " + totalVendas + "\n Valor Comissao: " + valorComissao + "\n Salario: " + calcularSalario();
    }
}
