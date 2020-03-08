package view;

 

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraAvisoCursoLivre;
import model.vo.AvisoCursoLivreVO;
import model.vo.UsuarioVO;

 

public class MenuAvisoCursoLivre {

 

    Scanner teclado = new Scanner(System.in);
    DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private static final int OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE = 1;
    private static final int OPCAO_MENU_CADASTRAR_AVISO_CURSOLIVRE = 2;
    private static final int OPCAO_MENU_ATUALIZAR_AVISO_CURSOLIVRE = 3;
    private static final int OPCAO_MENU_EXCLUIR_AVISO_CURSOLIVRE = 4;
    private static final int OPCAO_MENU_AVISO_CURSOLIVRE_SAIR = 9;
    
    private static final int OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSOLIVRE = 1;
    private static final int OPCAO_MENU_CONSULTAR_UM_AVISO_CURSOLIVRE = 2;
    private static final int OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE_SAIR = 9;
    
    private static final int ADMINISTRADOR =  1;
	private static final int COORDENADOR =  2;
	private static final int SECRETARIA = 3;
    
    public void apresentarMenuAvisoCursoLivre(UsuarioVO usuarioVO) {
        int opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
        while (opcao != OPCAO_MENU_AVISO_CURSOLIVRE_SAIR) {
            switch (opcao) {
                case OPCAO_MENU_CADASTRAR_AVISO_CURSOLIVRE: {
                    this.cadastrarAvisoCursoLivre(usuarioVO);
                    break;
                }
                case OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE: {
                    this.consultarAvisoCursoLivre();
                    break;
                }
                case OPCAO_MENU_ATUALIZAR_AVISO_CURSOLIVRE: {
                    this.atualizarAvisoCursoLivre(usuarioVO);
                    break;
                }
                case OPCAO_MENU_EXCLUIR_AVISO_CURSOLIVRE: {
                    this.excluirAvisoCursoLivre();
                    break;
                }
                default: {
                    System.out.println("\nOpção Inválida");
                }
            }
            opcao = apresentarOpcoesMenu(usuarioVO.getIdTipoUsuario());
        }
    }
    
    private void excluirAvisoCursoLivre() {
        AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
        System.out.print("\nInforme o código do Aviso: ");
        avisoCursoLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
        System.out.print("\nInforme o código do Aviso do Curso: ");
        avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(teclado.nextLine()));

 

        ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
        controladoraAvisoCursoLivre.excluirAvisoCursoLivreController(avisoCursoLivreVO);
        
    }

 

    private void consultarAvisoCursoLivre() {
        int opcao = this.apresentarOpcoesConsulta();
        ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
        while (opcao != OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE_SAIR) {
            switch (opcao) {
                case OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSOLIVRE: {
                    opcao = OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE_SAIR;
                    ArrayList<AvisoCursoLivreVO> listaAvisosCursoLivreVO = controladoraAvisoCursoLivre.consultarTodosAvisosCursoLivreController();
                    System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
                    System.out.printf("\n%8s %15s %-25s %-25s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID AVISO", "ID CURSO LIVRE", "NOME", "PUBLICO ALVO", "REQUISITO", "AMBIENTE", "VALOR", "DATA CURSO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
                    for (int i = 0; i < listaAvisosCursoLivreVO.size(); i++) {
                        listaAvisosCursoLivreVO.get(i).imprimir();
                    }
                    break;
                }
                
                case OPCAO_MENU_CONSULTAR_UM_AVISO_CURSOLIVRE: {
                    opcao = OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE_SAIR;
                    AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
                    System.out.print("\nInforme o código do Aviso: ");
                    avisoCursoLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
                    System.out.print("\nInforme o código do Aviso de Curso Livre: ");
                    avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(teclado.nextLine()));
    
                    AvisoCursoLivreVO avisoCursoLivre = controladoraAvisoCursoLivre.consultarAvisoCursoLivreController(avisoCursoLivreVO);
                    System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
                    System.out.printf("\n%8s %15s %-25s %-25s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID AVISO", "ID CURSO LIVRE", "NOME", "PUBLICO ALVO", "REQUISITO", "AMBIENTE", "VALOR", "DATA CURSO", "DATA CADASTRO", "DATA EXPIRAÇÃO");
                    avisoCursoLivre.imprimir();
                    break;
                }
                default: {
                    System.out.println("\nOpção Inválida");
                    opcao = this.apresentarOpcoesConsulta();
                }
            }
        }
        
    }

 

    private int apresentarOpcoesMenu(int tipoUsuario) {
        System.out.println("\nSistema de Avisos \n-------- Menu Avisos de Cursos Livres --------");
        System.out.println("\nOpções:");
        System.out.println(OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE + " - Consultar Avisos de Cursos Livres");
        if(tipoUsuario == COORDENADOR || tipoUsuario == ADMINISTRADOR || tipoUsuario == SECRETARIA) {
        	System.out.println(OPCAO_MENU_CADASTRAR_AVISO_CURSOLIVRE + " - Cadastrar Avisos de Cursos Livres");
            System.out.println(OPCAO_MENU_ATUALIZAR_AVISO_CURSOLIVRE + " - Atualizar Avisos de Cursos Livres");
            System.out.println(OPCAO_MENU_EXCLUIR_AVISO_CURSOLIVRE + " - Excluir Avisos de Cursos Livres");			
		}	
        System.out.println(OPCAO_MENU_AVISO_CURSOLIVRE_SAIR + " - Voltar");
        System.out.print("\nDigite a Opção: ");
        return Integer.parseInt(teclado.nextLine());
    }
    
    private void cadastrarAvisoCursoLivre(UsuarioVO usuarioVO) {
        AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
        System.out.print("\nDigite a ID do usuário que está cadastrando este aviso: " );
        avisoCursoLivreVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
        System.out.print("\nDigite o nome do Curso Livre: ");
        avisoCursoLivreVO.setNome(teclado.nextLine());
        System.out.print("\nDigite o Público Alvo deste curso livre: ");
        avisoCursoLivreVO.setPublicoAlvo(teclado.nextLine());
        System.out.print("\nDigite os Requisitos deste curso livre: ");
        avisoCursoLivreVO.setRequisito(teclado.nextLine());
        System.out.print("\nDigite o Ambiente deste curso livre: ");
        avisoCursoLivreVO.setAmbiente(teclado.nextLine());       
        System.out.print("\nDigite o Valor deste curso livre: ");
        avisoCursoLivreVO.setValor(Double.parseDouble(teclado.nextLine()));
        System.out.print("\nDigite a Data de início deste curso livre: ");
        avisoCursoLivreVO.setDataCurso(LocalDate.parse(teclado.nextLine(), dataFormatter));
        System.out.print("Digite a data de cadastro do Aviso de Curso Livre: ");
        avisoCursoLivreVO.setDataCadastro(LocalDate.parse(teclado.nextLine(), dataFormatter));
        System.out.print("Digite a data de expiração do Aviso de Curso Livre: ");
        avisoCursoLivreVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
      
        ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
        controladoraAvisoCursoLivre.cadastrarAvisoCursoLivreController(avisoCursoLivreVO);
    }
  
    private void atualizarAvisoCursoLivre(UsuarioVO usuarioVO) {
        AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
        avisoCursoLivreVO.setIdUsuario(usuarioVO.getIdUsuario());
        System.out.print("\nInforme o código do Aviso: ");
        avisoCursoLivreVO.setIdAviso(Integer.parseInt(teclado.nextLine()));
        System.out.print("\nInforme o código do Aviso de Estagio: ");
        avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(teclado.nextLine()));
        System.out.print("\nDigite o nome do Curso Livre: ");
        avisoCursoLivreVO.setNome(teclado.nextLine());
        System.out.print("\nDigite o Público Alvo deste curso livre: ");
        avisoCursoLivreVO.setPublicoAlvo(teclado.nextLine());
        System.out.print("\nDigite os Requisitos deste curso livre: ");
        avisoCursoLivreVO.setRequisito(teclado.nextLine());
        System.out.print("\nDigite o Ambiente deste curso livre: ");
        avisoCursoLivreVO.setAmbiente(teclado.nextLine());       
        System.out.print("\nDigite o Valor deste curso livre: ");
        avisoCursoLivreVO.setValor(Double.parseDouble(teclado.nextLine()));
        System.out.print("\nDigite a Data de início deste curso livre: ");
        avisoCursoLivreVO.setDataCurso(LocalDate.parse(teclado.nextLine(), dataFormatter));
        System.out.print("Digite a data de cadastro do Aviso de Curso Livre: ");
        avisoCursoLivreVO.setDataCadastro(LocalDate.parse(teclado.nextLine(), dataFormatter));
        System.out.print("Digite a data de expiração do Aviso de Curso Livre: ");
        avisoCursoLivreVO.setDataExpiracao(LocalDate.parse(teclado.nextLine(), dataFormatter));
      
        ControladoraAvisoCursoLivre controladoraAvisoCursoLivre = new ControladoraAvisoCursoLivre();
        controladoraAvisoCursoLivre.atualizarAvisoCursoLivreController(avisoCursoLivreVO);
    }
  
    private int apresentarOpcoesConsulta() {
        System.out.println("\nInforme o tipo de consulta a ser realizada");
        System.out.println(OPCAO_MENU_CONSULTAR_TODOS_AVISOS_CURSOLIVRE + " - Consultar todos os Avisos de Curso Livre");
        System.out.println(OPCAO_MENU_CONSULTAR_UM_AVISO_CURSOLIVRE + " - Consultar um Aviso de um Curso Específico");
        System.out.println(OPCAO_MENU_CONSULTAR_AVISO_CURSOLIVRE_SAIR + " - Voltar");
        System.out.print("\nDigite a Opção: ");
        return Integer.parseInt(teclado.nextLine());
    }
}
