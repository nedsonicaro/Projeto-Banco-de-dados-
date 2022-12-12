package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.ExameDAO;
import model.Especialidade;
import model.Exame;

public class ServicoExame {
	private ExameDAO exameDAO = new ExameDAO();

	public Exame salvar(Exame entidade) {
		return exameDAO.insert(entidade);
	}

	public Exame buscarPorId(Integer id) {
		return exameDAO.findById(id);
	}

	public void update(Exame entidade) throws SQLException {
		exameDAO.updateExame(entidade);
	}

	public List<Exame> listarTodos() {
		return exameDAO.selectAllExames();
	}

	public void remover(Integer id) throws SQLException {
		exameDAO.deleteExame(id);
	}
}
