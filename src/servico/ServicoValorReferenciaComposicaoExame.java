package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.ValorReferenciaComposicaoExameDAO;
import model.Contato;
import model.ValorReferenciaComposicaoExame;

public class ServicoValorReferenciaComposicaoExame {
	private ValorReferenciaComposicaoExameDAO valorReferenciaComposicaoExameDAO = new ValorReferenciaComposicaoExameDAO();

	public ValorReferenciaComposicaoExame salvar(ValorReferenciaComposicaoExame entidade) {
		return valorReferenciaComposicaoExameDAO.insert(entidade);
	}

	public ValorReferenciaComposicaoExame buscarPorId(Integer id) {
		return valorReferenciaComposicaoExameDAO.findById(id);
	}

	public void update(ValorReferenciaComposicaoExame entidade) throws SQLException {
		valorReferenciaComposicaoExameDAO.updateValorReferenciaComposicaoExame(entidade);
	}

	public List<ValorReferenciaComposicaoExame> listarTodos() {
		return valorReferenciaComposicaoExameDAO.selectAllValorReferenciaComposicaoExames();
	}

	public void remover(Integer id) throws SQLException {
		valorReferenciaComposicaoExameDAO.deleteValorReferenciaComposicaoExame(id);
	}
}	
