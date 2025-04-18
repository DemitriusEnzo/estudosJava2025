package exEmpregados;

public class EmpregadoHorista extends Empregado {
    private int totalHoras;
    private double valorHora;

    public EmpregadoHorista(long matricula, String nome, int totalHoras, double valorHora) {
        super(matricula, nome);
        this.totalHoras = totalHoras;
        this.valorHora = valorHora;
    }

    public double calcularSalario() {
        return totalHoras * valorHora;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Total Horas: " + totalHoras + "\n Valor Hora: " + valorHora + "\n Salario: " + calcularSalario();
    }
}
