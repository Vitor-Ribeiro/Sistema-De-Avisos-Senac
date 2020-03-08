package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.RelatorioUsuarioPermissaoVO;

public class RelatorioUsuarioPermissaoDAO {

	public ArrayList<RelatorioUsuarioPermissaoVO> emitirRelatorioUsuarioPermissaoDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<RelatorioUsuarioPermissaoVO> emitirRelatorioUsuarioPermissaoVO = new ArrayList<RelatorioUsuarioPermissaoVO>();
		String query = "SELECT us.idusuario, us.nome, us.email, us.login, tu.idtipousuario, tu.descricao "
				+ " FROM tipousuario tu, usuario us "
				+ " WHERE tu.idtipousuario = us.idtipousuario " 
				+ " ORDER BY tu.idtipousuario"; 
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				RelatorioUsuarioPermissaoVO relatorioUsuarioPermissaoVO = new RelatorioUsuarioPermissaoVO();
				relatorioUsuarioPermissaoVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				relatorioUsuarioPermissaoVO.setNome(resultado.getString(2));
				relatorioUsuarioPermissaoVO.setEmail(resultado.getString(3));
				relatorioUsuarioPermissaoVO.setLogin(resultado.getString(4));
				relatorioUsuarioPermissaoVO.setIdTipoUsuario(Integer.parseInt(resultado.getString(5)));
				relatorioUsuarioPermissaoVO.setDescricao(resultado.getString(6));
				emitirRelatorioUsuarioPermissaoVO.add(relatorioUsuarioPermissaoVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Emitir Relatório de Usuários por Tipo de Permissão.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return emitirRelatorioUsuarioPermissaoVO;
	}

}
