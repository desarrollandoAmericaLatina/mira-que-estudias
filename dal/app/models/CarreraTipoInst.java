package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PostLoad;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import play.db.jpa.Model;

/**
 * The persistent class for the tabla1 database table.
 * 
 */
@Entity
public class CarreraTipoInst extends Model {
	public static final long serialVersionUID = 1L;

	enum TipoDato {
		EMPLEABILIDAD, SUELDO, COSTO
	}

	public String getNombre() {

		return carrera.nombre;
	}

	public class AnoValor {
		public int ano;
		public float valor;
		public TipoDato tipoDato;

		private AnoValor(int ano, float valor, TipoDato tipoDato) {
			super();
			this.ano = ano;
			this.valor = valor;
			this.tipoDato = tipoDato;
		}

	}

	@Transient
	List<AnoValor> empleabilidad = new ArrayList<AnoValor>();

	@Transient
	List<AnoValor> sueldos = new ArrayList<AnoValor>();

	@PostLoad
	public void init() {

		empleabilidad.add(new AnoValor(2005, toFloat(emp2005),
				TipoDato.EMPLEABILIDAD));
		empleabilidad.add(new AnoValor(2006, toFloat(emp2006),
				TipoDato.EMPLEABILIDAD));
		empleabilidad.add(new AnoValor(2007, toFloat(emp2007),
				TipoDato.EMPLEABILIDAD));
		empleabilidad.add(new AnoValor(2008, toFloat(emp2008),
				TipoDato.EMPLEABILIDAD));

		sueldos.add(new AnoValor(1, arreglaSueldo(sueldo1), TipoDato.SUELDO));
		sueldos.add(new AnoValor(2, arreglaSueldo(sueldo2), TipoDato.SUELDO));
		sueldos.add(new AnoValor(3, arreglaSueldo(sueldo3), TipoDato.SUELDO));
		sueldos.add(new AnoValor(4, arreglaSueldo(sueldo4), TipoDato.SUELDO));

	}

	static float arreglaSueldo(String s) {
		s = s.replaceAll("\\.", "");

		return Float.parseFloat(s + ".0");

	}

	static float toFloat(String string) {

		string = string.replaceAll(",", ".");
		return Float.parseFloat(string);

	}

	@ManyToOne
	public Carrera carrera;

	public String tipoInst;

	public String campo1;

	public String campo10;

	public String campo11;

	public String campo12;

	public String campo13;

	public String campo14;

	public String campo15;

	public String campo16;

	public String campo17;

	public String campo18;

	public String campo19;

	public String campo20;

	public String campo21;

	public String campo22;

	public String campo23;

	public String campo24;

	public String campo25;

	public String campo26;

	public String campo27;

	public String campo28;

	public String sueldo1;

	public String campo3;

	public String sueldo2;

	public String sueldo3;

	public String sueldo4;

	public String campo33;

	public String campo34;

	public String campo35;

	public String campo36;

	public String campo37;

	public String campo38;

	public String campo39;

	public String emp2005;

	public String campo40;

	public String campo41;

	public String campo42;

	public String campo43;

	public String campo44;

	public String campo45;

	public String campo46;

	public String campo47;

	public String campo48;

	public String campo49;

	public String emp2006;

	public String campo50;

	public String campo51;

	public String campo52;

	public String campo53;

	public String campo54;

	public String campo55;

	public String campo56;

	public String emp2007;

	public String emp2008;

	public String campo8;

	public String campo9;

	public AnoValor getUltEmpleabilidad() {
		return empleabilidad.get(empleabilidad.size() - 1);

	}

	public AnoValor getUltSueldoAprox() {
		return sueldos.get(sueldos.size() - 1);

	}

	public String getStringEmpleabilidad() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < empleabilidad.size(); i++) {
			if (i > 0)
				sb.append(",");
			AnoValor anoValor = empleabilidad.get(i);
			sb.append(anoValor.valor);
		}

		System.out.println(this + " " + sb.toString());
		return sb.toString();

	}

	public int getPixelsEmpleabilidad() {

		AnoValor ultEmpleabilidad = getUltEmpleabilidad();
		return (int) (ultEmpleabilidad.valor * 100);

	}

	public int getUltSueldoInteger() {

		AnoValor ultSueldoAprox = this.getUltSueldoAprox();

		return (int) ultSueldoAprox.valor / 10000;

	}
}