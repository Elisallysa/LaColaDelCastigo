package models;

public class Ciudad {

	//Atributos
	private String nombre;
	private int population;
	
	//Constructor
	public Ciudad(String nombre, int population) {
		super();
		this.setNombre(nombre);
		this.setPopulation(population);
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	//To String
	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + ", population=" + population + "]";
	}
}
