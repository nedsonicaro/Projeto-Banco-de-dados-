package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ComposicaoExame;

public class ComposicaoExameDAO extends ConexaoDB {
	private static final String INSERT_COMPOSICAO_EXAME_SQL = "INSERT INTO composicao_exame (descricao, unidade_medida_id) VALUES (?, ?);";
	private static final String SELECT_COMPOSICAO_EXAME_BY_ID = "SELECT id, descricao, unidade_medida_id FROM composicao_exame WHERE id = ?";
	private static final String SELECT_ALL_COMPOSICAO_EXAME = "SELECT * FROM composicao_exame;";
	private static final String DELETE_COMPOSICAO_EXAME_SQL = "DELETE FROM composicao_exame WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_COMPOSICAO_EXAME_SQL = "SELECT FROM composicao_exame WHERE descricao = ?;";
	private static final String UPDATE_COMPOSICAO_EXAME_SQL = "UPDATE composicao_exame SET descricao = ?, unidade_medida_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM composicao_exame;";

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
	
	public ComposicaoExame insert(ComposicaoExame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_COMPOSICAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getDescricao());
			preparedStatement.setInt(2, entidade.getUnidade_medida_id());

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

	public ComposicaoExame findByDecricao(String descricao) {
		ComposicaoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_DESCRICAO_COMPOSICAO_EXAME_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new ComposicaoExame(rs.getLong("id"), rs.getString("descricao"), rs.getInt("unidade_medida_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}

	public ComposicaoExame findById(long id) {
		ComposicaoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_COMPOSICAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String descricao = rs.getString("descricao");
				int unidade_medida_id = rs.getInt("unidade_medida_id");
				entidade = new ComposicaoExame(id, descricao, unidade_medida_id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<ComposicaoExame> selectAllComposicaoExames() {
		List<ComposicaoExame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_COMPOSICAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String descricao = rs.getString("descricao");
				int unidade_medida_id = rs.getInt("unidade_medida_id");
				entidades.add(new ComposicaoExame(id, descricao, unidade_medida_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteComposicaoExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_COMPOSICAO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateComposicaoExame(ComposicaoExame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_COMPOSICAO_EXAME_SQL)) {
			statement.setString(1, entidade.getDescricao());
			statement.setInt(2, entidade.getUnidade_medida_id());
			statement.setLong(3, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
