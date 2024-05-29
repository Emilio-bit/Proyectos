package frida;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Animal {
	public String id; //Número con el que se identifica al animal
	public HistoriaClinica certificado_salud;
	public Procedencia procedencia;//Sitio de donde llega el animal
	
	// Constructor por defecto
		public Animal() {
			
		}
	
	//Constructor con parámetros
	public Animal(HistoriaClinica certificado_salud, 
			Procedencia procedencia) {
		this.certificado_salud=certificado_salud;
		this.procedencia=procedencia;
	}
	
	//Getters y Setters
	public HistoriaClinica getCertificado_salud() {
		return certificado_salud;
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setCertificado_salud(HistoriaClinica certificado_salud) {
		this.certificado_salud = certificado_salud;
	}
	public Procedencia getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(Procedencia procedencia) {
		this.procedencia = procedencia;
	}
	
	
	public void mostrarAnimal(){
		JOptionPane.showMessageDialog(null, "Id: "+id);//Imprime el número de identificación
		JOptionPane.showMessageDialog(null, "Procedencia: "+ procedencia.toString());//Imprime la procedencia
		certificado_salud.verHistoriaClinica();//Llama al método verHistoriaClinica, de la clase HistoriaClinica
	}
	
	public Animal eliminarAnimal(Animal animal) {
		animal=null;
		return animal;
	}
}
