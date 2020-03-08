package controller;

import java.util.ArrayList;
import model.bo.RelatorioUsuarioPermissaoBO;
import model.vo.RelatorioUsuarioPermissaoVO;

public class ControladoraRelatorioUsuarioPermissao {

	public ArrayList<RelatorioUsuarioPermissaoVO> emitirRelatorioUsuarioPermissaoController() {
		RelatorioUsuarioPermissaoBO relatorioUsuarioPermissaoBO = new RelatorioUsuarioPermissaoBO();
		return relatorioUsuarioPermissaoBO.emitirRelatorioUsuarioPermissaoBO();
	}

}
