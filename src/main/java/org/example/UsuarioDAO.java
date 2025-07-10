package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());

            stmt.setString(2, usuario.getEmail());

            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEmail(String nome, String novoEmail) {

        String sql = "UPDATE usuarios SET email = ? WHERE nome = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoEmail);

            stmt.setString(2, nome);

            stmt.executeUpdate();

            System.out.println("Email atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String nome) {

        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            stmt.executeUpdate();

            System.out.println("Usuário deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
