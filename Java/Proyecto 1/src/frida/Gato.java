package frida;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import frida.ValidacionFecha;

public class Gato extends Animal {
	
	//Constructor por defecto
	public Gato() {
	
	}
	
	//Constructor con parámetros
	public Gato(Integer id,HistoriaClinica certificado_salud, 
			Procedencia procedencia) {
		super(certificado_salud, procedencia);
	}
	
	//método que para mostrar todos los datos de una instancia de la clase Animal
	public void mostrarAnimal(){
		JOptionPane.showMessageDialog(null, "El animal es un gato...");
		super.mostrarAnimal();
	}

	
	
}
