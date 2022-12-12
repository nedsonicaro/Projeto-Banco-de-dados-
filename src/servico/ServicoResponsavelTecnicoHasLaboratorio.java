package servico;

import DAO.ResponsavelTecnicoHasLaboratorioDAO;
import model.Contato;
import model.ResponsavelTecnicoHasLaboratorio;

import java.sql.SQLException;
import java.util.List;

public class ServicoResponsavelTecnicoHasLaboratorio {
    private ResponsavelTecnicoHasLaboratorioDAO responsavelTecnicoHasLaboratorioDAO = new ResponsavelTecnicoHasLaboratorioDAO();

    public ResponsavelTecnicoHasLaboratorio salvar(ResponsavelTecnicoHasLaboratorio entidade) {
        return responsavelTecnicoHasLaboratorioDAO.insert(entidade);
    }

    public ResponsavelTecnicoHasLaboratorio buscarPorId(Integer id) {
        return responsavelTecnicoHasLaboratorioDAO.findById(id);
    }

    public void update(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        responsavelTecnicoHasLaboratorioDAO.updateResponsavelTecnicoHasLaboratorio(entidade);
    }

    public List<ResponsavelTecnicoHasLaboratorio> listarTodos() {
        return responsavelTecnicoHasLaboratorioDAO.selectAllResponsavelTecnicoHasLaboratorios();
    }

    public void remover(Integer id) throws SQLException {
        responsavelTecnicoHasLaboratorioDAO.deleteResponsavelTecnicoHasLaboratorio(id);
    }
}
