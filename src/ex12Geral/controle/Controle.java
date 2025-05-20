package ex12Geral.controle;
import ex12Geral.interfaces.Descontavel;
import ex12Geral.modelos.aeroporto.Assento;
import ex12Geral.modelos.aeroporto.Reserva;
import ex12Geral.modelos.cliente.Cliente;
import ex12Geral.modelos.cliente.PessoaFisica;
import ex12Geral.modelos.cliente.PessoaJuridica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Controle {
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static List<Reserva> listaReservas = new ArrayList<>();
    private static List<Assento> listaAssentos = new ArrayList<>();

    static {
        listaClientes.add(new PessoaFisica("Roberto", "119", "123"));
        listaClientes.add(new PessoaFisica("Eloisa", "111", "321"));
        listaClientes.add(new PessoaJuridica("Myke", "129", "123/100"));
        listaClientes.add(new PessoaJuridica("Gab", "121", "321/100"));

        for (int i = 0; i <= 10; i++ ) {
            listaAssentos.add(new Assento(i));
        }
    }

    public void menu() {
        int opc;
        while (true) {
            try {
                opc = parseInt(showInputDialog(gerarMenu()));

                switch(opc) {
                    case 1 -> reservar();
                    case 2 -> pesquisar();
                    case 3 -> cancelar();
                    case 4 -> {return;}
                    default -> showMessageDialog(null, "Opcao invalida.");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Opcao invalida.");
            }
        }
    }

    private void cancelar() {
        String id = showInputDialog("Insira CPF/CNPJ para pesquisa:");
        Cliente cliente = buscaCliente(id);

        if(cliente != null) {
            Iterator<Reserva> iterator = listaReservas.iterator();
            while(iterator.hasNext()) {
                Reserva r = iterator.next();
                if(r.getCliente().equals(cliente)) {
                    iterator.remove();
                    showMessageDialog(null, "Reserva removida com sucesso!");
                    break;
                }
            }
        } else {
            showMessageDialog(null, "CNPJ/CPF não encontrado ou invalido.");
        }
    }

    private void pesquisar() {
        String id = showInputDialog("Insira CPF/CNPJ para pesquisa:");
        Cliente cliente = buscaCliente(id);
        if(cliente != null) {
            for (Reserva r : listaReservas) {
                if(r.getCliente().equals(cliente)) {
                    showMessageDialog(null, r.toString());
                    break;
                }
            }
        } else {
            showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private void reservar() {
        Assento assento = null;
        int opcAssento = parseInt(showInputDialog("Escolha seu assento: \n" + listaAssentosDisponiveis()));
        boolean encontrou = false;
        for (Assento a : listaAssentos) {
            if(a.getNumero() == opcAssento && a.isDisponivel()) {
                assento = a;
                encontrou = true;
                break;
            }
        }

        if(!encontrou) {
            showMessageDialog(null, "Assento invalido ou ja reservado.");
        } else {
            double valorPassagem = 300;
            showMessageDialog(null, "O valor da sua passagem é de R$" + valorPassagem);

            String id = showInputDialog("Insira CPF/CNPJ para pesquisa:");
            Cliente cliente = buscaCliente(id);
            if(cliente == null) {
                showMessageDialog(null, "Cliente não encontrado.");
            } else {
                double valorFinal = (cliente instanceof Descontavel d) ? valorPassagem - d.getDesconto(valorPassagem) : valorPassagem;
                listaReservas.add(new Reserva(cliente, assento, valorPassagem, valorFinal));
                assento.setDisponivel(false);
                showMessageDialog(null, "Reserva feita.");
            }
        }
    }

    private Cliente buscaCliente(String id) {
        for (Cliente c : listaClientes) {
            if (c.getIdentificador().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private String listaAssentosDisponiveis() {
        StringBuilder b = new StringBuilder();
        for (Assento assento : listaAssentos) {
            if(assento.isDisponivel()) {
                b.append("Assento: " + assento.getNumero() + "\n");
            }
        }
        return b.toString();
    }

    private String gerarMenu() {
        return "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n" +
                "1. RESERVAR\n" +
                "2. PESQUISAR RESERVA\n" +
                "3. CANCELAR RESERVA\n" +
                "4. FINALIZAR";
    }
}
