package entities;

public class PagadorFisico extends PagadorDeImposto {
	private double gastosSaude;
	
	public PagadorFisico(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}
	
	public double getGastosSaude() {
		return this.gastosSaude;
	}
	
	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	public double imposto() {
		Double valorImposto = 0.0;
		Integer porcentagemImposto = 15;
		
		if (this.getRendaAnual() > 20000.00) porcentagemImposto = 25;

		valorImposto = this.getRendaAnual() / 100 * porcentagemImposto;
		
		if (this.gastosSaude > 0.0) valorImposto = valorImposto - (gastosSaude / 2);
		
		return valorImposto;
	}

}
