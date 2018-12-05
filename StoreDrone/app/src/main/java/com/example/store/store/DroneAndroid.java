package com.example.store.store;

public class DroneAndroid {

    private EspecificacaoAndroid espec;
    private int numeroSerie; //Numero de Serie.
    private int numeroID; //Numero de Identificação.

    public DroneAndroid(int numeroSerie, EspecificacaoAndroid espec, int numeroID){
        this.numeroSerie = numeroSerie;
        this.espec = espec;
        this.numeroID = numeroID;
    }

    public EspecificacaoAndroid getEspec() {
        return espec;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }


    public int getNumeroID() {
        return numeroID;
    }



}