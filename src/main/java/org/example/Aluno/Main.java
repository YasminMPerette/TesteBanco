package org.example.Aluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("1. Inserir aluno");
        System.out.println("2. Atualizar curso");
        System.out.println("3. Deletar aluno");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                Aluno aluno = new Aluno(nome, matricula, curso);
                alunoDAO.inserir(aluno);
                break;
            case 2:
                System.out.print("Matrícula do aluno: ");
                String mat = sc.nextLine();
                System.out.print("Novo curso: ");
                String novoCurso = sc.nextLine();
                alunoDAO.atualizarCurso(mat, novoCurso);
                break;
            case 3:
                System.out.print("Matrícula do aluno: ");
                String matriculaDelete = sc.nextLine();
                alunoDAO.deletar(matriculaDelete);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
