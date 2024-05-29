package frida;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Prueba2 {

	public static void main(String[] args) {
		ArrayList<Animal> animales =new ArrayList<Animal>();
		AppAlbergue frida= new AppAlbergue(animales);
		
		Gato boris=new Gato(318281, new HistoriaClinica(Sexo.MACHO, new Date(),
				new ArrayList<String>()), Procedencia.HOGAR);
		frida.animales.add(boris);
		
		Integer opc=0;
		String identificador=null;
		do {
			do {
				opc=Integer.parseInt(JOptionPane.showInputDialog(null, "Menú\n1)Incribir animal al albergue"
						+ "\n2)Dar en adopción\n3)Mostrar datos del animal\n4)Modificar datos del animal\n5)Salir"));
			}while(opc<1||opc>6);
			switch(opc) {
			case 1: 
				frida.inscribirAnimal(frida);
				break;
			case 2: 
				identificador=JOptionPane.showInputDialog("Ingresa el identificador(Número de 6 cifras):");
				for(int i=0; i<frida.animales.size();i++) {
					if(identificador.equals(frida.animales.get(i).getId())) {
						frida.darEnAdopcion(frida.animales.get(i));
					}if(i>=frida.animales.size()) {
						JOptionPane.showMessageDialog(null, "El animal no fue encontrado");
					}
				}
				break;
			case 3:
				identificador=JOptionPane.showInputDialog("Ingresa el identificador(Número de 6 cifras):");
				for(int i=0; i<frida.animales.size();i++) {
					if(identificador.equals(frida.animales.get(i).getId())) {
						frida.animales.get(i).mostrarAnimal();
					}if(i>=frida.animales.size()) {
						JOptionPane.showMessageDialog(null, "El animal no fue encontrado");
					}
					
			}
				break;
			default: 
			
			}
			
		}while(opc!=5);
	}


}
