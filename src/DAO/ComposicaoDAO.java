package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Composicao;

public class ComposicaoDAO extends ConexaoDB {
	private static final String INSERT_COMPOSICAO_SQL = "INSERT INTO composicao (exame_id, composicao_exame_id, valor_referencia_composicao_exame_id) VALUES (?, ?, ?);";
	private static final String SELECT_COMPOSICAO_BY_ID = "SELECT id, exame_id, composicao_exame_id, valor_referencia_composicao_exame_id FROM composicao WHERE id = ?";
	private static final String SELECT_ALL_COMPOSICAO = "SELECT * FROM composicao;";
	private static final String DELETE_COMPOSICAO_SQL = "DELETE FROM composicao WHERE id = ?;";
	private static final String BUSCAR_POR_EXAME_ID_COMPOSICAO_SQL = "SELECT FROM composicao WHERE exame_id = ?;";
	private static final String UPDATE_COMPOSICAO_SQL = "UPDATE composicao SET exame_id = ?, composicao_exame_id = ?, valor_referencia_composicao_exame_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM composicao;";

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
	
	public Composicao insert(Composicao entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_COMPOSICAO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setInt(1, entidade.getExame_id());
			preparedStatement.setInt(2, entidade.getComposicao_exame_id());
			preparedStatement.setInt(3, entidade.getValor_referencia_composicao_exame_id());

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

	public Composicao findByExameId(String exameId) {
		Composicao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_EXAME_ID_COMPOSICAO_SQL)) {
			preparedStatement.setString(1, exameId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public Composicao findById(long id) {
		Composicao entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_COMPOSICAO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int exameId = rs.getInt("exame_id");
				int composicaoExameId = rs.getInt("composicao_exame_id");
				int valorReferenciaComposicaoExameId = rs.getInt("valor_referencia_composicao_exame_id");
				entidade = new Composicao(id, exameId, composicaoExameId, valorReferenciaComposicaoExameId);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Composicao> selectAllComposicaos() {
		List<Composicao> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_COMPOSICAO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				int exameId = rs.getInt("exame_id");
				int composicaoExameId = rs.getInt("composicao_exame_id");
				int valorReferenciaComposicaoExameId = rs.getInt("valor_referencia_composicao_exame_id");
				entidades.add(new Composicao(id, exameId, composicaoExameId, valorReferenciaComposicaoExameId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteComposicao(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_COMPOSICAO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateComposicao(Composicao entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_COMPOSICAO_SQL)) {
			statement.setInt(1, entidade.getExame_id());
			statement.setInt(1, entidade.getComposicao_exame_id());
			statement.setInt(2, entidade.getValor_referencia_composicao_exame_id());
			statement.setLong(3, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
