package model;

public class ResponsavelTecnicoHasLaboratorio extends GenericModel {
    private int responsavel_tecnico_id;
    private int laboratorio_id;

    public ResponsavelTecnicoHasLaboratorio(int responsavel_tecnico_id, int laboratorio_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
    }

    public ResponsavelTecnicoHasLaboratorio(Long id, int responsavel_tecnico_id, int laboratorio_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
        super.setId(id);
    }

    public int getResponsavel_tecnico_id() {
        return responsavel_tecnico_id;
    }

    public void setResponsavel_tecnico_id(int responsavel_tecnico_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
    }

    public int getLaboratorio_id() {
        return laboratorio_id;
    }

    public void setLaboratorio_id(int laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
    }
}