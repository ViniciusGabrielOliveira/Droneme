package main;

import main.Especificacao;

public class Especificacao {
	
	private String modelo;
	private String marca;
	private String cor;
	private String peso; 
	
	
	public Especificacao(String modelo, String marca, String cor, String peso){
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.peso = peso; 
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public String getMarca(){
		return marca;
	}
	
	public String getCor(){
		return cor;
	}
	
	public String getPeso() {
		return peso;
	}

	
	public boolean comparar(Especificacao esp){
		if(marca.equals(esp.marca) && modelo.equals(esp.modelo) && cor.equals(esp.cor) && peso.equals(esp.peso)){
			return true;
		} else {
			return false;
		}
	}

}
