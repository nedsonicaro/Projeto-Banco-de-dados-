package DAO;

import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDAO extends ConexaoDB {
	private static final String INSERT_PACIENTE_SQL = "INSERT INTO PACIENTE (NOME, DT_NASCIMENTO) VALUES (?, ?);";
	private static final String SELECT_PACIENTE_BY_ID = "SELECT id, NOME, dt_nascimento FROM PACIENTE WHERE id = ?";
	private static final String SELECT_ALL_PACIENTE = "SELECT * FROM PACIENTE;";
	private static final String DELETE_PACIENTE_SQL = "DELETE FROM PACIENTE WHERE id = ?;";
	private static final String BUSCAR_POR_NOME_PACIENTE_SQL = "SELECT FROM PACIENTE WHERE NOME = ?;";
	private static final String UPDATE_PACIENTE_SQL = "UPDATE PACIENTE SET NOME = ?, dt_nascimento = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM PACIENTE;";
    
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
    
    public Paciente insert(Paciente entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_PACIENTE_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getNome());
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_nascimento().getTime());
			preparedStatement.setDate(2, sqlDate) ;

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
    
    public Paciente findByNome(String nome) {
		Paciente entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_NOME_PACIENTE_SQL)) {
			preparedStatement.setString(1, nome);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new Paciente(rs.getLong("id"), rs.getString("nome"), rs.getDate("dt_nascimento"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}
    
    public Paciente findById(long id) {
		Paciente entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_PACIENTE_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				Date dt_nascimento = rs.getDate("dt_nascimento");
				entidade = new Paciente(id, nome, dt_nascimento);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<Paciente> selectAllPacientes() {
		List<Paciente> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_PACIENTE)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				Date dt_nascimento = rs.getDate("dt_nascimento");
				entidades.add(new Paciente(id, nome, dt_nascimento));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deletePaciente(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_PACIENTE_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updatePaciente(Paciente entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_PACIENTE_SQL)) {
			statement.setString(1, entidade.getNome());
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_nascimento().getTime());
			statement.setDate(2, sqlDate) ;
			statement.setLong(3, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
