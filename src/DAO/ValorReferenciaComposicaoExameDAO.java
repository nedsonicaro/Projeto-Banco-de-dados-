package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ValorReferenciaComposicaoExame;

public class ValorReferenciaComposicaoExameDAO extends ConexaoDB {
	private static final String INSERT_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "INSERT INTO VALOR_REFERENCIA_COMPOSICAO_EXAME (VALOR_MINIMO, VALOR_MAXIMO, LIMITADOR_MINIMO, LIMITADOR_MAXIMO, UNIDADE_MEDIDA) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID = "SELECT id, VALOR_MINIMO, VALOR_MAXIMO, LIMITADOR_MINIMO, LIMITADOR_MAXIMO, UNIDADE_MEDIDA FROM VALOR_REFERENCIA_COMPOSICAO_EXAME WHERE id = ?";
	private static final String SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME = "SELECT * FROM VALOR_REFERENCIA_COMPOSICAO_EXAME;";
	private static final String DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "DELETE FROM VALOR_REFERENCIA_COMPOSICAO_EXAME WHERE id = ?;";
	private static final String UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL = "UPDATE VALOR_REFERENCIA_COMPOSICAO_EXAME SET VALOR_MINIMO = ?, VALOR_MAXIMO = ?, LIMITADOR_MINIMO = ?, LIMITADOR_MAXIMO = ?, UNIDADE_MEDIDA = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM VALOR_REFERENCIA_COMPOSICAO_EXAME;";
    
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
    
    public ValorReferenciaComposicaoExame insert(ValorReferenciaComposicaoExame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getValor_minimo());
			preparedStatement.setString(2, entidade.getValor_maximo());
			preparedStatement.setString(3, entidade.getLimitador_minimo());
			preparedStatement.setString(4, entidade.getLimitador_maximo());
			preparedStatement.setInt(5, entidade.getUnidade_medida_id());
			
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
    
    
    public ValorReferenciaComposicaoExame findById(long id) {
		ValorReferenciaComposicaoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_VALOR_REFERENCIA_COMPOSICAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String valorMinimo = rs.getString("valor_minimo");
				String valorMaximo = rs.getString("valor_maximo");
				String limitadorMinimo = rs.getString("limitador_minimo");
				String limitadorMaximo = rs.getString("limitador_maximo");
				int unidadeMedida = rs.getInt("unidade_medida_id");
				
				entidade = new ValorReferenciaComposicaoExame(
						id,
						valorMinimo,
						valorMaximo,
						limitadorMinimo,
						limitadorMaximo,
						unidadeMedida);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<ValorReferenciaComposicaoExame> selectAllValorReferenciaComposicaoExames() {
		List<ValorReferenciaComposicaoExame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_VALOR_REFERENCIA_COMPOSICAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String valorMinimo = rs.getString("valor_minimo");
				String valorMaximo = rs.getString("valor_maximo");
				String limitadorMinimo = rs.getString("limitador_minimo");
				String limitadorMaximo = rs.getString("limitador_maximo");
				int unidadeMedida = rs.getInt("unidade_medida_id");
				
				entidades.add(new ValorReferenciaComposicaoExame(
						id,
						valorMinimo,
						valorMaximo,
						limitadorMinimo,
						limitadorMaximo,
						unidadeMedida));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteValorReferenciaComposicaoExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateValorReferenciaComposicaoExame(ValorReferenciaComposicaoExame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_VALOR_REFERENCIA_COMPOSICAO_EXAME_SQL)) {
			statement.setString(1, entidade.getValor_minimo());
			statement.setString(2, entidade.getValor_maximo());
			statement.setString(3, entidade.getLimitador_minimo());
			statement.setString(4, entidade.getLimitador_maximo());
			statement.setInt(5, entidade.getUnidade_medida_id());
			statement.setLong(6, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
