package frida;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.JOptionPane;

public class AppAlbergue {
	public ArrayList<Animal> animales; //Lista de animales
	public ArrayList<AnimalAdoptado> animalesA;
	
	//Constructor con parámetros 
	public AppAlbergue(ArrayList<Animal> animales) {
		this.animales=animales;
	}
	
	//Métodos
	public void inscribirAnimal(AppAlbergue frida) {
		Integer opc=0,d,u;//Variable para leer la opción ingresada
		do {
		opc=Integer.parseInt(JOptionPane.showInputDialog("Selecciona:\n1)Gato\n2)Perro"));
		}while(opc>2||opc<1); 
		if(opc==1) {
			//frida.animales.add(frida.inscribirGato());//Llama a inscribirGato y añade un objeto Gato a la lista animales 
			try {
				d=Integer.parseInt(JOptionPane.showInputDialog("Cuantos animales vas a meter?")); 
				modifcarGato(frida,d);
				frida.animales.add(frida.inscribirGato());//Llama a inscribirGato y añade un objeto Gato a la lista animales
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//frida.animales.add(frida.inscribirPerro());//Llama a inscribirGato y añade un objeto Gato a la lista animales
			try{
				u=Integer.parseInt(JOptionPane.showInputDialog("Cuantos animales vas a meter?")); 
				modifcarPerro(frida,u);
				frida.animales.add(frida.inscribirPerro());//Llama a inscribirGato y añade un objeto Gato a la lista animales
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void crearExcel() 
	{
		
		Workbook book=new HSSFWorkbook();
		Sheet sheet= book.createSheet("perritos");
		
		Row row= sheet.createRow(0);
		row.createCell(0).setCellValue(20);
		
		
		try {
			FileOutputStream fileout= new FileOutputStream("Perritos y Gatitos.xls");
			book.write(fileout);
			fileout.close();
		} catch (FileNotFoundException e) {
			Logger.getLogger(RegistrosAlbergue.class.getName()).log(Level.SEVERE,null,e);
		}catch (IOException e) 
		{
			Logger.getLogger(RegistrosAlbergue.class.getName()).log(Level.SEVERE,null,e);

		}
		System.out.println("Archivo creado correctamente");
	}
	
	public static void modifcarPerro (AppAlbergue frida,Integer u) throws IOException 
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\emili\\OneDrive\\Escritorio\\trabajos eclipse\\Proyecto\\Perritos y Gatitos.xls"));
			
			Workbook wb=new HSSFWorkbook(file);
			Sheet sheet= wb.getSheetAt(0);
			
			Row fila=sheet.getRow(1);
			Row row=sheet.createRow(0);//fila
			Cell cell=row.createCell(0);//columna 
			
			
	
			Integer s=0;
			int i=0,j;
			String a=null;
			

			row.createCell(1).setCellValue("Perros");
		    for(j=1;j<=u;j++) {
				 
                    
					cell=sheet.createRow(j).createCell(1);
					cell.setCellValue(frida.inscribirPerro().id);
		    }	
			
			file.close();
			
			FileOutputStream output= new FileOutputStream("Perritos y Gatitos.xls");
			wb.write(output);
			output.close();
			
		}
		catch (FileNotFoundException e) 
		{
			Logger.getLogger(RegistrosAlbergue.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public static void modifcarGato (AppAlbergue frida,Integer d) throws IOException 
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\emili\\OneDrive\\Escritorio\\trabajos eclipse\\Proyecto\\Perritos y Gatitos.xls"));
			
			Workbook wb=new HSSFWorkbook(file);
			Sheet sheet= wb.getSheetAt(0);
			
			Row fila=sheet.getRow(1);
			Row row=sheet.createRow(0);//fila
			Cell cell=row.createCell(0);//columna 
			
			
			Integer s=0;
			int i=0,j;
			String a=null;

			row.createCell(0).setCellValue("Gatos");
		       for(j=1;j<=d;j++) {
	                
					cell=sheet.createRow(j).createCell(0);
					cell.setCellValue(frida.inscribirGato().id);
		       }

			file.close();
			FileOutputStream output= new FileOutputStream("Perritos y Gatitos.xls");
			wb.write(output);
			output.close();
		}
		catch (FileNotFoundException e) 
		{
			Logger.getLogger(RegistrosAlbergue.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public AnimalAdoptado darEnAdopcion(Animal animal) {
		Persona persona=new Persona();
		AnimalAdoptado animalAdoptado=new AnimalAdoptado();
		Integer opc=0;//Variable para leer la opción ingresada
		persona.nombre=JOptionPane.showInputDialog("Datos de persona que adopta\nNombre:");//Guarda el nombre de la persona
		persona.paterno=JOptionPane.showInputDialog("Apellido Paterno:");//Guarda el apellido paterno de la persona
		persona.materno=JOptionPane.showInputDialog("Apellido Materno:");//Guarda el apellido materno de la persona
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("Genero:\n1)Masculino\n2)Femenino"));
		}while(opc>2||opc<1);
		if(opc==1) {
			persona.genero=Genero.MASCULINO;//Asigna el género masculino
		}else {
			persona.genero=Genero.FEMENINO;//Asigna el género femenino
		}
		Domicilio direccion=new Domicilio();//Se crea la instancia dirección
		persona.domicilio=direccion;//Se asigna dirección a persona.domicilio. Esto para poder llenar los atributos que tiene un objeto de la clase Domicilio
		persona.domicilio.calle=JOptionPane.showInputDialog("Calle:");//Guarda la calle
		persona.domicilio.colonia=JOptionPane.showInputDialog("Colonia:");//Guarda la colonia
		persona.domicilio.numero=JOptionPane.showInputDialog("Número:");//Guarda el número de la casa o departamento
		persona.domicilio.cp=JOptionPane.showInputDialog("Código Postal:");//Guarda el código Postal
		animalAdoptado.persona=persona;//Se asigna persona a animalAdoptado.persona
		animalAdoptado.constanciaSalud=true;//Se asigna valor verdadero a animalAdoptado.constanciaSalud
		animal.eliminarAnimal(animal);
		return animalAdoptado;
	}
	
	//Devuelve una instancia Gato
	public Gato inscribirGato() {
		Gato gato=new Gato();
		Integer p=0, i=0, j=0;//Variable 'p' para leer la opción ingresada
		Date birthday=null;
		do {
			p=Integer.parseInt(JOptionPane.showInputDialog("Elige la procedencia del gato:\n1)Hogar\n2)Instituto"));
		}while(p>2||p<1);
		if(p==1) {
			gato.setProcedencia(Procedencia.HOGAR);//Se asigna valor HOGAR
		}else {
			gato.setProcedencia(Procedencia.INSTITUTO);//Se asigna valor INSTITUTO
		}
		HistoriaClinica certificado=new HistoriaClinica(null, birthday, null);
		gato.certificado_salud= certificado;
		do {
			p=Integer.parseInt(JOptionPane.showInputDialog("Elige el sexo del gato:\n1)Hembra\n2)Macho"));
		}while(p>2||p<1);
		if(p==1) {
			gato.getCertificado_salud().sexo=(Sexo.HEMBRA);//Se asigna valor de HEMBRA
		}else {
			gato.getCertificado_salud().sexo=(Sexo.MACHO);//Se asigna MACHO
		}
		ValidacionFecha fecha=new ValidacionFecha();//Se crea la instancaia 'fecha' de la clase ValidacionFecha
		SimpleDateFormat fSalida=new SimpleDateFormat("dd/MM/yyyy");//Se crea la instancia 'fSalida' de la clase SimpleDateFormat
		do {
			gato.certificado_salud.setFechaNac(fecha.validarCadenaF(JOptionPane.showInputDialog(null,"Escribe su fecha de nacimiento(dd/MM/yyyy): ")));//Se valida y registra la fecha ingresada
			if(gato.certificado_salud.getFechaNac()==null)
			{
				JOptionPane.showMessageDialog(null, "Fecha invalida, intenta de nuevo");//En caso de que la fecha sea inválida
			}	
				}while(gato.certificado_salud.getFechaNac()==null);
		JOptionPane.showMessageDialog(null, "Fecha de nacimiento guardada: "
				+fSalida.format(gato.certificado_salud.getFechaNac()));//Imprime la fecha capturada
		ArrayList<String> vacunas=new ArrayList <String> (); //Se crea la instancia 'vacunas'
		gato.certificado_salud.vacunas=vacunas;//Se asigna 'vacunas' a gato.certificado_salud.vacunas
		j=Integer.parseInt(JOptionPane.showInputDialog("Cuántas vacunas tiene: "));//Asigna a 'j'  el numero de vacunas
		for(i=0;i<j;i++) {
			gato.certificado_salud.vacunas.add(JOptionPane.showInputDialog("Escribe sus vacunas: "));//Añade un String al ArrayList<String> vacunas, de la instancia gato
		}
		gato.setId(JOptionPane.showInputDialog("Escribe el identificador del felino(es un numero de 6 cifras): "));//Se guarda el número en el atributo 'id' 
		return gato;//Regresa la instancia 'gato'
	}
	
	//Devuelve una instancia de la clase Perro
	public Perro inscribirPerro() {
		Perro perro=new Perro();
		Integer p=0, i=0, j=0;//Variable 'p' para leer la opción ingresada
		Date birthday=null;
		do {
			p=Integer.parseInt(JOptionPane.showInputDialog("Elige la procedencia del perro:\n1)Hogar\n2)Instituto"));
		}while(p>2||p<1);
		if(p==1) {
			perro.setProcedencia(Procedencia.HOGAR);//Se asigna valor HOGAR
		}else {
			perro.setProcedencia(Procedencia.INSTITUTO);//Se asigna valor Instituto
		}
		
		HistoriaClinica certificado=new HistoriaClinica(null, birthday, null);
		perro.certificado_salud= certificado;
		
		do {
			p=Integer.parseInt(JOptionPane.showInputDialog("Elige el sexo del perro:\n1)Hembra\n2)Macho"));
		}while(p>2||p<1);
		if(p==1) {
			perro.getCertificado_salud().sexo=(Sexo.HEMBRA);//Se asigna valor de HEMBRA
		}else {
			perro.getCertificado_salud().sexo=(Sexo.MACHO);//Se asigna MACHO
		}
		ValidacionFecha fecha=new ValidacionFecha();//Se crea la instancaia 'fecha' de la clase ValidacionFecha
		SimpleDateFormat fSalida=new SimpleDateFormat("dd/MM/yyyy");//Se crea la instancia 'fSalida' de la clase SimpleDateFormat
		do {
			perro.certificado_salud.setFechaNac(fecha.validarCadenaF(JOptionPane.showInputDialog(null,"Escribe su fecha de nacimiento(dd/MM/yyyy): ")));//Se valida y registra la fecha ingresada
			if(perro.certificado_salud.getFechaNac()==null)
			{
				JOptionPane.showMessageDialog(null, "Fecha invalida, intenta de nuevo");//En caso de que la fecha sea inválida
			}	
				}while(perro.certificado_salud.getFechaNac()==null);
		JOptionPane.showMessageDialog(null, "Fecha de nacimiento guardada: "
				+fSalida.format(perro.certificado_salud.getFechaNac()));//Imprime la fecha capturada
		ArrayList<String> vacunas=new ArrayList <String> ();//Se crea la instancia 'vacunas'
		perro.certificado_salud.vacunas=vacunas;//Se asigna 'vacunas' a perro.certificado_salud.vacunas
		j=Integer.parseInt(JOptionPane.showInputDialog("Cuántas vacunas tiene: "));//Asigna a 'j'  el numero de vacunas
		for(i=0;i<j;i++) {
			perro.certificado_salud.vacunas.add(JOptionPane.showInputDialog("Escribe sus vacunas: "));//Añade un String al ArrayList<String> vacunas, de la instancia perro
		}
		perro.setId(JOptionPane.showInputDialog("Escribe el identificador del canino(es un numero de 6 cifras): "));//Se guarda el número en el atributo 'id'
		do {
			p=Integer.parseInt(JOptionPane.showInputDialog(null, "Tiene un grado de adiestramiento:\n1)Si\n2)No"));
			if(p==1){
				perro.setCertificadoAdiestramiento(true);// Asigna un valor de verdadero a perro.certificadoAdiestramiento 
			}else
			{
				perro.setCertificadoAdiestramiento(false);// Asigna un valor de falso a perro.certificadoAdiestramiento 
			}
		}while(p>2||p<1);
		return perro;//Regresa la instancia 'gato'
	}
	
	
	
	/*public void ConsultarAnimales() {
		int i;
		for(i=0, i<j i++) {
			JOptionPane.showMessageDialog(null, "Procedencia: "
					+animales.get(i).procedencia);
		}*/
	//}
	

}
