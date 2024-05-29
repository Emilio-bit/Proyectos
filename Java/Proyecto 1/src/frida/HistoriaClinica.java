package frida;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class HistoriaClinica {
	public Sexo sexo;
	public Date fechaNac;
	public ArrayList<String> vacunas;
	
	public HistoriaClinica(Sexo sexo, Date fechaNac, ArrayList<String> vacunas){
		this.sexo=sexo;
		this.fechaNac=fechaNac;
		this.vacunas=vacunas;
	}
	
	
	//Setters y Getters
	public Sexo getGenero() {
		return sexo;
	}
	public void setGenero(Sexo sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public ArrayList<String> getVacunas() {
		return vacunas;
	}
	public void setVacunas(ArrayList<String> vacunas) {
		this.vacunas = vacunas;
	}
	//método para ver historia clínica
	public void verHistoriaClinica() {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); //Se crea una instancia de la clase SimpleDateFormat
		SimpleDateFormat fSalida=new SimpleDateFormat("dd/MM/yyyy");//Se crea una instancia de la clase SimpleDateFormat para la salida
		JOptionPane.showMessageDialog(null, "Genero: "
				+sexo.toString()//Se imprime el sexo del animal
				+"\nFecha Nacimiento: "
				+fSalida.format(fechaNac));//Se imprime la fecha de nacimiento
		verVacunas(vacunas);//Se llama al método verVacunas
	}
	//método para ver vacuna
	public void verVacunas(ArrayList<String> vacunas) {
		for(int i=0; i<vacunas.size(); i++) {
			JOptionPane.showMessageDialog(null, vacunas.get(i));//Imprime un elemento del ArrayList vacunas
		}
		
	}
	
	
	
}
