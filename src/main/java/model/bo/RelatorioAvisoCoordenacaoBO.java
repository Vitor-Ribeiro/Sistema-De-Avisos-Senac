package model.bo;

import java.util.ArrayList;
import model.dao.RelatorioAvisoCoordenacaoDAO;
import model.vo.RelatorioAvisoCoordenacaoVO;

public class RelatorioAvisoCoordenacaoBO {
	
	public ArrayList<RelatorioAvisoCoordenacaoVO> emitirRelatorioAvisosCoordenacaoBO() {
		RelatorioAvisoCoordenacaoDAO relatorioAvisoCoordenacaoDAO = new RelatorioAvisoCoordenacaoDAO();
		ArrayList<RelatorioAvisoCoordenacaoVO> relatorioAvisosCoordenacaoVO = relatorioAvisoCoordenacaoDAO.emitirRelatorioAvisoCoordenacaoDAO();
		if(relatorioAvisosCoordenacaoVO.isEmpty()){
			System.out.println("\nRelatório de Avisos da Coordenação está vazio.");
		}
		return relatorioAvisosCoordenacaoVO;
	}
	
}
