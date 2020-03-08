package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.vo.AvisoCursoLivreVO;

public class AvisoCursoLivreDAO extends AvisoDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
    public boolean existeRegistroAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query = "SELECT avcl.idavisocursolivre, av.idaviso FROM avisocursolivre avcl, aviso av "
                + "WHERE avcl.idaviso = av.idaviso "
                + " and av.idaviso = " + avisoCursoLivreVO.getIdAviso()
                + " and avcl.idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
        
        try {
            resultado = stmt.executeQuery(query);
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query que verifica existência de Aviso de Curso Livre.");
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return false;
    }

    public boolean existeRegistroPorIdAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        String query = "SELECT avcl.idavisocursolivre,av.idaviso FROM avisocursolivre avcl, aviso av "
                + "WHERE avcl.idaviso = av.idaviso " + " and av.idaviso = " + avisoCursoLivreVO.getIdAviso()
                + " and idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
        try {
            resultado = stmt.executeQuery(query);
            if (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query que verifica existência de Aviso de Curso Livre por ID.");
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return false;
    }

 
    public int cadastrarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
        int idAviso = this.cadastrarAvisoDAO(avisoCursoLivreVO);
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        int resultado = 0;
        String query = "INSERT INTO avisocursolivre (idaviso, nome, publicoalvo, requisito, ambiente, datacurso, valor) VALUES (" 
                + idAviso + ", '" 
                + avisoCursoLivreVO.getNome() + "', '" 
                + avisoCursoLivreVO.getPublicoAlvo() + "', '"
                + avisoCursoLivreVO.getRequisito() + "', '" 
                + avisoCursoLivreVO.getAmbiente() + "', '" 
                + avisoCursoLivreVO.getDataCurso() + "', '" 
                + avisoCursoLivreVO.getValor() + "')";
        
        /*String query = "INSERT INTO avisocursolivre (idaviso, nome, publicoalvo, requisito, ambiente, datacurso, valor) VALUES ("
                + idAviso + ", '" + avisoCursoLivreVO.getNome() + "', '" + avisoCursoLivreVO.getPublicoAlvo() + "', '"
                + avisoCursoLivreVO.getRequisito() + "', '" + avisoCursoLivreVO.getAmbiente() + "', '"
                + avisoCursoLivreVO.getDataCurso() + "', '" + avisoCursoLivreVO.getValor() + "')";*/
        try {
            resultado = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Cadastro do Aviso de Curso Livre.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return resultado;
    }
    
    public int atualizarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
    	boolean atualizado = this.atualizarAvisoDAO(avisoCursoLivreVO);
		int resultado = 0;
		if(atualizado) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			String query = "UPDATE avisocursolivre SET idaviso = " + avisoCursoLivreVO.getIdAviso() 
					+  ", nome = '" + avisoCursoLivreVO.getNome()
					+ "', publicoalvo = '" + avisoCursoLivreVO.getPublicoAlvo()
					+ "', requisito = '" + avisoCursoLivreVO.getRequisito() 
					+ "', ambiente = '" + avisoCursoLivreVO.getAmbiente()
					+ "', valor = '" + avisoCursoLivreVO.getValor()
					+ "', datacurso = '" + avisoCursoLivreVO.getDataCurso()
			        + "' WHERE idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
			try {
				resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("Erro ao executar a Query de Atualização do Aviso de Curso Livre.");
				System.out.println("Erro: " + e.getMessage());
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		} 
		return resultado;
	}

 
    public int excluirAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
    	Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM avisocursolivre WHERE idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
		try{
			resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				query = "DELETE FROM aviso WHERE idaviso = " + avisoCursoLivreVO.getIdAviso();
				resultado = 0;
				resultado = stmt.executeUpdate(query);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Aviso de Curso Livre.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
    }

 
    public ArrayList<AvisoCursoLivreVO> consultarTodosAvisosCursoLivreDAO() {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultado = null;
        ArrayList<AvisoCursoLivreVO> avisocursolivreVO = new ArrayList<AvisoCursoLivreVO>();
        String query = "SELECT av.idaviso, avcl.idavisocursolivre, avcl.nome, avcl.publicoalvo, avcl.requisito, avcl.ambiente, avcl.valor, avcl.datacurso, av.datacadastro, av.dataexpiracao "
        + " FROM aviso av, avisocursolivre avcl "
        + " WHERE av.idaviso = avcl.idaviso";  
        try {
            resultado = stmt.executeQuery(query);
            while (resultado.next()) {
                AvisoCursoLivreVO avisoCursoLivreVO = new AvisoCursoLivreVO();
                avisoCursoLivreVO.setIdAviso(Integer.parseInt(resultado.getString(1)));
                avisoCursoLivreVO.setIdAvisoCursoLivre(Integer.parseInt(resultado.getString(2)));
                avisoCursoLivreVO.setNome((resultado.getString(3)));
                avisoCursoLivreVO.setPublicoAlvo(resultado.getString(4));
                avisoCursoLivreVO.setRequisito(resultado.getString(5));
                avisoCursoLivreVO.setAmbiente(resultado.getString(6));
                avisoCursoLivreVO.setValor(Double.parseDouble(resultado.getString(7)));
                avisoCursoLivreVO.setDataCurso(LocalDate.parse(resultado.getString(8), dataFormatter));
                avisoCursoLivreVO.setDataCadastro(LocalDate.parse(resultado.getString(9), dataFormatter));
                avisoCursoLivreVO.setDataExpiracao(LocalDate.parse(resultado.getString(10), dataFormatter));
                avisocursolivreVO.add(avisoCursoLivreVO);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Consulta dos Avisos de Curso Livre.");
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
        return avisocursolivreVO;
    }
    public AvisoCursoLivreVO consultarAvisoCursoLivreDAO(AvisoCursoLivreVO avisoCursoLivreVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn); 
		ResultSet resultado = null;
		AvisoCursoLivreVO avisoCursoLivre = new AvisoCursoLivreVO();
		String query = "SELECT av.idaviso, avcl.idavisocursolivre, avcl.nome, avcl.publicoalvo, avcl.requisito, avcl.ambiente, avcl.valor, avcl.datacurso, av.datacadastro, av.dataexpiracao "
                + " FROM aviso av, avisocursolivre avcl "
                + " WHERE av.idaviso = avcl.idaviso "
				+ " and av.idaviso = " + avisoCursoLivreVO.getIdAviso()
				+ " and avcl.idavisocursolivre = " + avisoCursoLivreVO.getIdAvisoCursoLivre();
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
                avisoCursoLivre.setIdAviso(Integer.parseInt(resultado.getString(1)));
                avisoCursoLivre.setIdAvisoCursoLivre(Integer.parseInt(resultado.getString(2)));                
                avisoCursoLivre.setNome((resultado.getString(3)));
                avisoCursoLivre.setPublicoAlvo(resultado.getString(4));
                avisoCursoLivre.setRequisito(resultado.getString(5));
                avisoCursoLivre.setAmbiente(resultado.getString(6));
                avisoCursoLivre.setValor(Double.parseDouble(resultado.getString(7)));
                avisoCursoLivre.setDataCurso(LocalDate.parse(resultado.getString(8), dataFormatter));
                avisoCursoLivre.setDataCadastro(LocalDate.parse(resultado.getString(9), dataFormatter));
                avisoCursoLivre.setDataExpiracao(LocalDate.parse(resultado.getString(10), dataFormatter));      
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta do Aviso de Curso Livre.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return avisoCursoLivre;
	}
}