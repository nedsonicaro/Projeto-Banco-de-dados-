package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UnidadeMedida;

public class UnidadeMedidaDAO extends ConexaoDB {
	
	private static final String INSERT_UNIDADE_MEDIDA_SQL = "INSERT INTO UNIDADE_MEDIDA (DESCRICAO) VALUES (?);";
	private static final String SELECT_UNIDADE_MEDIDA_BY_ID = "SELECT id, DESCRICAO FROM UNIDADE_MEDIDA WHERE id = ?";
	private static final String SELECT_ALL_UNIDADE_MEDIDA = "SELECT * FROM UNIDADE_MEDIDA;";
	private static final String DELETE_UNIDADE_MEDIDA_SQL = "DELETE FROM UNIDADE_MEDIDA WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_UNIDADE_MEDIDA_SQL = "SELECT FROM UNIDADE_MEDIDA WHERE DESCRICAO = ?;";
	private static final String UPDATE_UNIDADE_MEDIDA_SQL = "UPDATE UNIDADE_MEDIDA SET DESCRICAO = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM UNIDADE_MEDIDA;";
	
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
	    
	    public UnidadeMedida insert(UnidadeMedida entidade) {
			try (PreparedStatement preparedStatement = prepararSQL(INSERT_UNIDADE_MEDIDA_SQL,
					java.sql.Statement.RETURN_GENERATED_KEYS)) {

				preparedStatement.setString(1, entidade.getDescricao());

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
	    
	    public UnidadeMedida findByDescricao(String descricao) {
			UnidadeMedida entidade = null;
			try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_DESCRICAO_UNIDADE_MEDIDA_SQL)) {
				preparedStatement.setString(1, descricao);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					entidade = new UnidadeMedida(rs.getLong("id"), rs.getString("descricao"));
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

			return entidade;
		}
	    
	    public UnidadeMedida findById(long id) {
			UnidadeMedida entidade = null;
			try (PreparedStatement preparedStatement = prepararSQL(SELECT_UNIDADE_MEDIDA_BY_ID)) {
				preparedStatement.setLong(1, id);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String descricao = rs.getString("descricao");
					entidade = new UnidadeMedida(id, descricao);
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			return entidade;
		}
	    
	    public List<UnidadeMedida> selectAllUnidadeMedidas() {
			List<UnidadeMedida> entidades = new ArrayList<>();
			try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_UNIDADE_MEDIDA)) {
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					long id = rs.getLong("id");
					String descricao = rs.getString("descricao");
					entidades.add(new UnidadeMedida(id, descricao));
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			return entidades;
		}
	    
	    public boolean deleteUnidadeMedida(int id) throws SQLException {
			try (PreparedStatement statement = prepararSQL(DELETE_UNIDADE_MEDIDA_SQL)) {
				statement.setInt(1, id);

				return statement.executeUpdate() > 0;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	    
	    public void updateUnidadeMedida(UnidadeMedida entidade) throws SQLException {
			try (PreparedStatement statement = prepararSQL(UPDATE_UNIDADE_MEDIDA_SQL)) {
				statement.setString(1, entidade.getDescricao());
				statement.setLong(2, entidade.getId());
				statement.executeUpdate();

			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

}
