package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Laudo;

public class LaudoDAO extends ConexaoDB {
	private static final String INSERT_LAUDO_SQL = "INSERT INTO laudo (assinatura_digital, dt_resultado, codigo, solicitacao_exame_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_LAUDO_BY_ID = "SELECT id, assinatura_digital, dt_resultado, codigo, solicitacao_exame_id  FROM laudo WHERE id = ?";
	private static final String SELECT_ALL_LAUDO = "SELECT * FROM laudo;";
	private static final String DELETE_LAUDO_SQL = "DELETE FROM laudo WHERE id = ?;";
	private static final String BUSCAR_POR_CODIGO_LAUDO_SQL = "SELECT FROM laudo WHERE codigo = ?;";
	private static final String UPDATE_LAUDO_SQL = "UPDATE laudo SET assinatura_digital = ?, dt_resultado = ?, codigo = ?, solicitacao_exame_id = ?  WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM laudo;";

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
	
	public Laudo insert(Laudo entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_LAUDO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getAssinaturaDigital());
			preparedStatement.setString(2, entidade.getDt_resultado());
			preparedStatement.setString(3, entidade.getCodigo());
			preparedStatement.setInt(4, entidade.getSolicitacao_exame_id());

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

	public Laudo findByCodigo(String codigo) {
		Laudo entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(BUSCAR_POR_CODIGO_LAUDO_SQL)) {
			preparedStatement.setString(1, codigo);
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

	public Laudo findById(long id) {
		Laudo entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_LAUDO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String assinaturaDigital = rs.getString("assinatura_digital");
				String dtResultado = rs.getString("dt_resultado");
				String codigo = rs.getString("codigo");
				int solicitacaoExameId = rs.getInt("solicitacao_exame_id");
				
				entidade = new Laudo(id, assinaturaDigital, dtResultado, codigo, solicitacaoExameId);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}

	public List<Laudo> selectAllLaudos() {
		List<Laudo> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_LAUDO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String assinaturaDigital = rs.getString("assinatura_digital");
				String dtResultado = rs.getString("dt_resultado");
				String codigo = rs.getString("codigo");
				int solicitacaoExameId = rs.getInt("solicitacao_exame_id");
				
				entidades.add(new Laudo(id, assinaturaDigital, dtResultado, codigo, solicitacaoExameId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}

	public boolean deleteLaudo(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_LAUDO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateLaudo(Laudo entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_LAUDO_SQL)) {
			statement.setString(1, entidade.getAssinaturaDigital());
			statement.setString(2, entidade.getDt_resultado());
			statement.setString(3, entidade.getCodigo());
			statement.setInt(4, entidade.getSolicitacao_exame_id());
			statement.setLong(5, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
