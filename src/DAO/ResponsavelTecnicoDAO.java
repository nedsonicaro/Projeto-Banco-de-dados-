package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ResponsavelTecnico;

public class ResponsavelTecnicoDAO extends ConexaoDB {
	private static final String INSERT_RESPONSAVEL_TECNICO_SQL = "INSERT INTO RESPONSAVEL_TECNICO (NOME, CONSELHO, FORMACAO, SIGLA_FORMACAO_ID) VALUES (?, ?, ?, ?);";
	private static final String SELECT_RESPONSAVEL_TECNICO_BY_ID = "SELECT id, NOME, conselho FROM RESPONSAVEL_TECNICO WHERE id = ?";
	private static final String SELECT_ALL_RESPONSAVEL_TECNICO = "SELECT * FROM RESPONSAVEL_TECNICO;";
	private static final String DELETE_RESPONSAVEL_TECNICO_SQL = "DELETE FROM RESPONSAVEL_TECNICO WHERE id = ?;";
	private static final String BUSCAR_POR_NOME_RESPONSAVEL_TECNICO_SQL = "SELECT FROM RESPONSAVEL_TECNICO WHERE NOME = ?;";
	private static final String UPDATE_RESPONSAVEL_TECNICO_SQL = "UPDATE RESPONSAVEL_TECNICO SET NOME = ?, conselho = ?, formacao = ?, sigla_formacao_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM RESPONSAVEL_TECNICO;";
    
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
    
    public ResponsavelTecnico insert(ResponsavelTecnico entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNome());
			preparedStatement.setString(2, entidade.getConselho());
			preparedStatement.setString(3, entidade.getFormacao());
			preparedStatement.setInt(4, entidade.getSigla_formacao_id());
			
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
    
    public ResponsavelTecnico findByNome(String nome) {
		ResponsavelTecnico entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_NOME_RESPONSAVEL_TECNICO_SQL)) {
			preparedStatement.setString(1, nome);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new ResponsavelTecnico(
						rs.getLong("id"), 
						rs.getString("nome"),
						rs.getString("conselho"),
						rs.getString("formacao"),
						rs.getInt("sigla_formacao_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
    }
	
    
    public ResponsavelTecnico findById(long id) {
		ResponsavelTecnico entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String conselho = rs.getString("conselho");
				String formacao = rs.getString("formacao");
				int sigla_formacao_id = rs.getInt("sigla_formacao_id");
				
				entidade = new ResponsavelTecnico(id, nome, conselho, formacao, sigla_formacao_id);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<ResponsavelTecnico> selectAllResponsavelTecnicos() {
		List<ResponsavelTecnico> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String conselho = rs.getString("conselho");
				String formacao = rs.getString("formacao");
				int sigla_formacao_id = rs.getInt("sigla_formacao_id");
				
				entidades.add(new ResponsavelTecnico(id, nome, conselho, formacao, sigla_formacao_id));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteResponsavelTecnico(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateResponsavelTecnico(ResponsavelTecnico entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_SQL)) {
			statement.setString(1, entidade.getNome());
			statement.setString(2, entidade.getConselho());
			statement.setString(3, entidade.getFormacao());
			statement.setInt(4, entidade.getSigla_formacao_id());
			statement.setLong(5, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
