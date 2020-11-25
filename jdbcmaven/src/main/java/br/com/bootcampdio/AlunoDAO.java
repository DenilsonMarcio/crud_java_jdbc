package br.com.bootcampdio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> list() {

        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM aluno";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id, nome, idade, estado));
            }

        } catch (Exception e) {
            System.out.println("Listagem falhou!");
        }
        return alunos;
    }

    public Aluno getById(int id) {

        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));

            }

        } catch (Exception e) {
            System.out.println("Listagem falhou!");
        }
        return aluno;
    }

    public void Adiciona(Aluno aluno) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO aluno(nome, idade, estado) values (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());

            int rows = stmt.executeUpdate();
            System.out.println("Inserido com sucesso " + rows + " linha(s) ao banco de dados!");

        } catch (SQLException e) {
            System.out.println("Falha ao inserir no banco de dados!");
        }
    }

    public void Deleta(int id) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println("Infomação apagada com sucesso, " + rows + " linha(s) afetadas!");

        } catch (Exception e) {
            System.out.println("Não foi possível apagar informação!");
        }

    }

    public void Atualiza(Aluno aluno) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ? ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, aluno.getEstado());

            int rows = stmt.executeUpdate();
            System.out.println("Atualização realizada com sucesso, " + rows + " linha(s) afetada(s)!");

        } catch (Exception e) {
            System.out.println("Não foi possível atualizar as informações!");
        }

    }
}
