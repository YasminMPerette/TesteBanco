package org.example.Pedido;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PedidoDAO pedidoDAO = new PedidoDAO();

        System.out.println("1. Inserir pedido");
        System.out.println("2. Atualizar total");
        System.out.println("3. Deletar pedido");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Cliente: ");
                String cliente = sc.nextLine();

                System.out.print("Data: ");
                String dataStr = sc.nextLine();
                Date data = Date.valueOf(dataStr);

                System.out.print("Total: ");
                double total = sc.nextDouble();

                Pedido pedido = new Pedido(cliente, data, total);
                pedidoDAO.inserir(pedido);
                break;

            case 2:
                System.out.print("ID do pedido: ");
                int idPedido = sc.nextInt();
                System.out.print("Novo total: ");
                double novoTotal = sc.nextDouble();
                pedidoDAO.atualizarTotal(idPedido, novoTotal);
                break;

            case 3:
                System.out.print("ID do pedido a deletar: ");
                int idDel = sc.nextInt();
                pedidoDAO.deletar(idDel);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }
}
