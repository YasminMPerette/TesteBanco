package org.example.Produto;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPreco(String nome, double novoPreco) {
        String sql = "UPDATE produtos SET preco = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoPreco);
            stmt.setString(2, nome);
            stmt.executeUpdate();
            System.out.println("Preço atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String nome) {
        String sql = "DELETE FROM produtos WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
