package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioAvisoEstagioDAO;
import model.vo.RelatorioAvisoEstagioVO;

public class RelatorioAvisoEstagioBO {

	public ArrayList<RelatorioAvisoEstagioVO> emitirRelatorioAvisoEstagioBO() {
		RelatorioAvisoEstagioDAO relatorioAvisoEstagioDAO = new RelatorioAvisoEstagioDAO();
		ArrayList<RelatorioAvisoEstagioVO> relatorioAvisosEstagioVO = relatorioAvisoEstagioDAO.emitirRelatorioAvisoEstagioDAO();
		if(relatorioAvisosEstagioVO.isEmpty()){
			System.out.println("\nRelatório de Avisos de Estágio está vazio.");
		}
		return relatorioAvisosEstagioVO;
	}

}
