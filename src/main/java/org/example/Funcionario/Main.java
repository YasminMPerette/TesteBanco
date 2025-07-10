package org.example.Funcionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        System.out.println("1. Inserir funcionário");

        System.out.println("2. Atualizar salário");

        System.out.println("3. Deletar funcionário");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Cargo: ");
                String cargo = sc.nextLine();

                System.out.print("Salário: ");
                double salario = sc.nextDouble();

                Funcionario fun = new Funcionario(nome, cargo, salario);
                funcionarioDAO.inserir(fun);

                break;

            case 2:
                System.out.print("Nome do funcionário: ");
                String nomeFunc = sc.nextLine();

                System.out.print("Novo salário: ");
                double novoSalario = sc.nextDouble();

                funcionarioDAO.atualizarSalario(nomeFunc, novoSalario);

                break;

            case 3:
                System.out.print("Nome do funcionário: ");

                String nomeDel = sc.nextLine();

                funcionarioDAO.deletar(nomeDel);

                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
