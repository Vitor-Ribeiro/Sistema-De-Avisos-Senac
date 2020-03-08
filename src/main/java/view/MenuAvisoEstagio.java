package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraAvisoEstagio;
import model.vo.AvisoEstagioVO;
import model.vo.UsuarioVO;

public class MenuAvisoEstagio {
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO= 1;
	private static final int OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO = 4;
	private static final int OPCAO_MENU_AVISO_ESTAGIO_SAIR = 9;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_SAIR = 9;
	
	private static final int ADMINISTRADOR =  1;
	private static final int COORDENADOR =  2;
	private static final int SECRETARIA = 3;
		
	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenuAvisoEstagio(UsuarioVO usuarioVO) {
		int opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		while (opcao != OPCAO_MENU_AVISO_ESTAGIO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO: {
					this.cadastrarAvisoEstagio(usuarioVO);
					break;
				}
				case OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO: {
					this.consultarAvisoEstagio();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO: {
					this.atualizarAvisoEstagio(usuarioVO);
					break;
				}
				case OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO: {
					this.excluirAvisoEstagio();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
		}
	}
	
	private int apresentarOpcoesMenu(int tipoUsuario) {
		System.out.println("\nSistema de Avisos \n-------- Menu Avisos de Estagio --------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO + " - Consultar Avisos de Estagio");
		if(tipoUsuario == COORDENADOR || tipoUsuario == ADMINISTRADOR || tipoUsuario == SECRETARIA) {
			System.out.println(OPCAO_MENU_CADASTRAR_AVISO_ESTAGIO + " - Cadastrar Avisos de Estagio");
			System.out.println(OPCAO_MENU_ATUALIZAR_AVISO_ESTAGIO + " - Atualizar Avisos de Estagio");
			System.out.println(OPCAO_MENU_EXCLUIR_AVISO_ESTAGIO + " - Excluir Avisos de Estagio");	
		}	
		System.out.println(OPCAO_MENU_AVISO_ESTAGIO_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarAvisoEstagio(UsuarioVO usuarioVO) {
		AvisoEstagioVO avisoEstagioVO = new AvisoEstagioVO();
		avisoEstagioVO.setIdUsuario(usuarioVO.getIdUsuario());
		System.out.print("\nDigite a empresa fornecedora do Estagio: ");
		avisoEstagioVO.setEmpresa(teclado.nextLine());
		System.out.print("\nDigite o telefone para contato com a empresa: ");
		avisoEstagioVO.setTelefone(teclado.nextLine());
		System.out.print("\nDigite o email para contato com a empresa: ");
		avisoEstagioVO.setEmail(teclado.nextLine());
		System.out.print("\nDigite o cargo que a empresa fornece: ");
		avisoEstagioVO.setCargo(teclado.nextLine());
		System.out.print("\nDigite a jornada que a empresa apresenta: ");
		avisoEstagioVO.setJornada(teclado.nextLine());
		System.out.print("\nDigite a remuneração do cargo: ");
		avisoEstagioVO.setRemuneracao(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data de cadastro do Aviso de Estagio: ");
		avisoEstagioVO.setDataCadastro(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de expiração do Aviso de Estagio: ");
		avisoEstagioVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
		controladoraAvisoEstagio.cadastrarAvisoEstagioController(avisoEstagioVO);
	}
	
	private void excluirAvisoEstagio() {
		AvisoEstagioVO avisoEstagioVO = new AvisoEstagioVO();
		System.out.print("\nInforme o código do Aviso: ");
		avisoEstagioVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nInforme o código do Aviso de Estagio: ");
		avisoEstagioVO.setIdAvisoEstagio(Integer.parseInt(teclado.nextLine()));
		
		ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
		controladoraAvisoEstagio.excluirAvisoEstagioController(avisoEstagioVO);
	}

	private void atualizarAvisoEstagio(UsuarioVO usuarioVO) {
        AvisoEstagioVO avisoEstagioVO = new AvisoEstagioVO();
        avisoEstagioVO.setIdUsuario(usuarioVO.getIdUsuario());
        System.out.print("\nInforme o código do Aviso: ");
        avisoEstagioVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
        System.out.print("\nInforme o código do Aviso de Estagio: ");
        avisoEstagioVO.setIdAvisoEstagio(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a empresa fornecedora do Estagio: ");
		avisoEstagioVO.setEmpresa(teclado.nextLine());
		System.out.print("\nDigite o telefone para contato com a empresa: ");
		avisoEstagioVO.setTelefone(teclado.nextLine());
		System.out.print("\nDigite o email para contato com a empresa: ");
		avisoEstagioVO.setEmail(teclado.nextLine());
		System.out.print("\nDigite o cargo que a empresa fornece: ");
		avisoEstagioVO.setCargo(teclado.nextLine());
		System.out.print("\nDigite a jornada que a empresa apresenta: ");
		avisoEstagioVO.setJornada(teclado.nextLine());
		System.out.print("\nDigite a remuneração do cargo: ");
		avisoEstagioVO.setRemuneracao(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data de cadastro do Aviso de Estagio: ");
		avisoEstagioVO.setDataCadastro(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de expiração do Aviso de Estagio: ");
		avisoEstagioVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
		controladoraAvisoEstagio.atualizarAvisoEstagioController(avisoEstagioVO);
	}

	private void consultarAvisoEstagio() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraAvisoEstagio controladoraAvisoEstagio = new ControladoraAvisoEstagio();
		while (opcao != OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO: {
					opcao = OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_SAIR;
					ArrayList<AvisoEstagioVO> listaAvisosEstagioVO = controladoraAvisoEstagio.consultarTodosAvisosEstagioController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%8s %16s %-15s %-15s %-25s %-15s %-8s %-20s %-15s %-15s   \n", "ID AVISO", "ID AVISO ESTAGIO", "EMPRESA", "TELEFONE", "EMAIL", "CARGO", "JORNADA", "REMUNERAÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO" );
					for (int i = 0; i < listaAvisosEstagioVO.size(); i++) {
						listaAvisosEstagioVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO: {
					opcao = OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_SAIR;
					AvisoEstagioVO avisoEstagioVO = new AvisoEstagioVO();
					System.out.print("\nInforme o código do Aviso: ");
					avisoEstagioVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
					System.out.print("\nInforme o código do Aviso de Estagio: ");
					avisoEstagioVO.setIdAvisoEstagio(Integer.parseInt(teclado.nextLine()));
	
					AvisoEstagioVO avisoEstagio = controladoraAvisoEstagio.consultarAvisoEstagioController(avisoEstagioVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%8s %16s %-15s %-15s %-25s %-15s %-8s %-20s %-15s %-15s   \n", "ID AVISO", "ID AVISO ESTAGIO", "EMPRESA", "TELEFONE", "EMAIL", "CARGO", "JORNADA", "REMUNERAÇÃO", "DATA CADASTRO", "DATA EXPIRAÇÃO" );
					avisoEstagio.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
	}
	
	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_AVISOS_ESTAGIO + " - Consultar todos os Avisos de Estagio");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_AVISO_ESTAGIO + " - Consultar um Aviso de  Estagio Específico");
		System.out.println(OPCAO_MENU_CONSULTAR_AVISO_ESTAGIO_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
}
