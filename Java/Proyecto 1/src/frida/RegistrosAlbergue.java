package frida;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box.Filler;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.math.BigDecimal;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.SimpleDateFormat;
	import java.util.Arrays;
	import java.util.List;

	import javax.swing.Box.Filler;
	import javax.swing.JOptionPane;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.poifs.filesystem.POIFSFileSystem;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.Font;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.hssf.usermodel.HSSFCell;
	import org.apache.poi.hssf.usermodel.HSSFRow;
	import org.apache.poi.hssf.usermodel.HSSFSheet;


	public class RegistrosAlbergue <E> {


		public static void main(String[] args) {
		     crearExcel();
		    /* try {
				escribir();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		     try {
				modifcar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
		
		///////M[e]todo
		public static void modifcar () throws IOException 
		{
			try 
			{
				FileInputStream file = new FileInputStream(new File("C:\\Users\\emili\\OneDrive\\Escritorio\\trabajos eclipse\\Proyecto\\Perritos y Gatitos.xls"));
				
				Workbook wb=new HSSFWorkbook(file);
				Sheet sheet= wb.getSheetAt(0);
				
				Row fila=sheet.getRow(1);
				Row row=sheet.createRow(0);//fila
				Cell cell=row.createCell(0);//columna 
				
				/*row.createCell(1).setCellValue("toto");//primeras celdas nombres etc
				row.createCell(2).setCellValue("toto");
				
				cell=sheet.createRow(1).createCell(0); //moverte dentro de la fila el row es para moverte fila y el cell para moverte columna 
				cell.setCellValue("totos"); 
				
				cell=sheet.createRow(2).createCell(0);
				cell.setCellValue("boris");*/
				Integer s=0;
				int i=0;
				String a=null;
				
				s=Integer.parseInt(JOptionPane.showInputDialog("que desea hacer:\n1-incribir una mascota\n2-Modificar"));
				if(s==1) {
				   for(int j=0;j<4;j++) 
				    {
				
					 i++;
					 a=JOptionPane.showInputDialog("ingrese el nombre del perro:");
					
					 cell=sheet.createRow(i).createCell(0);
					 cell.setCellValue(a);
					
				     }
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
		/*
		public static void escribir() throws Exception {
			   List<Object[]> datos= Arrays.asList(new Object[]{"Laura", 21.0}, new Object[]{"Sandra",20.0}); 
		
			crearExcel();
			System.out.println("Escribiendo................");
			HSSFWorkbook workbook = null;
			HSSFSheet sheet = workbook.getSheetAt(0);
			int totalRenglones=sheet.getLastRowNum();
			
			POIFSFileSystem filePOI = new POIFSFileSystem(new FileInputStream("Perritos y Gatitos.xls"));
	 		workbook = new HSSFWorkbook(filePOI);	  
			
			System.out.println("Total de renglones (escribir): "+(sheet.getLastRowNum()+1));
			for (int i = 0; i < datos.size(); i++) {
				//crea el renglon 
	            HSSFRow dataRow = sheet.createRow(totalRenglones + (i+1));

	            //recupera los datos a escribir
	            String nombre = (String) datos.get(i)[0];
	            double edad = (double) datos.get(i)[1];

	            //crea nuevas celdas en el renglon nuevo y asigna los valores
	            dataRow.createCell(0).setCellValue(nombre);
	            dataRow.createCell(1).setCellValue(edad);
	           
	        }
			FileOutputStream archivoModificado=new FileOutputStream("Perritos y Gatitos.xls");//sobreescribe el archivo
	 		workbook.write(archivoModificado);
	 		workbook.close();
	 		
	 		System.out.println("Archivo guardado");
			
			
			
			
			
		}*/

}

