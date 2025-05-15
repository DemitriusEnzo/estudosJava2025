package ex11Geral.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class Controle {
    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Produto> listaProduto = new ArrayList<>();
    private NotaFiscal nf;

    static {
        listaCliente.add(new Cliente(123, "Ana Maria"));
        listaCliente.add(new Cliente(321, "Roberto Carlos"));
        listaCliente.add(new Cliente(789, "Xuxa Maria"));

        listaProduto.add(new Produto(1, "camiseta", 500, 100));
        listaProduto.add(new Produto(2, "calça", 1500, 1000));
        listaProduto.add(new Produto(3, "boné", 200, 500));
    }

    public Controle() {
        Cliente cliente = listaCliente.get(new Random().nextInt(listaCliente.size()));
        nf = new NotaFiscal(cliente);
    }

    public void menu() {
        int opcao;
        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                if(opcao == 5) {
                    return;
                }

                switch (opcao) {
                    case 1 -> comprar();
                    case 3 -> removerProduto();
                    case 4 -> fecharCompra();
                }

            } catch (Exception e) {
                showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void removerProduto() {
        String nome = showInputDialog("Insira o nome do produto a ser removido.");
        Produto produto = new Produto(nome);
        nf.removerItemProduto(produto);
    }

    private void fecharCompra() {
        double total = 0;
        for (ItemProduto i : nf.getListaProduto()) {
            total += i.calcularTotal();
        }

        showMessageDialog(null, "R$ " + total);
    }

    private void comprar() {
        int quantidade;
        String nomeProduto = showInputDialog("Digite o nome do produto para compra: ");
        boolean encontrouProduto = false;
        for (Produto p : listaProduto) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                quantidade = parseInt(showInputDialog("Qual a quantidade para compra?"));
                p.debitarEstoque(quantidade);
                nf.adicionarItemProduto(new ItemProduto(p, quantidade));
                encontrouProduto = true;
            }
        }

        if(!encontrouProduto) {
            showMessageDialog(null, "Produto não encontrado");
        }
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE COMPRAS ONLINE\n";
        aux += "1. Comprar\n";
        aux += "2. Adicionar produto\n";
        aux += "3. Remover produto\n";
        aux += "4. Fechar compra\n";
        aux += "5. Finalizar compra\n";
        return aux;
    }
}
