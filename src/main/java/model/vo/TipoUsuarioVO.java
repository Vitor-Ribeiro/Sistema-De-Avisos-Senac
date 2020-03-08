package model.vo;

public class TipoUsuarioVO extends UsuarioVO {
	
	private int idTipoUsuario;
	private String descricao;
	
	public TipoUsuarioVO(int idUsuario, int idTipoUsuario, String nome, String cpf, String email, String login,
			String senha, int idTipoUsuario2, String descricao) {
		super(idUsuario, idTipoUsuario, nome, cpf, email, login, senha);
		idTipoUsuario = idTipoUsuario2;
		this.descricao = descricao;
	}

	public TipoUsuarioVO() {
		super();
		
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
	
		
	}


