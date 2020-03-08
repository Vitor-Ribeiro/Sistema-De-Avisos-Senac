package controller;

import java.util.ArrayList;
import model.bo.RelatorioAvisoCoordenacaoBO;
import model.vo.RelatorioAvisoCoordenacaoVO;

public class ControladoraRelatorioAvisoCoordenacao {

	public ArrayList<RelatorioAvisoCoordenacaoVO> emitirRelatorioAvisosCoordenacaoController() {
		RelatorioAvisoCoordenacaoBO relatorioAvisoCoordenacaoBO = new RelatorioAvisoCoordenacaoBO();
		return relatorioAvisoCoordenacaoBO.emitirRelatorioAvisosCoordenacaoBO();
	}
	
}
