package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("1. Inserir usuário");
        System.out.println("2. Atualizar email");
        System.out.println("3. Deletar usuário");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                Usuario u = new Usuario(nome, email);
                usuarioDAO.inserir(u);
                break;
            case 2:
                System.out.print("Nome do usuário a atualizar: ");
                String nomeAtualiza = sc.nextLine();
                System.out.print("Novo email: ");
                String novoEmail = sc.nextLine();
                usuarioDAO.atualizarEmail(nomeAtualiza, novoEmail);
                break;
            case 3:
                System.out.print("Nome do usuário a deletar: ");
                String nomeDeleta = sc.nextLine();
                usuarioDAO.deletar(nomeDeleta);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
