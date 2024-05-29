package frida;

import javax.swing.JOptionPane;

public class Perro extends Animal{
	public boolean certificadoAdiestramiento;
	
	public Perro(Integer id, HistoriaClinica certificado_salud, 
			Procedencia procedencia, boolean certificadoAdiestramiento) {
		super(certificado_salud, procedencia);
		this.certificadoAdiestramiento=certificadoAdiestramiento;
	}
	
	//Constructor por defecto
	public Perro() {
	}


	//Setters y Getters
	public boolean isCertificadoAdiestramiento() {
		return certificadoAdiestramiento;
	}
	public void setCertificadoAdiestramiento(boolean certificadoAdiestramiento) {
		this.certificadoAdiestramiento = certificadoAdiestramiento;
	}
	//método para mostrar Animal con parámetro de tipo Perro
	public void mostrarAnimal(){
		JOptionPane.showMessageDialog(null, "El animal es un perro...");
		super.mostrarAnimal();
		//Perro perro = new Perro();
		if(isCertificadoAdiestramiento()==false) {
			JOptionPane.showMessageDialog(null, "Grado de adiestramiento: No");//Imprime si no tiene algún grado de adiestramiento
		}else {
			if(isCertificadoAdiestramiento()==true) {
				JOptionPane.showMessageDialog(null, "Grado de adiestramiento: Si"); //Imprime si tiene algún grado de adiestramiento
			}
		}
	}
	
	
}
