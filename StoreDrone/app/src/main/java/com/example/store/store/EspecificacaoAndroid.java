package com.example.store.store;

public class EspecificacaoAndroid {
    private String modelo;
    private String marca;
    private String cor;
    private String peso;
    private String valor;
    private String imgDrone;


    public EspecificacaoAndroid(String modelo, String marca, String cor, String peso, String imgDrone, String valor){
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.peso = peso;
        this.imgDrone = imgDrone;
        this.valor = valor;
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

    public String getImgDrone() { return imgDrone; }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setImgDrone(String imgDrone) {
        this.imgDrone = imgDrone;
    }

    public boolean comparar(EspecificacaoAndroid esp){
        if(marca.equals(esp.marca) && modelo.equals(esp.modelo) && cor.equals(esp.cor) && peso.equals(esp.peso)){
            return true;
        } else {
            return false;
        }
    }

}
