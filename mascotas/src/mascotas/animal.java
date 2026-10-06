package mascotas;

public class animal {
	private String nombre;
	private int edad;
	private String especie;
	private String raza;
	public animal(String nombre, int edad, String especie, String raza) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.especie = especie;
		this.raza = raza;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
}
