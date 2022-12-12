package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.SiglaFormacaoDAO;
import model.Contato;
import model.SiglaFormacao;

public class ServicoSiglaFormacao {
	private SiglaFormacaoDAO siglaFormacaoDAO = new SiglaFormacaoDAO();
	
	public SiglaFormacao salvar(SiglaFormacao entidade) {
		return siglaFormacaoDAO.insert(entidade);
	}

	public SiglaFormacao buscarPorId(Integer id) {
		return siglaFormacaoDAO.findById(id);
	}

	public void update(SiglaFormacao entidade) throws SQLException {
		siglaFormacaoDAO.updateSiglaFormacao(entidade);
	}

	public List<SiglaFormacao> listarTodos() {
		return siglaFormacaoDAO.selectAllSiglaFormacaos();
	}

	public void remover(Integer id) throws SQLException {
		siglaFormacaoDAO.deleteSiglaFormacao(id);
	}
}
