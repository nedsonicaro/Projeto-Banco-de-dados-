package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.LaudoDAO;
import model.Contato;
import model.Laudo;

public class ServicoLaudo {
	private LaudoDAO laudoDAO = new LaudoDAO();

	public Laudo salvar(Laudo entidade) {
		return laudoDAO.insert(entidade);
	}

	public Laudo buscarPorId(Integer id) {
		return laudoDAO.findById(id);
	}

	public void update(Laudo entidade) throws SQLException {
		laudoDAO.updateLaudo(entidade);
	}

	public List<Laudo> listarTodos() {
		return laudoDAO.selectAllLaudos();
	}

	public void remover(Integer id) throws SQLException {
		laudoDAO.deleteLaudo(id);
	}
}
