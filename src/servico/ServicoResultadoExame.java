package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.ResultadoExameDAO;
import model.Contato;
import model.ResultadoExame;

public class ServicoResultadoExame {
	private ResultadoExameDAO resultadoExameDAO = new ResultadoExameDAO();

	public ResultadoExame salvar(ResultadoExame entidade) {
		return resultadoExameDAO.insert(entidade);
	}

	public ResultadoExame buscarPorId(Integer id) {
		return resultadoExameDAO.findById(id);
	}

	public void update(ResultadoExame entidade) throws SQLException {
		resultadoExameDAO.updateResultadoExame(entidade);
	}

	public List<ResultadoExame> listarTodos() {
		return resultadoExameDAO.selectAllResultadoExames();
	}

	public void remover(Integer id) throws SQLException {
		resultadoExameDAO.deleteResultadoExame(id);
	}
}
