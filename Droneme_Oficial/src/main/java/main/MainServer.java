package main;

import static spark.Spark.*;

public class MainServer {
	
	final static Model model = new Model(); 

	public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1234;
        }
        port(port);
		staticFileLocation("/static");

		inicializarDrone();

		Controller controller = new Controller(model);
		
		controller.buscarDrone();

	}
	
	public static void inicializarDrone(){
    	model.addDrone(new Drone("1548796855", new Especificacao("Maverik","DJI","Branco","60KG"), 1223810));
    	model.addDrone(new Drone("1548796855", new Especificacao("Maverik","DJI","Branco","60KG"), 1223812));
    	model.addDrone(new Drone("1548796855", new Especificacao("Maverik","DJI","verde","45KG"), 1223811));
    }

}
