package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.UnidadeMedidaDAO;
import model.Contato;
import model.UnidadeMedida;


public class ServicoUnidadeMedida {
	private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
	
	public UnidadeMedida salvar(UnidadeMedida entidade) {
		return unidadeMedidaDAO.insert(entidade);
	}

	public UnidadeMedida buscarPorId(Integer id) {
		return unidadeMedidaDAO.findById(id);
	}

	public void update(UnidadeMedida unidadeMedida) throws SQLException {
		unidadeMedidaDAO.updateUnidadeMedida(unidadeMedida);
	}

	public List<UnidadeMedida> listarTodos() {
		return unidadeMedidaDAO.selectAllUnidadeMedidas();
	}

	public void remover(Integer id) throws SQLException {
		unidadeMedidaDAO.deleteUnidadeMedida(id);
	}
}