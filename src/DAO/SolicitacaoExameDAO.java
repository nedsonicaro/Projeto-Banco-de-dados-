package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.SolicitacaoExame;

public class SolicitacaoExameDAO extends ConexaoDB {
	private static final String INSERT_SOLICITACAO_EXAME_SQL = "INSERT INTO SOLICITACAO_EXAME (NM_PRESCRITO, DT_SOLICITACAO, CONSULTA_MEDICA_ID, HABILITACAO_EXAME_ID, EXAME_ID) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_SOLICITACAO_EXAME_BY_ID = "SELECT id, NM_PRESCRITO, DT_SOLICITACAO, CONSULTA_MEDICA_ID, HABILITACAO_EXAME_ID, EXAME_ID FROM SOLICITACAO_EXAME WHERE id = ?";
	private static final String SELECT_ALL_SOLICITACAO_EXAME = "SELECT * FROM SOLICITACAO_EXAME;";
	private static final String DELETE_SOLICITACAO_EXAME_SQL = "DELETE FROM SOLICITACAO_EXAME WHERE id = ?;";
	private static final String UPDATE_SOLICITACAO_EXAME_SQL = "UPDATE SOLICITACAO_EXAME SET NM_PRESCRITO = ?, DT_SOLICITACAO = ?, CONSULTA_MEDICA_ID = ?, HABILITACAO_EXAME_ID = ?, EXAME_ID = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM SOLICITACAO_EXAME;";
    
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
    
    public SolicitacaoExame insert(SolicitacaoExame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_SOLICITACAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNm_prescrito());
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_solicitacao().getTime());
			preparedStatement.setDate(2, sqlDate) ;
			preparedStatement.setInt(3, entidade.getConsulta_medica_id());
			preparedStatement.setInt(4, entidade.getHabilitacao_exame_id());
			preparedStatement.setInt(5, entidade.getExame_id());
			
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
    
    
    public SolicitacaoExame findById(long id) {
		SolicitacaoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_SOLICITACAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nmPrescrito = rs.getString("nm_prescrito");
				Date  dtSolicitacao= rs.getDate("dt_solicitacao");
				int consultaMedicaId = rs.getInt("consulta_medica_id");
				int habilitacaoExameId = rs.getInt("habilitacao_exame_id");
				int exameId = rs.getInt("exame_id");
				
				entidade = new SolicitacaoExame(
						id,
						nmPrescrito,
						dtSolicitacao,
						consultaMedicaId,
						habilitacaoExameId,
						exameId);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<SolicitacaoExame> selectAllSolicitacaoExames() {
		List<SolicitacaoExame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SOLICITACAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nmPrescrito = rs.getString("nm_prescrito");
				Date  dtSolicitacao= rs.getDate("dt_solicitacao");
				int consultaMedicaId = rs.getInt("consulta_medica_id");
				int habilitacaoExameId = rs.getInt("habilitacao_exame_id");
				int exameId = rs.getInt("exame_id");
				
				entidades.add(new SolicitacaoExame(
						id,
						nmPrescrito,
						dtSolicitacao,
						consultaMedicaId,
						habilitacaoExameId,
						exameId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteSolicitacaoExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_SOLICITACAO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateSolicitacaoExame(SolicitacaoExame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_SOLICITACAO_EXAME_SQL)) {
			statement.setString(1, entidade.getNm_prescrito());
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_solicitacao().getTime());
			statement.setDate(2, sqlDate);
			statement.setInt(3, entidade.getConsulta_medica_id());
			statement.setInt(4, entidade.getHabilitacao_exame_id());
			statement.setInt(5, entidade.getExame_id());	
			statement.setLong(6, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
