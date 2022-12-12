package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ConsultaMedica;

public class ConsultaMedicaDAO extends ConexaoDB {
	private static final String INSERT_CONSULTA_MEDICA_SQL = "INSERT INTO CONSULTA_MEDICA (DT_CONSULTA, NM_ATENDIMENTO, PACIENTE_ID, MEDICO_ID) VALUES (?, ?, ?, ?);";
	private static final String SELECT_CONSULTA_MEDICA_BY_ID = "SELECT id, DT_CONSULTA, NM_ATENDIMENTO, PACIENTE_ID, MEDICO_ID FROM CONSULTA_MEDICA WHERE id = ?";
	private static final String SELECT_ALL_CONSULTA_MEDICA = "SELECT * FROM CONSULTA_MEDICA;";
	private static final String DELETE_CONSULTA_MEDICA_SQL = "DELETE FROM CONSULTA_MEDICA WHERE id = ?;";
	private static final String BUSCAR_POR_NOME_CONSULTA_MEDICA_SQL = "SELECT FROM CONSULTA_MEDICA WHERE NOME = ?;";
	private static final String UPDATE_CONSULTA_MEDICA_SQL = "UPDATE CONSULTA_MEDICA SET DT_CONSULTA = ?, NM_ATENDIMENTO = ?, PACIENTE_ID = ?, MEDICO_ID = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM CONSULTA_MEDICA;";
    
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
    
    public ConsultaMedica insert(ConsultaMedica entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_CONSULTA_MEDICA_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_consulta().getTime());
			preparedStatement.setDate(1, sqlDate) ;
			preparedStatement.setString(2, entidade.getNm_atendimento());
			preparedStatement.setInt(3, entidade.getPaciente_id());
			preparedStatement.setInt(4, entidade.getMedico_id());

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
    
    public ConsultaMedica findByNmAtendimento(String nmAtendimento) {
		ConsultaMedica entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL( BUSCAR_POR_NOME_CONSULTA_MEDICA_SQL)) {
			preparedStatement.setString(1, nmAtendimento);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				entidade = new ConsultaMedica(
						rs.getLong("id"),
						rs.getDate("dt_consulta"),
						rs.getString("nm_atendimento"),
						rs.getInt("paciente_id"),
						rs.getInt("medico_id"));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return entidade;
	}
    
    public ConsultaMedica findById(long id) {
		ConsultaMedica entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_CONSULTA_MEDICA_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Date dtConsulta = rs.getDate("dt_consulta");
				String nmAtendimento = rs.getString("nm_atendimento");
				int pacienteId = rs.getInt("paciente_id");
				int medicoId = rs.getInt("medico_id");
				entidade = new ConsultaMedica(id, dtConsulta, nmAtendimento, pacienteId, medicoId);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<ConsultaMedica> selectAllConsultaMedicas() {
		List<ConsultaMedica> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CONSULTA_MEDICA)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				Date dtConsulta = rs.getDate("dt_consulta");
				String nmAtendimento = rs.getString("nm_atendimento");
				int pacienteId = rs.getInt("paciente_id");
				int medicoId = rs.getInt("medico_id");
				entidades.add(new ConsultaMedica(id, dtConsulta, nmAtendimento, pacienteId, medicoId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteConsultaMedica(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_CONSULTA_MEDICA_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateConsultaMedica(ConsultaMedica entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_CONSULTA_MEDICA_SQL)) {
			java.sql.Date sqlDate = new java.sql.Date(entidade.getDt_consulta().getTime());
			statement.setDate(1, sqlDate) ;
			statement.setString(2, entidade.getNm_atendimento());
			statement.setInt(3, entidade.getPaciente_id());
			statement.setInt(4, entidade.getMedico_id());
			statement.setLong(5, entidade.getId());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}	
