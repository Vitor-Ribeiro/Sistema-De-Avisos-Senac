package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelatorioAvisoCoordenacaoVO extends AvisoCoordenacaoVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioAvisoCoordenacaoVO(int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao,
			int idAvisoCoordenacao, String descricao) {
		super(idAviso, idUsuario, dataCadastro, dataExpiracao, idAvisoCoordenacao, descricao);
	}
	
	public RelatorioAvisoCoordenacaoVO() {
		super();
	}

	public void imprimir() {
		System.out.printf("\n%8d   %15d   %-50s   %-15s   %-15s  \n", 
				this.getIdAviso(), 
				this.getIdAvisoCoordenacao(), 
				this.getDescricao(), 
				this.getDataCadastro().format(formataDate), 
				this.getDataExpiracao().format(formataDate));
	}
	
}
