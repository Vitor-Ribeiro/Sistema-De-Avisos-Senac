package model.dto;

import model.dao.RelatorioUsuarioPermissaoDAO;

public class RelatorioUsuarioPermissaoDTO {

	RelatorioUsuarioPermissaoDAO relatorioUsuarioPermissaoDAO = new RelatorioUsuarioPermissaoDAO();
	
	public void emitirRelatorio() {
		
		relatorioUsuarioPermissaoDAO.emitirRelatorioUsuarioPermissaoDAO();
		
		}
}
