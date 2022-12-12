package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.HabilitacaoExameDAO;
import model.Contato;
import model.HabilitacaoExame;

public class ServicoHabilitacaoExame {
	private HabilitacaoExameDAO habilitacaoExameDAO = new HabilitacaoExameDAO();

	public HabilitacaoExame salvar(HabilitacaoExame entidade) {
		return habilitacaoExameDAO.insert(entidade);
	}

	public HabilitacaoExame buscarPorId(Integer id) {
		return habilitacaoExameDAO.findById(id);
	}

	public void update(HabilitacaoExame entidade) throws SQLException {
		habilitacaoExameDAO.updateHabilitacaoExame(entidade);
	}

	public List<HabilitacaoExame> listarTodos() {
		return habilitacaoExameDAO.selectAllHabilitacaoExames();
	}

	public void remover(Integer id) throws SQLException {
		habilitacaoExameDAO.deleteHabilitacaoExame(id);
	}
}
