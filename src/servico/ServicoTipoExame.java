package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.TipoExameDAO;
import model.Contato;
import model.TipoExame;

public class ServicoTipoExame {
	private TipoExameDAO tipoExameDAO = new TipoExameDAO();

	public TipoExame salvar(TipoExame entidade) {
		return tipoExameDAO.insert(entidade);
	}

	public TipoExame buscarPorId(Integer id) {
		return tipoExameDAO.findById(id);
	}

	public void update(TipoExame entidade) throws SQLException {
		tipoExameDAO.updateTipoExame(entidade);
	}

	public List<TipoExame> listarTodos() {
		return tipoExameDAO.selectAllTipoExames();
	}

	public void remover(Integer id) throws SQLException {
		tipoExameDAO.deleteTipoExame(id);
	}
}
