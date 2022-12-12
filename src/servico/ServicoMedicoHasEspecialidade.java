package servico;

import DAO.MedicoHasEspecialidadeDAO;
import model.MedicoHasEspecialidade;

import java.sql.SQLException;
import java.util.List;

public class ServicoMedicoHasEspecialidade {
    private MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();

    public MedicoHasEspecialidade salvar(MedicoHasEspecialidade entidade) {
        return medicoHasEspecialidadeDAO.insert(entidade);
    }

    public MedicoHasEspecialidade buscarPorId(Integer id) {
        return medicoHasEspecialidadeDAO.findById(id);
    }

    public void update(MedicoHasEspecialidade medico) throws SQLException {
        medicoHasEspecialidadeDAO.updateMedicoHasEspecialidade(medico);
    }

    public List<MedicoHasEspecialidade> listarTodos() {
        return medicoHasEspecialidadeDAO.selectAllMedicoHasEspecialidades();
    }

    public void remover(Integer id) throws SQLException {
        medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(id);
    }
}
