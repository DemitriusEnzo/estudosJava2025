package ex13Geral.modelos;

public class Consultorio {
    private int id;
    private boolean disponivel;

    public Consultorio(int id) {
        this.id = id;
        this.disponivel = true;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public int getId() {
        return id;
    }
}
