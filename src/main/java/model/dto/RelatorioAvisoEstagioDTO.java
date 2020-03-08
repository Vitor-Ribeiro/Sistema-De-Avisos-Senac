package model.dto;

import model.dao.RelatorioAvisoEstagioDAO;

public class RelatorioAvisoEstagioDTO {
	
	RelatorioAvisoEstagioDAO relatorioAvisoEstagioDAO = new RelatorioAvisoEstagioDAO();
	
	public void emitirRelatorio() {
		
		relatorioAvisoEstagioDAO.emitirRelatorioAvisoEstagioDAO();
		
		}
	
}
