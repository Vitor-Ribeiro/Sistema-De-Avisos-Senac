package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.UsuarioVO;


public class UsuarioDAO {

	public boolean existeRegistroPorCpfDAO(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM usuario WHERE cpf = '" + cpf + "'";	
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}	
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de Usuário por CPF.");
			System.out.println("Erro: " + e.getMessage());
			return false;
			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO usuario (idtipousuario, nome, cpf, email, login, senha) VALUES ( " 
		+ usuarioVO.getIdTipoUsuario() + ", '" 
		+ usuarioVO.getNome() + "', '" 
		+ usuarioVO.getCpf() + "', '" 
		+ usuarioVO.getEmail() + "', '"
		+ usuarioVO.getLogin() + "', '" 
		+ usuarioVO.getSenha() + "') ";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	
	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
		String query = "SELECT idusuario, nome, cpf, email FROM usuario";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				UsuarioVO usuario = new UsuarioVO();
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				listaUsuariosVO.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de Consultar Todos os Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = new UsuarioVO();
		String query = "SELECT idusuario, nome, cpf, email FROM usuario WHERE idUsuario = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de Consultar de Usuário Específico.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	public boolean existeRegistroPorIdUsuarioDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM usuario WHERE idUsuario = " + idUsuario;	
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}	
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica existência de Usuário por ID.");
			System.out.println("Erro: " + e.getMessage());
			return false;
			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM usuario WHERE idUsuario = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão de Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE USUARIO SET nome = '" + usuarioVO.getNome() + "', "
				+ " cpf = '" + usuarioVO.getCpf() + "', "
				+ " email = '" + usuarioVO.getEmail() + "', "
				+ " idTipoUsuario = " + usuarioVO.getIdTipoUsuario() + ", "
				+ " senha = '" + usuarioVO.getSenha() + "' "
				+ " WHERE idUsuario = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização de Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public UsuarioVO recuperarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idUsuario, idTipoUsuario, nome, cpf, email FROM usuario WHERE login = '" + usuarioVO.getLogin() + "' AND senha = '" + usuarioVO.getSenha() + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				usuarioVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setIdTipoUsuario(Integer.parseInt(resultado.getString(2)));
				usuarioVO.setNome(resultado.getString(3));
				usuarioVO.setCpf(resultado.getString(4));
				usuarioVO.setEmail(resultado.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que recupera o Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarioVO;
	}

	public ArrayList<model.vo.TipoUsuarioVO> consultarTipoUsuarioDAO() {
		 Connection conn = Banco.getConnection();
	        Statement stmt = Banco.getStatement(conn);
	        ResultSet resultado = null;
	        ArrayList<model.vo.TipoUsuarioVO> lista = new ArrayList<model.vo.TipoUsuarioVO>();
	        String query = "SELECT idTipoUsuario, descricao FROM tipousuario ";
	        try {
	            resultado = stmt.executeQuery(query);
	            while (resultado.next()) {
	                model.vo.TipoUsuarioVO tipoUsuario = new model.vo.TipoUsuarioVO();
	                tipoUsuario.setIdTipoUsuario(Integer.parseInt(resultado.getString(1)));
	                tipoUsuario.setDescricao(resultado.getString(2));
	                lista.add(tipoUsuario);
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao executar a query que recupera o usuário.");
	            System.out.println("Erro : " + e.getMessage());
	        } finally {
	            Banco.closeResultSet(resultado);
	            Banco.closeStatement(stmt);
	            Banco.closeConnection(conn);
	        }
	        return lista;
	    }

}
