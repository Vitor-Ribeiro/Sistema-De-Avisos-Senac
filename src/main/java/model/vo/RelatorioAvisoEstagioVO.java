package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelatorioAvisoEstagioVO extends AvisoEstagioVO {
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioAvisoEstagioVO(int idAviso, int idUsuario, LocalDate dataCadastro, LocalDate dataExpiracao,
			int idAvisoEstagio, String empresa, String telefone, String email, String cargo, String jornada,
			double remuneracao) {
		super(idAviso, idUsuario, dataCadastro, dataExpiracao, idAvisoEstagio, empresa, telefone, email, cargo, jornada,
				remuneracao);
	}

	public RelatorioAvisoEstagioVO() {
		super();
	}

	public void imprimir() {
		System.out.printf("\n%-8d %-16d %-15s %-15s %-25s %-15s %-8s %-20.2f %-15s %-15s \n", 
				this.getIdAviso(), 			
				this.getIdAvisoEstagio(), 
				this.getEmpresa(),
				this.getTelefone(),
				this.getEmail(),
				this.getCargo(),
				this.getJornada(),
				this.getRemuneracao(),
				this.getDataCadastro().format(formataDate), 
				this.getDataExpiracao().format(formataDate));
	}
	
}
