package org.example.Aluno;

import org.example.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, matricula, curso) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());

            stmt.setString(2, aluno.getMatricula());

            stmt.setString(3, aluno.getCurso());

            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCurso(String matricula, String novoCurso) {

        String sql = "UPDATE alunos SET curso = ? WHERE matricula = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoCurso);

            stmt.setString(2, matricula);

            stmt.executeUpdate();

            System.out.println("Curso atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(String matricula) {

        String sql = "DELETE FROM alunos WHERE matricula = ?";

        try (Connection conn = Conexao.conectar();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);

            stmt.executeUpdate();

            System.out.println("Aluno deletado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
