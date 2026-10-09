package mascotas;

import java.time.LocalDate;

public class cita implements Comparable<cita>{
	private LocalDate fecha;
	private String Medico;
	private animal Animal;
	private dueño Dueño;
	private String obsrvacion;
	public cita(LocalDate fecha, String medico, animal animal, dueño dueño, String obsrvacion) {

		this.fecha = fecha;
		Medico = medico;
		Animal = animal;
		Dueño = dueño;
		this.obsrvacion = obsrvacion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getMedico() {
		return Medico;
	}
	public void setMedico(String medico) {
		Medico = medico;
	}
	public animal getAnimal() {
		return Animal;
	}
	public void setAnimal(animal animal) {
		Animal = animal;
	}
	public dueño getDueño() {
		return Dueño;
	}
	public void setDueño(dueño dueño) {
		Dueño = dueño;
	}
	public String getObsrvacion() {
		return obsrvacion;
	}
	public void setObsrvacion(String obsrvacion) {
		this.obsrvacion = obsrvacion;
	}
	@Override
	public int compareTo(cita o) {
		// TODO Auto-generated method stub
		return this.fecha.compareTo(o.getFecha());
	}
	
	@Override
	public String toString() {
	    return "Dueño: " + Dueño + "\nMascota: " + Animal  + "\nFecha: " + fecha;
	}
}
