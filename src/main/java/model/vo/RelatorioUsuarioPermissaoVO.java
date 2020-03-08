package model.vo;

public class RelatorioUsuarioPermissaoVO extends TipoUsuarioVO {

	public RelatorioUsuarioPermissaoVO(int idUsuario, int idTipoUsuario, String nome, String cpf, String email,
			String login, String senha, int idTipoUsuario2, String descricao) {
		super(idUsuario, idTipoUsuario, nome, cpf, email, login, senha, idTipoUsuario2, descricao);
	}

	public RelatorioUsuarioPermissaoVO() {
		super();
	}

	public void imprimir() {
		System.out.printf("\n%-15d %-25s %-25s %-15s %-18d %-20s \n",
				this.getIdUsuario(),
				this.getNome(),
				this.getEmail(),
				this.getLogin(),
				this.getIdTipoUsuario(),
				this.getDescricao());
	}

}
