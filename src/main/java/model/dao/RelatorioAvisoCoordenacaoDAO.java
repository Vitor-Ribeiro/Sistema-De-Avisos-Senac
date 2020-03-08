package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.RelatorioAvisoCoordenacaoVO;

public class RelatorioAvisoCoordenacaoDAO extends AvisoDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ArrayList<RelatorioAvisoCoordenacaoVO> emitirRelatorioAvisoCoordenacaoDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioAvisoCoordenacaoVO> emitirRelatorioAvisosCoordenacaoVO = new ArrayList<RelatorioAvisoCoordenacaoVO>();
		String query = "SELECT av.idaviso, avc.idavisocoordenacao, av.idusuario, avc.descricao, av.datacadastro, av.dataexpiracao "
				+ " FROM aviso av, avisocoordenacao avc "
				+ " WHERE av.idaviso = avc.idaviso"
				+ " ORDER BY av.dataexpiracao DESC";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				RelatorioAvisoCoordenacaoVO relatorioAvisoCoordenacaoVO = new RelatorioAvisoCoordenacaoVO();
				relatorioAvisoCoordenacaoVO.setIdAviso(Integer.parseInt(resultado.getString(1)));
				relatorioAvisoCoordenacaoVO.setIdAvisoCoordenacao(Integer.parseInt(resultado.getString(2)));
				relatorioAvisoCoordenacaoVO.setIdUsuario(Integer.parseInt(resultado.getString(3)));
				relatorioAvisoCoordenacaoVO.setDescricao(resultado.getString(4));
				relatorioAvisoCoordenacaoVO.setDataCadastro(LocalDate.parse(resultado.getString(5), dataFormatter));
				relatorioAvisoCoordenacaoVO.setDataExpiracao(LocalDate.parse(resultado.getString(6), dataFormatter));
				emitirRelatorioAvisosCoordenacaoVO.add(relatorioAvisoCoordenacaoVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Emitir Relatório dos Avisos da Coordenação.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return emitirRelatorioAvisosCoordenacaoVO;
	}
	
}
