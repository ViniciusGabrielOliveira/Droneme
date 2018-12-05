package main;

import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	// Retorna o Drone pela Busca
	public void buscarDrone() {
		get("/drone/:modelo/:marca/:cor/:peso", (req, res) -> {

			Especificacao espec = new Especificacao(req.params(":modelo"), req.params(":marca"), req.params(":cor"),
					req.params(":peso"));
			List<Drone> dronesEncontrados = model.buscarEspecificacao(espec);
			return new Gson().toJson(dronesEncontrados);
		});

		get("/drone/:marca", (req, res) -> {

			List<Drone> drone = model.buscarMarca(req.params(":marca"));
			return new Gson().toJson(drone);
		});

		get("/drone/:numero", (req, res) -> {

			List<Drone> droneEncontrados_S = model.buscarNumeroSerie(req.params(":numero"));
			return new Gson().toJson(droneEncontrados_S);
		});
	}
}
