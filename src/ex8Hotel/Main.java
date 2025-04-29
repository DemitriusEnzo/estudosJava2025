package ex8Hotel;

public class Main {
    public static void main(String[] args) {
        SistemaReservaHotel hotel = new SistemaReservaHotel();
        hotel.setQuartosDisponiveis(5);

        try {
            hotel.reservaQuarto("A", 5);
            hotel.reservaQuarto("B", 5);
            hotel.reservaQuarto("C", 10);
        } catch (ReservaInvalidaException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (FalhaSistemaException e) {
            System.out.println("Erro técnico: " + e.getMessage());
        }
    }
}
