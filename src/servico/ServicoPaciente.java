package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.PacienteDAO;
import model.Contato;
import model.Paciente;

public class ServicoPaciente {
	private PacienteDAO pacienteDAO = new PacienteDAO();
	
	public Paciente salvar(Paciente entidade) {
		return pacienteDAO.insert(entidade);
	}

	public Paciente buscarPorId(Integer id) {
		return pacienteDAO.findById(id);
	}

	public void update(Paciente paciente) throws SQLException {
		pacienteDAO.updatePaciente(paciente);
	}

	public List<Paciente> listarTodos() {
		return pacienteDAO.selectAllPacientes();
	}

	public void remover(Integer id) throws SQLException {
		pacienteDAO.deletePaciente(id);
	}
}
