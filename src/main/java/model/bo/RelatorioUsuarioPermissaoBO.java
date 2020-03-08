package model.bo;

import java.util.ArrayList;
import model.dao.RelatorioUsuarioPermissaoDAO;
import model.vo.RelatorioUsuarioPermissaoVO;

public class RelatorioUsuarioPermissaoBO {

	public ArrayList<RelatorioUsuarioPermissaoVO> emitirRelatorioUsuarioPermissaoBO() {
		RelatorioUsuarioPermissaoDAO relatorioUsuarioPermissaoDAO = new RelatorioUsuarioPermissaoDAO();
		ArrayList<RelatorioUsuarioPermissaoVO> relatorioUsuariosPermissaoVO = relatorioUsuarioPermissaoDAO.emitirRelatorioUsuarioPermissaoDAO();
		if(relatorioUsuariosPermissaoVO.isEmpty()){
			System.out.println("\nRelatório de Usuários por Tipo de Permissão está vazio.");
		}
		return relatorioUsuariosPermissaoVO;
	}

}
