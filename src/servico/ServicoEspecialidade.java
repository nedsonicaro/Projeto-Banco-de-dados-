package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.EspecialidadeDAO;
import model.Contato;
import model.Especialidade;

public class ServicoEspecialidade {
	private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

	public Especialidade salvar(Especialidade entidade) {
		return especialidadeDAO.insert(entidade);
	}

	public Especialidade buscarPorId(Integer id) {
		return especialidadeDAO.findById(id);
	}

	public void update(Especialidade especialidade) throws SQLException {
		especialidadeDAO.updateEspecialidade(especialidade);
	}

	public List<Especialidade> listarTodos() {
		return especialidadeDAO.selectAllEspecialidades();
	}

	public void remover(Integer id) throws SQLException {
		especialidadeDAO.deleteEspecialidade(id);
	}
}
