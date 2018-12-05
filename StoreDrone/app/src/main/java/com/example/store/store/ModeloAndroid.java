package com.example.store.store;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModeloAndroid {

    List<DroneAndroid> drones = new LinkedList<DroneAndroid>();
    Conexao conexao = new Conexao();

    
    public void addDrone(DroneAndroid drone){
        drones.add(drone);
    }


    public List<DroneAndroid> obterDrones(){
        List<DroneAndroid> drone = new ArrayList<>();
        drone.add(new DroneAndroid(001, new EspecificacaoAndroid("Mavic 4.8", "DJI", "Preto", "54kl", "https://superimportadora.com.br/wp-content/uploads/2018/07/quadrada-site.002-3.jpeg", "R$ 500,00"),101));
        drone.add(new DroneAndroid(002, new EspecificacaoAndroid("AirFlyer More", "DJI", "Preto", "54kl", "https://superimportadora.com.br/wp-content/uploads/2018/07/quadrada-site.006.jpeg", "R$ 5000,00"),102));
        drone.add(new DroneAndroid(003, new EspecificacaoAndroid("Quad Copter", "Yuneec", "Preto", "54kl", "https://superimportadora.com.br/wp-content/uploads/2018/08/quadrada-site.002.jpeg", "R$ 1000,00"),103));
        drone.add(new DroneAndroid(004, new EspecificacaoAndroid("JDX 509", "Sony", "Preto", "54kl", "https://waz.vteximg.com.br/arquivos/ids/170318-1000-1000/111983-1-Drone_Inspire_1_PRO_DJI_Black_Edition_111983-5.jpg", "R$ 7000,00"),104));
        drone.add(new DroneAndroid(005, new EspecificacaoAndroid("Eachine", "Yuneec", "Preto", "54kl", "https://http2.mlstatic.com/D_Q_NP_958622-MLB27771639000_072018-Q.jpg", "R$ 2998,99"),105));
        return drone;
    }

    public List<DroneAndroid> getDrones(){
        return drones;
    }
}