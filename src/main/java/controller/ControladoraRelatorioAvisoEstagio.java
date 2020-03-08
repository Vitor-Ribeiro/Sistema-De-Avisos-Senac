package controller;

import java.util.ArrayList;

import model.bo.RelatorioAvisoEstagioBO;
import model.vo.RelatorioAvisoEstagioVO;

public class ControladoraRelatorioAvisoEstagio {

	public ArrayList<RelatorioAvisoEstagioVO> emitirRelatorioAvisosEstagioController() {
		RelatorioAvisoEstagioBO relatorioAvisoEstagioBO = new RelatorioAvisoEstagioBO();
		return relatorioAvisoEstagioBO.emitirRelatorioAvisoEstagioBO();
	}

}
