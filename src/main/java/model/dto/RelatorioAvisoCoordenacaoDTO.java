package model.dto;

import model.dao.RelatorioAvisoCoordenacaoDAO;

public class RelatorioAvisoCoordenacaoDTO {
	
	RelatorioAvisoCoordenacaoDAO relatorioAvisoCoordenacaoDAO = new RelatorioAvisoCoordenacaoDAO();
	
	public void emitirRelatorio() {
		
		relatorioAvisoCoordenacaoDAO.emitirRelatorioAvisoCoordenacaoDAO();
		
		}
		
	}
	
	

