package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Area extends Model {
	
	public String nombre;
	
	@OneToMany(mappedBy="area")
	@OrderBy("nombre asc")
	List<Carrera> carreras;

	@Override
	public String toString() {
		return nombre;
	}
    
}
