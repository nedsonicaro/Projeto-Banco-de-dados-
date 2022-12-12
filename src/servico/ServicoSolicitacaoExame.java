package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.SolicitacaoExameDAO;
import model.Contato;
import model.SolicitacaoExame;

public class ServicoSolicitacaoExame {
	private SolicitacaoExameDAO solicitacaoExameDAO = new SolicitacaoExameDAO();

	public SolicitacaoExame salvar(SolicitacaoExame entidade) {
		return solicitacaoExameDAO.insert(entidade);
	}

	public SolicitacaoExame buscarPorId(Integer id) {
		return solicitacaoExameDAO.findById(id);
	}

	public void update(SolicitacaoExame entidade) throws SQLException {
		solicitacaoExameDAO.updateSolicitacaoExame(entidade);
	}

	public List<SolicitacaoExame> listarTodos() {
		return solicitacaoExameDAO.selectAllSolicitacaoExames();
	}

	public void remover(Integer id) throws SQLException {
		solicitacaoExameDAO.deleteSolicitacaoExame(id);
	}
}
