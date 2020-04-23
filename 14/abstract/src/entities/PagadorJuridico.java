package entities;

public class PagadorJuridico extends PagadorDeImposto {
	private int numeroFuncionarios;
	
	public PagadorJuridico (String nome, double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public Integer getNumeroFuncionarios() {
		return this.numeroFuncionarios;
	}
	
	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public double imposto() {
		Double valorImposto = 0.0;
		int porcentagemImposto = 16;
		
		if (numeroFuncionarios > 10) porcentagemImposto = 14;
		
		valorImposto = this.getRendaAnual() / 100 * porcentagemImposto;
		
		return valorImposto;
	}

}
