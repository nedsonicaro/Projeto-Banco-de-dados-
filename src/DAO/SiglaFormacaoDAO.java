package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SiglaFormacao;

public class SiglaFormacaoDAO extends ConexaoDB {
	private static final String INSERT_SIGLA_FORMACAO_SQL = "INSERT INTO SIGLA_FORMACAO (SIGLA) VALUES (?);";
	private static final String SELECT_SIGLA_FORMACAO_BY_ID = "SELECT id, SIGLA FROM SIGLA_FORMACAO WHERE id = ?";
	private static final String SELECT_ALL_SIGLA_FORMACAO = "SELECT * FROM SIGLA_FORMACAO;";
	private static final String DELETE_SIGLA_FORMACAO_SQL = "DELETE FROM SIGLA_FORMACAO WHERE id = ?;";
	private static final String BUSCAR_POR_SIGLA_SIGLA_FORMACAO_SQL = "SELECT FROM SIGLA_FORMACAO WHERE SIGLA = ?;";
	private static final String UPDATE_SIGLA_FORMACAO_SQL = "UPDATE SIGLA_FORMACAO SET SIGLA = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM SIGLA_FORMACAO;";
	
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
	    
	    public SiglaFormacao insert(SiglaFormacao entidade) {
			try (PreparedStatement preparedStatement = prepararSQL(INSERT_SIGLA_FORMACAO_SQL,
					java.sql.Statement.RETURN_GENERATED_KEYS)) {

				preparedStatement.setString(1, entidade.getSigla());

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
	    
	    public SiglaFormacao findBySigla(String sigla) {
			SiglaFormacao entidade = null;
			try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_SIGLA_SIGLA_FORMACAO_SQL)) {
				preparedStatement.setString(1, sigla);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					entidade = new SiglaFormacao(rs.getLong("id"), rs.getString("sigla"));
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}

			return entidade;
		}
	    
	    public SiglaFormacao findById(long id) {
			SiglaFormacao entidade = null;
			try (PreparedStatement preparedStatement = prepararSQL(SELECT_SIGLA_FORMACAO_BY_ID)) {
				preparedStatement.setLong(1, id);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String sigla = rs.getString("sigla");
					entidade = new SiglaFormacao(id, sigla);
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			return entidade;
		}
	    
	    public List<SiglaFormacao> selectAllSiglaFormacaos() {
			List<SiglaFormacao> entidades = new ArrayList<>();
			try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_SIGLA_FORMACAO)) {
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					long id = rs.getLong("id");
					String sigla = rs.getString("sigla");
					entidades.add(new SiglaFormacao(id, sigla));
				}
			} catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			return entidades;
		}
	    
	    public boolean deleteSiglaFormacao(int id) throws SQLException {
			try (PreparedStatement statement = prepararSQL(DELETE_SIGLA_FORMACAO_SQL)) {
				statement.setInt(1, id);

				return statement.executeUpdate() > 0;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	    
	    public void updateSiglaFormacao(SiglaFormacao entidade) throws SQLException {
			try (PreparedStatement statement = prepararSQL(UPDATE_SIGLA_FORMACAO_SQL)) {
				statement.setString(1, entidade.getSigla());
				statement.setLong(2, entidade.getId());
				statement.executeUpdate();

			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
}
