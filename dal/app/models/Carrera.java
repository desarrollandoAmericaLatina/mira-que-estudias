package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Carrera extends Model {

	@ManyToOne
	public Area area;

	public String nombre;

	@OneToMany(mappedBy = "carrera")
	public Set<CarreraTipoInst> carrerasTipoInst;

}
