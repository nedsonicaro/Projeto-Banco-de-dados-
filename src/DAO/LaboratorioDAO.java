package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Laboratorio;

public class LaboratorioDAO extends ConexaoDB {
	private static final String INSERT_LABORATORIO_SQL = "INSERT INTO LABORATORIO (DESCRICAO, CNES, CNPJ, CRBM, NOME_FANTASIA) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_LABORATORIO_BY_ID = "SELECT id, DESCRICAO, CNES, CNPJ, CRBM, DESCRICAO_FANTASIA FROM LABORATORIO WHERE id = ?";
	private static final String SELECT_ALL_LABORATORIO = "SELECT * FROM LABORATORIO;";
	private static final String DELETE_LABORATORIO_SQL = "DELETE FROM LABORATORIO WHERE id = ?;";
	private static final String BUSCAR_POR_DESCRICAO_LABORATORIO_SQL = "SELECT FROM LABORATORIO WHERE DESCRICAO = ?;";
	private static final String UPDATE_LABORATORIO_SQL = "UPDATE LABORATORIO SET DESCRICAO = ?, CNES = ?, CPNJ = ?, CRBM = ?, NOME_FANTASIA = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM LABORATORIO;";
    
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
    
    public Laboratorio insert(Laboratorio entidade) {
  		try (PreparedStatement preparedStatement = prepararSQL(INSERT_LABORATORIO_SQL,
  				java.sql.Statement.RETURN_GENERATED_KEYS)) {

  			preparedStatement.setString(1, entidade.getDescricao());
  			preparedStatement.setString(2, entidade.getCnes());
  			preparedStatement.setString(3, entidade.getCnpj());
  			preparedStatement.setString(4, entidade.getCrbm());
  			preparedStatement.setString(5, entidade.getNomeFantasia());
  			
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
      
	  public Laboratorio findByDescricao(String descricao) {
		Laboratorio entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_DESCRICAO_LABORATORIO_SQL)) {
			preparedStatement.setString(1, descricao);
			ResultSet rs = preparedStatement.executeQuery();
	
			while (rs.next()) {
				entidade = new Laboratorio(rs.getLong("id"), rs.getString("descricao"), rs.getString("cnes"), rs.getString("cnpj"),
					rs.getString("crbm"), rs.getString("nome_fantasia"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	
		return entidade;
	}
      
      public Laboratorio findById(long id) {
  		Laboratorio entidade = null;
  		try (PreparedStatement preparedStatement = prepararSQL(SELECT_LABORATORIO_BY_ID)) {
  			preparedStatement.setLong(1, id);
  			ResultSet rs = preparedStatement.executeQuery();

  			while (rs.next()) {
  				String descricao = rs.getString("descricao");
  				String cnes = rs.getString("cnes");
  				String cnpj = rs.getString("cnpj");
  				String crbm = rs.getString("crbm");
  				String nomeFantasia = rs.getString("nome_fantasia");
  				entidade = new Laboratorio(id, descricao, cnes, cnpj, crbm, nomeFantasia);
  			}
  		} catch (SQLException e) {
  			printSQLException(e);
  		} catch (ClassNotFoundException e) {
  			throw new RuntimeException(e);
  		}
  		return entidade;
  	}
      
      public List<Laboratorio> selectAllLaboratorios() {
  		List<Laboratorio> entidades = new ArrayList<>();
  		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_LABORATORIO)) {
  			ResultSet rs = preparedStatement.executeQuery();

  			while (rs.next()) {
  				long id = rs.getLong("id");
  				String descricao = rs.getString("descricao");
  				String cnes = rs.getString("cnes");
  				String cnpj = rs.getString("cnpj");
  				String crbm = rs.getString("crbm");
  				String nomeFantasia = rs.getString("nome_fantasia");
  				entidades.add(new Laboratorio(id, descricao, cnes, cnpj, crbm, nomeFantasia));
  			}
  		} catch (SQLException e) {
  			printSQLException(e);
  		} catch (ClassNotFoundException e) {
  			throw new RuntimeException(e);
  		}
  		return entidades;
  	}
      
      public boolean deleteLaboratorio(int id) throws SQLException {
  		try (PreparedStatement statement = prepararSQL(DELETE_LABORATORIO_SQL)) {
  			statement.setInt(1, id);

  			return statement.executeUpdate() > 0;
  		} catch (ClassNotFoundException e) {
  			throw new RuntimeException(e);
  		}
  	}
      
      public void updateLaboratorio(Laboratorio entidade) throws SQLException {
  		try (PreparedStatement statement = prepararSQL(UPDATE_LABORATORIO_SQL)) {
  			statement.setString(1, entidade.getDescricao());
  			statement.setString(2, entidade.getCnes());
  			statement.setString(3, entidade.getCnpj());
  			statement.setString(4, entidade.getCrbm());
  			statement.setLong(5, entidade.getId());
  			statement.executeUpdate();

  		} catch (ClassNotFoundException e) {
  			throw new RuntimeException(e);
  		}
  	}
}
