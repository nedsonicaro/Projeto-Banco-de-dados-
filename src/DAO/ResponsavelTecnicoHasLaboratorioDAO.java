package DAO;

import model.ResponsavelTecnicoHasLaboratorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoHasLaboratorioDAO extends ConexaoDB {
    private static final String INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (responsavel_tecnico_id, laboratorio_id) VALUES (?, ?);";
    private static final String SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID = "SELECT id, responsavel_tecnico_id, laboratorio_id FROM responsavel_tecnico_has_laboratorio WHERE id = ?";
    private static final String SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO = "SELECT * FROM responsavel_tecnico_has_laboratorio;";
    private static final String DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE id = ?;";
    private static final String UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "UPDATE responsavel_tecnico_has_laboratorio SET responsavel_tecnico_id = ?, laboratorio_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico_has_laboratorio;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public ResponsavelTecnicoHasLaboratorio insert(ResponsavelTecnicoHasLaboratorio entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entidade.getResponsavel_tecnico_id());
            preparedStatement.setInt(2, entidade.getLaboratorio_id());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                entidade.setId(result.getLong(1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return entidade;
    }

    public ResponsavelTecnicoHasLaboratorio findById(long id) {
        ResponsavelTecnicoHasLaboratorio entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
                int laboratorioId = rs.getInt("laboratorio_id");
                entidade = new ResponsavelTecnicoHasLaboratorio(id, responsavel_tecnico_id, laboratorioId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResponsavelTecnicoHasLaboratorio> selectAllResponsavelTecnicoHasLaboratorios() {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
                int laboratorioId = rs.getInt("laboratorio_id");
                entidades.add(new ResponsavelTecnicoHasLaboratorio(id, responsavel_tecnico_id, laboratorioId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResponsavelTecnicoHasLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setInt(1, entidade.getResponsavel_tecnico_id());
            statement.setInt(2, entidade.getLaboratorio_id());
            statement.setLong(3, entidade.getId());
            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
