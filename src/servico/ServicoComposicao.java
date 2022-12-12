package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.ComposicaoDAO;
import model.Composicao;
import model.MedicoHasEspecialidade;

public class ServicoComposicao {
	private ComposicaoDAO composicaoDAO = new ComposicaoDAO();

	public Composicao salvar(Composicao entidade) {
		return composicaoDAO.insert(entidade);
	}

	public Composicao buscarPorId(Integer id) {
		return composicaoDAO.findById(id);
	}

	public void update(Composicao entidade) throws SQLException {
		composicaoDAO.updateComposicao(entidade);
	}

	public List<Composicao> listarTodos() {
		return composicaoDAO.selectAllComposicaos();
	}

	public void remover(Integer id) throws SQLException {
		composicaoDAO.deleteComposicao(id);
	}
}
