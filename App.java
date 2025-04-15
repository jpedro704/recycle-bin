package app;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    static int id = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "MENU:\n1 - Gravar\n2 - Alterar\n3 - Excluir\n4 - Listar\n0 - Sair\nEscolha uma opção:"));
            switch (opcao) {
                case 1 -> gravar();
                case 2 -> alterar();
                case 3 -> excluir();
                case 4 -> listar();
                case 0 -> JOptionPane.showMessageDialog(null, "Encerrando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void gravar() {
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
        Pessoa p = new Pessoa(nome, idade);
        listaPessoas.add(p);
        JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
    }

    public static void alterar() {
        if (listaPessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada!");
            return;
        }

        listar();
        int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da pessoa para alterar (1, 2, 3...):")) - 1;

        if (index >= 0 && index < listaPessoas.size()) {
            Pessoa p = listaPessoas.get(index);
            String novoNome = JOptionPane.showInputDialog("Nome atual: " + p.getNome() + "\nDigite o novo nome:");
            int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Idade atual: " + p.getIdade() + "\nDigite a nova idade:"));
            p.alterar(novoNome, novaIdade);
            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
        }
    }

    public static void excluir() {
        if (listaPessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada!");
            return;
        }

        listar();
        int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da pessoa para excluir:")) - 1;

        if (index >= 0 && index < listaPessoas.size()) {
            Pessoa p = listaPessoas.get(index);
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja excluir: " + p.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                listaPessoas.remove(index);
                JOptionPane.showMessageDialog(null, "Pessoa excluída com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
        }
    }

    public static void listar() {
        if (listaPessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada!");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista de Pessoas:\n");
        int i = 1;
        for (Pessoa p : listaPessoas) {
            sb.append(i++).append(" - ").append(p.exibir()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
