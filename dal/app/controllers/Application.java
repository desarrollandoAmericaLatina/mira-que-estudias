package controllers;

import java.util.List;

import models.Area;
import models.Carrera;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index(Long areaID) {

		List<Area> areas = Area.findAll();
		for (Area areaIter : areas) {
			System.out.println(areaIter);
		}

		Area area = null;

		if (areaID == null)
			area = areas.get(0);
		else {
			area = Area.findById(areaID);
		}

		System.out.println("area actual " + area);

		render(area, areas);
	}

	public static void detalleCarrera(Long carreraID) {

		Carrera carrera = Carrera.findById(carreraID);

		render(carrera);
	}

}