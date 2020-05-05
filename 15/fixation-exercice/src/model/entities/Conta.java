package model.entities;

import model.exceptions.saqueException;

public class Conta {
	private int numero;
	private String titular;
	private double saldo;
	private double limiteSaque;
	
	public Conta(int numero, String titular, double saldo, double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}
	
	public void sacar(double valor) throws saqueException {
		if (valor > limiteSaque) throw new saqueException("Esse valor excede o limite de saque");
		if (saldo == 0) throw new saqueException("A conta não possui saldo");
		if (saldo < valor) throw new saqueException("A conta não possui saldo suficiente");
		
		this.saldo -= valor;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
}
