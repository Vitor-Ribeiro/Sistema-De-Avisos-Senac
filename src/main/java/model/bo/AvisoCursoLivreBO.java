package model.bo;

import java.util.ArrayList;
import model.dao.AvisoCursoLivreDAO;
import model.vo.AvisoCursoLivreVO;

public class AvisoCursoLivreBO {
	public void cadastrarAvisoCursoLivreBO(AvisoCursoLivreVO avisocursolivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if (avisoCursoLivreDAO.existeRegistroAvisoCursoLivreDAO(avisocursolivreVO)) {
			System.out.println("\nAviso de Curso Livre já Cadastrado");
		} else {
			int resultado = avisoCursoLivreDAO.cadastrarAvisoCursoLivreDAO(avisocursolivreVO);
			if (resultado == 1) {
				System.out.println("\nAviso de Curso Livre cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Aviso de Curso Livre.");
			}
		}
	}

	public void atualizarAvisoCursoLivreBO(AvisoCursoLivreVO avisocursolivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if (avisoCursoLivreDAO.existeRegistroPorIdAvisoCursoLivreDAO(avisocursolivreVO)) {
			int resultado = avisoCursoLivreDAO.atualizarAvisoCursoLivreDAO(avisocursolivreVO);
			if (resultado == 1) {
				System.out.println("\nAviso de Curso Livre atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Aviso de Curso Livre.");
			}
		} else {
			System.out.println("\nAviso de Curso Livre ainda não foi cadastrado.");
		}
	}
	
	public void excluirAvisoCursoLivreBO(AvisoCursoLivreVO avisocursolivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		if (avisoCursoLivreDAO.existeRegistroPorIdAvisoCursoLivreDAO(avisocursolivreVO)) {
			int resultado = avisoCursoLivreDAO.excluirAvisoCursoLivreDAO(avisocursolivreVO);
			if (resultado == 1) {
				System.out.println("\nAviso de Curso Livre excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Aviso de Curso Livre.");
			}
		} else {
			System.out.println("\nAviso de Curso Livre ainda não foi excluído.");
		}
	}
	public ArrayList<AvisoCursoLivreVO> consultarTodosAvisosCursoLivreBO(){
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		ArrayList<AvisoCursoLivreVO>avisocursolivreVO = avisoCursoLivreDAO.consultarTodosAvisosCursoLivreDAO();
		if(avisocursolivreVO.isEmpty()){
			System.out.println("\nLista de Avisos da Coordenação está vazia.");
		}
		return avisocursolivreVO;
	}
	
	public AvisoCursoLivreVO consultarAvisoCursoLivreBO(AvisoCursoLivreVO avisocursolivreVO) {
		AvisoCursoLivreDAO avisoCursoLivreDAO = new AvisoCursoLivreDAO();
		AvisoCursoLivreVO avisocursolivre = avisoCursoLivreDAO.consultarAvisoCursoLivreDAO(avisocursolivreVO);
		if(avisocursolivre == null) {
			System.out.println("\nAviso de Curso Livre não Localizado.");
		}
		return avisocursolivre;
	}

		
		
	}