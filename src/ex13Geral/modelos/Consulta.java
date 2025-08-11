package ex13Geral.modelos;

public class Consulta {
    private Cliente cliente;
    private Consultorio consultorio;
    private String horario;
    private double valor;

    public Consulta(Cliente cliente, Consultorio consultorio, String horario, double valor) {
        this.cliente = cliente;
        this.consultorio = consultorio;
        this.horario = horario;
        this.valor = valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Consulta com: " + cliente + "\nConsultorio: " + consultorio.getId() + "\nHorario: " + horario + "\nValor: " + valor;
    }
}
