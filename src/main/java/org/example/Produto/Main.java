package org.example.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        System.out.println("1. Inserir produto");

        System.out.println("2. Atualizar preço");

        System.out.println("3. Deletar produto");

        int opcao = sc.nextInt();

        sc.nextLine();

        switch (opcao) {
            case 1:

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Preço: ");
                double preco = sc.nextDouble();

                System.out.print("Quantidade: ");
                int qtd = sc.nextInt();

                Produto produto = new Produto(nome, preco, qtd);

                produtoDAO.inserir(produto);

                break;

            case 2:
                System.out.print("Nome do produto: ");
                String nomeProd = sc.nextLine();

                System.out.print("Novo preço: ");
                double novoPreco = sc.nextDouble();

                produtoDAO.atualizarPreco(nomeProd, novoPreco);

                break;

            case 3:
                System.out.print("Nome do produto: ");
                String nomeDel = sc.nextLine();

                produtoDAO.deletar(nomeDel);

                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
