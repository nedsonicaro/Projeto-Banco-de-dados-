package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.LaboratorioDAO;
import model.Contato;
import model.Laboratorio;

public class ServicoLaboratorio {
private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
	
	public Laboratorio salvar(Laboratorio entidade) {
		return laboratorioDAO.insert(entidade);
	}

	public Laboratorio buscarPorId(Integer id) {
		return laboratorioDAO.findById(id);
	}

	public void update(Laboratorio laboratorio) throws SQLException {
		laboratorioDAO.updateLaboratorio(laboratorio);
	}

	public List<Laboratorio> listarTodos() {
		return laboratorioDAO.selectAllLaboratorios();
	}

	public void remover(Integer id) throws SQLException {
		laboratorioDAO.deleteLaboratorio(id);
	}
}
