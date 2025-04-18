package exProdutoFornecedor;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class Util {
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private Produto[] produto = new Produto[2*fornecedor.length];
    private int idxFornecedor = 0;
    private int idxProduto = 0;

    public void menu() {
        int opcao;
        String aux = "1. Cadastrar produto\n" +
                "2. Pesquisar produto\n" +
                "3. Pesquisar fornecedor\n" +
                "4. Finalizar";

        while(true) {
            try {
                opcao = parseInt(showInputDialog(aux));
                if(opcao == 4) {
                    return;
                }

                switch(opcao) {
                    case 1 -> cadastrarProduto();
                    case 2 -> pesquisarProduto();
                    case 3 -> pesquisar();
                    default -> showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Apenas números são válidos.");
            }
        }
    }

    public void cadastrarProduto() {
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor == null) {
            showMessageDialog(null, "Cadastre este fornecedor:");
            fornecedor = cadastrarFornecedor();
        }

        String nome = showInputDialog("Nome do produto:");
        int qtdEstoque = parseInt(showInputDialog("Quantidade em estoque:"));
        double valorUnitario = parseDouble(showInputDialog("Valor unitário:"));
        produto[idxProduto++] = new Produto(nome, valorUnitario, qtdEstoque, fornecedor);
    }

    public Fornecedor cadastrarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor:"));
        String nome = showInputDialog("Fornecedor:");
        fornecedor[idxFornecedor++] = new Fornecedor(nome, cnpj);
        return fornecedor[idxFornecedor - 1];
    }

    public Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor:"));
        for(int i = 0; i < idxFornecedor; i++) {
            if(fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, cnpj + " não encontrado.");
        return null;
    }

    public void pesquisar() {
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor != null) {
            showMessageDialog(null, fornecedor.getCnpj() + "\n" +
                    fornecedor.getNome());
        }
    }

    public void pesquisarProduto() {
        String aux = "Produto não encontrado.";
        String nome = showInputDialog("Nome do produto:");
        for(int i = 0; i < idxProduto; i++) {
            if(produto[i].getNome().equalsIgnoreCase(nome)) {
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário: R$ " + produto[i].getValor() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
                break;
            }
        }
        showMessageDialog(null, aux);
    }
}
