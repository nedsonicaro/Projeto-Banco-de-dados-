package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ResultadoExame;

public class ResultadoExameDAO extends ConexaoDB {
	private static final String INSERT_RESULTADO_EXAME_SQL = "INSERT INTO RESULTADO_EXAME (DT_EXAME, VALOR, COMPOSICAO_ID, LAUDO_ID) VALUES (?, ?, ?, ?);";
	private static final String SELECT_RESULTADO_EXAME_BY_ID = "SELECT id, DT_EXAME, VALOR, COMPOSICAO_ID, LAUDO_ID FROM RESULTADO_EXAME WHERE id = ?";
	private static final String SELECT_ALL_RESULTADO_EXAME = "SELECT * FROM RESULTADO_EXAME;";
	private static final String DELETE_RESULTADO_EXAME_SQL = "DELETE FROM RESULTADO_EXAME WHERE id = ?;";
	private static final String BUSCAR_POR_LAUDO_ID_RESULTADO_EXAME_SQL = "SELECT FROM RESULTADO_EXAME WHERE LAUDO_ID = ?;";
	private static final String UPDATE_RESULTADO_EXAME_SQL = "UPDATE RESULTADO_EXAME SET DT_EXAME = ?, VALOR = ?, COMPOSICAO_ID = ?, LAUDO_ID = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM RESULTADO_EXAME;";
    
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
    
    public ResultadoExame insert(ResultadoExame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESULTADO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_exame().getTime());
			preparedStatement.setDate(1, sqlDate) ;
			preparedStatement.setString(2, entidade.getValor());
			preparedStatement.setInt(3, entidade.getComposicao_id());
			preparedStatement.setInt(4, entidade.getLaudo_id());

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
    
    public ResultadoExame findByLaudoId(String laudoId) {
		ResultadoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_LAUDO_ID_RESULTADO_EXAME_SQL)) {
			preparedStatement.setString(1, laudoId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new ResultadoExame(
						rs.getLong("id"),
						rs.getDate("dt_exame"),
						rs.getString("valor "),
						rs.getInt("composicao_id"),
						rs.getInt("laudo_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}
    
    public ResultadoExame findById(long id) {
		ResultadoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESULTADO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Date dtExame = rs.getDate("dt_exame");
				String valor = rs.getString("valor");
				int composicaoId = rs.getInt("composicao_id");
				int laudoId = rs.getInt("laudo_id");
				entidade = new ResultadoExame(id, dtExame, valor, composicaoId, laudoId);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<ResultadoExame> selectAllResultadoExames() {
		List<ResultadoExame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESULTADO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				Date dtExame = rs.getDate("dt_exame");
				String valor = rs.getString("valor");
				int composicaoId = rs.getInt("composicao_id");
				int laudoId = rs.getInt("laudo_id");
				entidades.add(new ResultadoExame(id, dtExame, valor, composicaoId, laudoId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteResultadoExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_RESULTADO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateResultadoExame(ResultadoExame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_RESULTADO_EXAME_SQL)) {
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_exame().getTime());
			statement.setDate(1, sqlDate) ;
			statement.setString(2, entidade.getValor());
			statement.setInt(3, entidade.getComposicao_id());
			statement.setInt(4, entidade.getLaudo_id());
			statement.setLong(5, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
