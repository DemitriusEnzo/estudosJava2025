package ex13Geral.servico;
import ex13Geral.modelos.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Controle {
    List<Cliente> clientes = new ArrayList<>();
    List<Consulta> consultas = new ArrayList<>();
    static List<Consultorio> consultorios = new ArrayList<>();

    static {
        for (int i = 0; i <= 5; i++) {
            consultorios.add(new Consultorio(i));
        }
    }

    public void menu() {
        int opc;

        while (true) {
            opc = parseInt(showInputDialog(geraMenu()));
            switch (opc) {
                case 1 -> cadastraCliente();
                case 2 -> agendaConsulta();
                case 3 -> listaConsultas();
                case 4 -> excluiCliente();
                default -> showMessageDialog(null, "Opção incorreta.");
            }
        }
    }

    private void excluiCliente() {
        Cliente c = pesquisaCliente();
        if (c != null) {
            Iterator<Cliente> icli = clientes.iterator();
            while (icli.hasNext()) {
                Cliente clienteAtual = icli.next();
                if (clienteAtual.equals(c)) {
                    icli.remove();
                    break;
                }
            }

            Iterator<Consulta> icon = consultas.iterator();
            while (icon.hasNext()) {
                Consulta consulta = icon.next();
                if (consulta.getCliente().equals(c)) {
                    icon.remove();
                    consulta.getConsultorio().setDisponivel(true);
                }
            }

            showMessageDialog(null, "Cliente e consultas relacionadas removidos.");
        } else {
            showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private void listaConsultas() {
        StringBuilder listaConsultas = new StringBuilder();
        for (Consulta consulta : consultas) {
            listaConsultas.append(consulta.toString()).append("\n");
        }
        if(!listaConsultas.isEmpty()) {
            showMessageDialog(null, listaConsultas.toString());
        } else {
            showMessageDialog(null, "Ainda não foram agendadas consultas.");
        }
    }

    private void agendaConsulta() {
        Cliente c = pesquisaCliente();
        double valor = 100;
        String listaConsultorios = listaConsultoriosDisponiveis();
        if(listaConsultorios == null) {
            showMessageDialog(null, "Não há consultorios disponiveis.");
            return;
        }
        if(c != null) {
            showMessageDialog(null, "Olá " + c.getNome() + ", o valor base da consulta é de: " + valor);
            int idConsultorio = parseInt(showInputDialog("Qual consultorio deseja ter a consulta? veja os disponiveis:" + "\n" + listaConsultorios));
            String horario = showInputDialog("Qual o horario?");
            consultorios.get(idConsultorio).setDisponivel(false);
            if (c instanceof ClienteCorporativo) {
                valor = ((ClienteCorporativo) c).aplicarDesconto(valor);
                showMessageDialog(null, "Por ser cliente corporativo voce tem 20% de desconto!");
            }
            consultas.add(new Consulta(c, consultorios.get(idConsultorio), horario, valor));
        } else {
            showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private String listaConsultoriosDisponiveis() {
        StringBuilder resp = new StringBuilder();
        for (Consultorio consultorio : consultorios) {
            if(consultorio.isDisponivel()) {
                resp.append(consultorio.getId()).append(" ");
            }
        }
        if(!resp.isEmpty()) {
            return resp.toString().trim();
        }
        return null;
    }

    private Cliente pesquisaCliente() {
        String id = showInputDialog("Qual seu CPF/CNPJ?");
        for (Cliente cliente : clientes) {
            if(cliente instanceof ClienteCorporativo) {
                if(((ClienteCorporativo) cliente).getCnpj().equals(id) ) {
                    return cliente;
                }
            } else {
                if(cliente instanceof ClienteIndividual) {
                    if(((ClienteIndividual) cliente).getCpf().equals(id) ) {
                        return cliente;
                    }
                }
            }
        }
        return null;
    }

    private void cadastraCliente() {
        String nome = showInputDialog("Insira seu nome: ");
        String contato = showInputDialog("Insira seu contato: ");
        String tipo = showInputDialog("Corporativo ou Individual? ");
        if (tipo.equals("Corporativo")) {
            String cnpj = showInputDialog("Insira seu cnpj: ");
            clientes.add(new ClienteCorporativo(nome, contato, cnpj));
        } else {
            String cpf = showInputDialog("Insira seu cpf: ");
            clientes.add(new ClienteIndividual(nome, contato, cpf));
        }
    }

    private String geraMenu() {
        return "1 - Cadastrar Cliente\n" +
                "2 - Agendar Consulta\n" +
                "3 - Listar Consultas\n" +
                "4 - Excluir Cliente";
    }
}
