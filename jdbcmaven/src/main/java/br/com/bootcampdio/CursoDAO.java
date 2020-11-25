package br.com.bootcampdio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> listCurso() {

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM curso";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracao = rs.getInt("duracao");

                cursos.add(new Curso(id, nome, duracao));
            }

        } catch (Exception e) {
            System.out.println("Listagem falhou!");
        }
        return cursos;
    }

    public Curso getByIdCurso(int id) {

        Curso curso = new Curso();

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setduracao(rs.getInt("duracao"));

            }

        } catch (Exception e) {
            System.out.println("Listagem falhou!");
        }
        return curso;
    }

    public void AdicionaCurso(Curso curso) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO curso(nome, duracao_horas) values (?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getduracao());

            int rows = stmt.executeUpdate();
            System.out.println("Inserido com sucesso " + rows + " linha(s) ao banco de dados!");

        } catch (SQLException e) {
            System.out.println("Falha ao inserir no banco de dados!");
        }
    }

    public void DeletaCurso(int id) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println("Infomação apagada com sucesso, " + rows + " linha(s) afetadas!");

        } catch (Exception e) {
            System.out.println("Não foi possível apagar informação!");
        }

    }

    public void AtualizaCurso(Curso curso) {

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ? ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setInt(3, curso.getduracao());

            int rows = stmt.executeUpdate();
            System.out.println("Atualização realizada com sucesso, " + rows + " linha(s) afetada(s)!");

        } catch (Exception e) {
            System.out.println("Não foi possível atualizar as informações!");
        }

    }
}
