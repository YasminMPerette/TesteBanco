package org.example.Livro;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public void inserir(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());

            stmt.setString(2, livro.getAutor());

            stmt.setInt(3, livro.getAno());

            stmt.executeUpdate();

            System.out.println("Livro inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAutor(String titulo, String novoAutor) {

        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoAutor);

            stmt.setString(2, titulo);

            stmt.executeUpdate();

            System.out.println("Autor atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String titulo) {

        String sql = "DELETE FROM livros WHERE titulo = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);

            stmt.executeUpdate();

            System.out.println("Livro deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
