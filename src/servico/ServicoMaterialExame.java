package servico;

import java.sql.SQLException;
import java.util.List;

import DAO.MaterialExameDAO;
import model.Contato;
import model.MaterialExame;


public class ServicoMaterialExame {
	private MaterialExameDAO materialExameDAO = new MaterialExameDAO();
	
	public MaterialExame salvar(MaterialExame entidade) {
		return materialExameDAO.insert(entidade);
	}

	public MaterialExame buscarPorId(Integer id) {
		return materialExameDAO.findById(id);
	}

	public void update(MaterialExame materialExame) throws SQLException {
		materialExameDAO.updateMaterialExame(materialExame);
	}

	public List<MaterialExame> listarTodos() {
		return materialExameDAO.selectAllMaterialExames();
	}

	public void remover(Integer id) throws SQLException {
		materialExameDAO.deleteMaterialExame(id);
	}
}
