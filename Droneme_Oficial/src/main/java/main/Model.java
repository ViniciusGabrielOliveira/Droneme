package main;

import java.util.LinkedList;
import java.util.List;

import main.Drone;
import main.Especificacao;

public class Model {
	
private List<Drone> drones = new LinkedList<Drone>();

	
	public void addDrone(Drone drone){
		drones.add(drone);
	}
	
	
	public List<Drone> buscarNumeroSerie(String numeroSerie){
		List<Drone> drone_Num = new LinkedList<Drone>();
//		int numeroSe = Integer.parseInt(numeroSerie);
		for(Drone drone:drones){
			if(numeroSerie.equals(drone.getNumeroSerie())) drone_Num.add(drone);
		}
		return drone_Num;
	}
	
	
	public List<Drone> buscarEspecificacao(Especificacao esp){
		List<Drone> dronesEncontrados = new LinkedList<Drone>();
		for(Drone drone:drones){
			 if(esp.comparar(drone.getEspec())) dronesEncontrados.add(drone);
		}
		return dronesEncontrados;	
	}
	
	public List<Drone> buscarMarca(String marca){
		List<Drone> Listdrone = new LinkedList<Drone>(); 
		for(Drone drone:drones) {
			if(marca.equals(drone.getEspec().getMarca())) Listdrone.add(drone);
		}
		return Listdrone;
	}
	
	
	public List<Drone> getDrones(){
		return drones;
	}

}
