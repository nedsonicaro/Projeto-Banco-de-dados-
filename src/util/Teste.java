package util;

import DAO.MedicoDAO;
import model.Medico;
import servico.ServicoMedico;

public class Teste {
	static ServicoMedico servicoMedico = new ServicoMedico();
	
	public static void main(String[] args) {
		//Medico med = new Medico("test", "crm");
		//medicoDAO.insert(med);
		
		//System.out.println(medicoDAO.count());
		//System.out.println(medicoDAO.selectAllMedicos());
		System.out.println(servicoMedico.buscarPorId(1));
	}
}
