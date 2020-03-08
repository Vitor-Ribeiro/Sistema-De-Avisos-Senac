package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraRelatorioAvisoCoordenacao;
import controller.ControladoraRelatorioAvisoEstagio;
import controller.ControladoraRelatorioUsuarioPermissao;
import model.vo.RelatorioAvisoCoordenacaoVO;
import model.vo.RelatorioAvisoEstagioVO;
import model.vo.RelatorioUsuarioPermissaoVO;

public class MenuRelatorio {

	Scanner teclado = new Scanner(System.in);
    
    private static final int OPCAO_MENU_EMITIR_RELATORIO = 1;    
    private static final int OPCAO_MENU_RELATORIO_SAIR = 9;
    
    private static final int OPCAO_MENU_RELATORIO_USUARIO_PERMISSAO = 1;
    private static final int OPCAO_MENU_RELATORIO_AVISO_ESTAGIO = 2;
    private static final int OPCAO_MENU_RELATORIO_AVISO_COORDENACAO = 3;
    private static final int OPCAO_MENU_EMITIR_RELATORIO_SAIR = 9;
    
	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao != OPCAO_MENU_RELATORIO_SAIR) {
			
			switch(opcao) {
				case OPCAO_MENU_EMITIR_RELATORIO: {
					this.emitirRelatorio();
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

	private void emitirRelatorio() {
		int opcao = this.apresentarOpcoesConsulta();
		while(opcao != OPCAO_MENU_EMITIR_RELATORIO_SAIR) {
			switch(opcao) {
				case OPCAO_MENU_RELATORIO_USUARIO_PERMISSAO: {
					opcao = OPCAO_MENU_EMITIR_RELATORIO_SAIR;
					this.emitirRelatorioUsuarioPermissao();
					break;
				}
				case OPCAO_MENU_RELATORIO_AVISO_ESTAGIO: {
					opcao = OPCAO_MENU_EMITIR_RELATORIO_SAIR;
					this.emitirRelatorioAvisoEstagio();
					break;
				}
				case OPCAO_MENU_RELATORIO_AVISO_COORDENACAO: {
					opcao = OPCAO_MENU_EMITIR_RELATORIO_SAIR;
					this.emitirRelatorioCoordenacao();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
		
	}

	private void emitirRelatorioUsuarioPermissao() {
		ControladoraRelatorioUsuarioPermissao controladoraRelatorioUsuarioPermissao = new ControladoraRelatorioUsuarioPermissao();
		ArrayList<RelatorioUsuarioPermissaoVO> relatorioUsuarioPermissaoVO = controladoraRelatorioUsuarioPermissao.emitirRelatorioUsuarioPermissaoController();
		System.out.print("\n--------- RELATÓRIO DE USUÁRIOS POR TIPO DE PERMISSÃO ---------");
		System.out.printf("\n%-15s %-25s %-25s %-15s %-18s %-20s \n", "ID USUÁRIO", "NOME", "E-MAIL", "LOGIN", "ID TIPO USUÁRIO", "DESCRIÇÃO");
		for (int i = 0; i < relatorioUsuarioPermissaoVO.size(); i++) {
			relatorioUsuarioPermissaoVO.get(i).imprimir();
		}
	}

	private void emitirRelatorioAvisoEstagio() {
		ControladoraRelatorioAvisoEstagio controladoraRelatorioAvisoEstagio = new ControladoraRelatorioAvisoEstagio();
		ArrayList<RelatorioAvisoEstagioVO> relatorioAvisosEstagioVO = controladoraRelatorioAvisoEstagio.emitirRelatorioAvisosEstagioController();
		System.out.print("\n--------- RELATÓRIO DE AVISOS DE ESTÁGIO ---------");
		System.out.printf("\n%8s %16s %-15s %-15s %-25s %-15s %-8s %-20s %-15s %-15s   \n", "ID AVISO", "ID AVISO ESTAGIO", "EMPRESA", "TELEFONE", "EMAIL", "CARGO", "JORNADA", "REMUNERAÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO" );
		for (int i = 0; i < relatorioAvisosEstagioVO.size(); i++) {
			relatorioAvisosEstagioVO.get(i).imprimir();
		}
	}

	private void emitirRelatorioCoordenacao() {
		ControladoraRelatorioAvisoCoordenacao controladoraRelatorioAvisoCoordenacao = new ControladoraRelatorioAvisoCoordenacao();
		ArrayList<RelatorioAvisoCoordenacaoVO> relatorioAvisosCoordenacaoVO = controladoraRelatorioAvisoCoordenacao.emitirRelatorioAvisosCoordenacaoController();
		System.out.print("\n--------- RELATÓRIO DE AVISOS DA COORDENAÇÃO ---------");
		System.out.printf("\n%8s   %15s   %-50s   %-15s   %-15s  \n", "ID AVISO", "ID AVISO COORD.", "DESCRIÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
		for (int i = 0; i < relatorioAvisosCoordenacaoVO.size(); i++) {
			relatorioAvisosCoordenacaoVO.get(i).imprimir();
		}
		
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("Informe o tipo de relatório a ser emitido");
		System.out.println(OPCAO_MENU_RELATORIO_USUARIO_PERMISSAO + " - Emitir Relatório de Usuários e Permissões por Tipo");
		System.out.println(OPCAO_MENU_RELATORIO_AVISO_ESTAGIO + " - Emitir Relatório de Avisos de Estágio");
		System.out.println(OPCAO_MENU_RELATORIO_AVISO_COORDENACAO + " - Emitir Relatório de Avisos da Coordenação");
		System.out.println(OPCAO_MENU_EMITIR_RELATORIO_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	

	private int apresentarOpcoesMenu() {
		System.out.println("\nSistema de Avisos \n---------- Menu de Relatórios ----------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_EMITIR_RELATORIO + " - Emitir Relatório");		
		System.out.println(OPCAO_MENU_RELATORIO_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}
