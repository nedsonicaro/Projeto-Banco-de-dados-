package model;

public class MedicoHasEspecialidade extends GenericModel{
    private int medico_id;
    private int especialidade_id;

    public MedicoHasEspecialidade(int medico_id, int especialidade_id) {
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
    }

    public MedicoHasEspecialidade(Long id, int medico_id, int especialidade_id) {
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
        super.setId(id);
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public int getEspecialidade_id() {
        return especialidade_id;
    }

    public void setEspecialidade_id(int especialidade_id) {
        this.especialidade_id = especialidade_id;
    }
}
