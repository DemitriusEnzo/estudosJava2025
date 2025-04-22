package exHotel;

public class SistemaReservaHotel {
    private int quartosDisponiveis;

    public void reservaQuarto(String nomeCliente, int quantidadeQuartos) throws FalhaSistemaException, ReservaInvalidaException {
        if(Math.random() < 0.2)
            throw new FalhaSistemaException("Falha técnica do sistema.");

        if(quantidadeQuartos <= 0)
            throw new ReservaInvalidaException("Quantidade de quartos invalida.");

        if(quartosDisponiveis >= quantidadeQuartos) {
            quartosDisponiveis -= quantidadeQuartos;
            System.out.println("Cliente: " + nomeCliente + " Quantidade reservada: " + quantidadeQuartos);
        } else {
            throw new QuartosIndisponiveisException("Quantidade de quartos indisponivel");
        }
    }

    public int getQuartosDisponiveis() {
        return quartosDisponiveis;
    }

    public void setQuartosDisponiveis(int quartos) {
        quartosDisponiveis = quartos;
    }
}
