package org.example.Pedido;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void inserir(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente, data_pedido, total) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pedido.getCliente());
            stmt.setDate(2, pedido.getDataPedido());
            stmt.setDouble(3, pedido.getTotal());
            stmt.executeUpdate();
            System.out.println("Pedido inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarTotal(int id, double novoTotal) {
        String sql = "UPDATE pedidos SET total = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoTotal);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Total do pedido atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pedido deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
