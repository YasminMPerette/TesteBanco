package org.example.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LivroDAO livroDAO = new LivroDAO();

        System.out.println("1. Inserir livro");

        System.out.println("2. Atualizar autor");

        System.out.println("3. Deletar livro");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Título: ");
                String titulo = sc.nextLine();

                System.out.print("Autor: ");
                String autor = sc.nextLine();

                System.out.print("Ano: ");
                int ano = sc.nextInt();

                Livro livro = new Livro(titulo, autor, ano);
                livroDAO.inserir(livro);

                break;

            case 2:
                System.out.print("Título do livro: ");
                String tituloAtualiza = sc.nextLine();

                System.out.print("Novo autor: ");
                String novoAutor = sc.nextLine();

                livroDAO.atualizarAutor(tituloAtualiza, novoAutor);

                break;

            case 3:

                System.out.print("Título do livro: ");

                String tituloDel = sc.nextLine();
                livroDAO.deletar(tituloDel);

                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
