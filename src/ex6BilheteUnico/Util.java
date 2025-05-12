package ex6BilheteUnico;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;
import java.util.Random;

public class Util {
    private final int BMAX = 5;
    private BilheteUnico[] bilhetes = new BilheteUnico[BMAX];
    private int index = 0;

    public void menuPrincipal() {
        int opcao = 0;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        while(opcao != 3) {
            try {
                opcao = parseInt(showInputDialog(menu));
                if (opcao < 1 || opcao > 3) {
                    showMessageDialog(null, "Opção incorreta.");
                    break;
                }

                switch (opcao) {
                    case 1:
                        menuAdministrador();
                        break;
                    case 2:
                        menuUsuario();
                        break;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Entrada inválida.");
                this.menuPrincipal();

            }
        }
    }

    private BilheteUnico encontraUsuario() {
        String nomeUsuario = showInputDialog(null, "Insira o nome do usuário.");

        for (BilheteUnico bilhete : bilhetes) {
            if (bilhete != null && bilhete.getUsuario().getNome().equalsIgnoreCase(nomeUsuario)) {
                return bilhete;
            }
        }
        return null;
    }

    private void menuUsuario() {
        try {
            int opcaoUsuario;
            String usuario = "1. Consultar Saldo\n2. Carregar Bilhete\n3. Passar Catraca\n4.Sair";

            while(true) {
                opcaoUsuario = parseInt(showInputDialog(usuario));
                if (opcaoUsuario > 4 || opcaoUsuario < 1) {
                    showMessageDialog(null, "Opção incorreta.");
                    break;
                }

                if(opcaoUsuario == 4) {
                    break;
                }

                BilheteUnico bilhete = encontraUsuario();
                if(bilhete != null) {
                    switch (opcaoUsuario) {
                        case 1:
                            bilhete.consultarSaldo();
                            break;
                        case 2:
                            bilhete.carregarBilhete();
                            break;
                        case 3:
                            bilhete.passarCatraca();
                            break;
                    }
                } else {
                    showMessageDialog(null, "Usuário não encontrado.");
                }
            }
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Entrada inválida.");
            menuAdministrador();
        }
    }

    private void menuAdministrador() {
        try {
            int opcaoAdm = 0;
            String administrador = "1. Emitir bilhete\n2. Listar bilhetes\n3. Remover Bilhete\n4.Aumentar Tarifa\n5.Sair";

            while(opcaoAdm != 5) {
                opcaoAdm = parseInt(showInputDialog(administrador));
                if (opcaoAdm > 5 || opcaoAdm < 1) {
                    showMessageDialog(null, "Opção incorreta.");
                    break;
                }

                switch (opcaoAdm) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        listaBilhetes();
                        break;
                    case 3:
                        removerBilhete();
                        break;
                    case 4:
                        aumentarTarifa();
                        break;
                }
            }
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Entrada inválida.");
            menuAdministrador();
        }
    }

    private void aumentarTarifa() {
        double aumento = parseDouble(showInputDialog(null, "Insira o valor de aumento."));
        for(BilheteUnico bilhete : bilhetes) {
            bilhete.getTarifa().aumentarTarifa(aumento);
        }
    }

    private void removerBilhete() {
        try {
            BilheteUnico bilheteUsuario = encontraUsuario();
            int resposta = showConfirmDialog(null, "Tem certeza que deseja remover?");
            if(resposta == YES_OPTION) {
                for(int i = 0; i < bilhetes.length; ++i) {
                    if (bilhetes[i] == bilheteUsuario) {
                        bilhetes[i] = null;
                        break;
                    }
                }

                for(int i = 0; i < this.bilhetes.length - 1; ++i) {
                    if (bilhetes[i] == null) {
                        bilhetes[i] = bilhetes[i + 1];
                        bilhetes[i + 1] = null;
                    }
                }

                index++;
                showMessageDialog(null, "Bilhete removido com sucesso.");
            }
        } catch (NullPointerException e) {
            showMessageDialog(null, "Usuário não encontrado.");
        }

    }

    private void armazenaBilhete(BilheteUnico bilheteUnico) {
        if (bilheteUnico != null) {
            bilhetes[index] = bilheteUnico;
            index++;
        } else {
            showMessageDialog(null, "Erro ao emitir bilhete.");
        }

    }

    private void emitirBilhete() {
        if (index != (BMAX-1)) {
            String nome = showInputDialog("Nome usuario.");
            String cpf = showInputDialog("cpf usuario");
            Usuario usuario = new Usuario(nome, cpf);
            armazenaBilhete(gerarBilhete(usuario));
        } else {
            showMessageDialog(null, "Limite de bilhetes atingido.");
        }

    }

    private BilheteUnico gerarBilhete(Usuario usuario) {
        String tipoTarifaInput = showInputDialog(null, "Qual o tipo da tarifa?");
        TipoTarifa tipoTarifa = null;
        boolean encontrado = false;

        for(TipoTarifa t : TipoTarifa.values()) {
            if (t.name().equalsIgnoreCase(tipoTarifaInput)) {
                tipoTarifa = t;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            int nBilhete = (new Random()).nextInt(0, 100);
            Tarifa tarifa = new Tarifa(5, tipoTarifa);
            BilheteUnico bilheteUnico = new BilheteUnico(usuario, tarifa, nBilhete);
            showMessageDialog(null, "Bilhete único emitido.");
            return bilheteUnico;
        }

        return null;
    }

    private void listaBilhetes() {
        if (bilhetes[0] != null) {
            StringBuilder bilhetesImpressos = new StringBuilder();

            for(BilheteUnico bilhete : bilhetes) {
                if (bilhete != null) {
                    bilhetesImpressos.append(bilhete).append("\n");
                }
            }

            showMessageDialog(null, bilhetesImpressos.toString());
        } else {
            showMessageDialog(null, "Nenhum bilhete gerado até o momento.");
        }
    }
}
