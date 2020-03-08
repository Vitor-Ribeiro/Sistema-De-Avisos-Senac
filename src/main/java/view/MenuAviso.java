package view;

import java.util.Scanner;

import model.vo.UsuarioVO;

public class MenuAviso {

	Scanner teclado = new Scanner(System.in);
    
	private static final int OPCAO_MENU_AVISO_COORDENACAO = 1;
	private static final int OPCAO_MENU_AVISO_CURSO_LIVRE = 2;
	private static final int OPCAO_MENU_AVISO_ESTAGIO = 3;
	private static final int OPCAO_MENU_AVISO_SAIR = 9;    
	
	public void apresentarMenuAviso(UsuarioVO usuarioVO) {
		
		int opcao = this.apresentarOpcoesMenu();
	
		while(opcao != OPCAO_MENU_AVISO_SAIR) {
			
			switch(opcao) {
				case OPCAO_MENU_AVISO_COORDENACAO: {
					MenuAvisoCoordenacao menuAvisoCoordenacao = new MenuAvisoCoordenacao();					
					menuAvisoCoordenacao.apresentarMenuAvisoCoordenacao(usuarioVO);
					break;
				}
			
				case OPCAO_MENU_AVISO_CURSO_LIVRE: {
					MenuAvisoCursoLivre menuAvisoCursoLivre = new MenuAvisoCursoLivre();
					menuAvisoCursoLivre.apresentarMenuAvisoCursoLivre(usuarioVO);
					break;
				}
				
				case OPCAO_MENU_AVISO_ESTAGIO: {
					MenuAvisoEstagio menuAvisoEstagio = new MenuAvisoEstagio();
					menuAvisoEstagio.apresentarMenuAvisoEstagio(usuarioVO);
					break;
				}
				
				default: {
					System.out.println("\nOpção Inválida.");
					break;
				}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}
	
	private int apresentarOpcoesMenu() {
		System.out.println("\nSistema de Avisos \n---------- Menu Cadastro de Aviso ----------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_AVISO_COORDENACAO + " - Aviso da Coordenação");
		System.out.println(OPCAO_MENU_AVISO_CURSO_LIVRE + " - Aviso de Curso Livre");
		System.out.println(OPCAO_MENU_AVISO_ESTAGIO + " - Aviso de Estágio");
		System.out.println(OPCAO_MENU_AVISO_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}
