package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.vo.RelatorioAvisoEstagioVO;

public class RelatorioAvisoEstagioDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public ArrayList<RelatorioAvisoEstagioVO> emitirRelatorioAvisoEstagioDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioAvisoEstagioVO> emitirRelatorioAvisosEstagioVO = new ArrayList<RelatorioAvisoEstagioVO>();
		String query = "SELECT av.idaviso, ave.idavisoestagio, ave.empresa, ave.telefone, ave.email, ave.cargo, ave.jornada, ave.remuneracao, av.datacadastro, av.dataexpiracao "
                + " FROM aviso av, avisoestagio ave "
                + " WHERE av.idaviso = ave.idaviso"
                + " ORDER BY av.dataexpiracao ASC";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				RelatorioAvisoEstagioVO relatorioAvisoEstagioVO = new RelatorioAvisoEstagioVO();
				relatorioAvisoEstagioVO.setIdAviso(Integer.parseInt(resultado.getString(1)));
				relatorioAvisoEstagioVO.setIdAvisoEstagio(Integer.parseInt(resultado.getString(2)));                
				relatorioAvisoEstagioVO.setEmpresa(resultado.getString(3));
				relatorioAvisoEstagioVO.setTelefone(resultado.getString(4));
				relatorioAvisoEstagioVO.setEmail(resultado.getString(5));
				relatorioAvisoEstagioVO.setCargo(resultado.getString(6));
				relatorioAvisoEstagioVO.setJornada(resultado.getString(7));
				relatorioAvisoEstagioVO.setRemuneracao(Double.parseDouble(resultado.getString(8)));
				relatorioAvisoEstagioVO.setDataCadastro(LocalDate.parse(resultado.getString(9), dataFormatter));
				relatorioAvisoEstagioVO.setDataExpiracao(LocalDate.parse(resultado.getString(10), dataFormatter));            
				emitirRelatorioAvisosEstagioVO.add(relatorioAvisoEstagioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Emitir Relatório dos Avisos de Estágio.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return emitirRelatorioAvisosEstagioVO;
	}

}
