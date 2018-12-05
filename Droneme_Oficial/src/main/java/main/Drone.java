package main;

import main.Especificacao;

public class Drone {
	
	private Especificacao espec; 
	private String numeroSerie; //Numero de Serie. 
	private int numeroID; //Numero de Identificação.
	
	public Drone(String numeroSerie, Especificacao espec, int numeroID){
		this.numeroSerie = numeroSerie;
		this.espec = espec; 
		this.numeroID = numeroID;
	}

	public Especificacao getEspec() {
		return espec;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public int getNumeroID() {
		return numeroID;
	}

}
