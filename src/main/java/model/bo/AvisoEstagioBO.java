package model.bo;

import java.util.ArrayList;
import model.dao.AvisoEstagioDAO;
import model.vo.AvisoEstagioVO;

public class AvisoEstagioBO {

	public void cadastrarAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if (avisoEstagioDAO.existeRegistroPorEmpresaCargoDAO(avisoEstagioVO.getEmpresa(), avisoEstagioVO.getCargo())) {
			System.out.println("\nAviso já cadastrado.");
		} else {
			int resultado = avisoEstagioDAO.cadastrarAvisoEstagioDAO(avisoEstagioVO);
			if (resultado == 1) {
				System.out.println("\nAviso de Estágio cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Aviso de Estágio.");
			}
		}
		
	}

	public void atulizarAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if(avisoEstagioDAO.existeRegistroPorIdAvisoEstagioDAO(avisoEstagioVO)){
			int resultado = avisoEstagioDAO.atualizarAvisoEstagioDAO(avisoEstagioVO);
			if(resultado == 1){
				System.out.println("\nAviso de Estagio atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Aviso de Estagio.");
			}
		} else {
			System.out.println("\nAviso de Estagio ainda não foi cadastrado.");
		}
		
	}

	public void excluirAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		if(avisoEstagioDAO.existeRegistroPorIdAvisoEstagioDAO(avisoEstagioVO)){
			int resultado = avisoEstagioDAO.excluirAvisoEstagioDAO(avisoEstagioVO);
			if(resultado == 1){
				System.out.println("\nAviso de Estagio excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Aviso de Estagio.");
			}
		} else {
			System.out.println("\nAviso de Estagio não existe na base da dados.");
		}
		
	}

	public ArrayList<AvisoEstagioVO> consultarTodosAvisosEstagioBO() {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		ArrayList<AvisoEstagioVO> avisosEstagioVO = avisoEstagioDAO.consultarTodosAvisoEstagioDAO();
		if(avisosEstagioVO.isEmpty()){
			System.out.println("\nLista de Avisos de Estagio está vazia.");
		}
		return avisosEstagioVO;
	}

	public AvisoEstagioVO consultarAvisoEstagioBO(AvisoEstagioVO avisoEstagioVO) {
		AvisoEstagioDAO avisoEstagioDAO = new AvisoEstagioDAO();
		AvisoEstagioVO avisoEstagio = avisoEstagioDAO.consultarAvisoEstagioDAO(avisoEstagioVO);
		if(avisoEstagio == null){
			System.out.println("\nAviso de Estagio não Localizado.");
		}
		return avisoEstagio;
	}	
	
}

