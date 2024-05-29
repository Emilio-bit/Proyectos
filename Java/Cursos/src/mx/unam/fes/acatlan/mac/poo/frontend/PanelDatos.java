package mx.unam.fes.acatlan.mac.poo.frontend;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import mx.unam.fes.acatlan.mac.poo.backend.Alumno;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PanelDatos extends JPanel {
	//nombre
	private JLabel lbNombre;
	private JTextField txtNombre;
	//paterno
	private JLabel lbPaterno;
	private JTextField txtPaterno;
	//materno
	private JLabel lbMaterno;
	private JTextField txtMaterno;
	//nacimiento
	private JLabel lbFechaNac;
	private JTextField txtFechaNac;
	//genero
	private JLabel lbGenero;
	private JTextField txtGenero;
	
	//etiqueta mostrar imagen
	private JLabel IbImagen;
	
	public PanelDatos() 
	{
		setLayout(new BorderLayout());
		TitledBorder border=BorderFactory.createTitledBorder("Datos Alumno");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//foto e info de alumno
		JPanel panelDatosAlumno=new JPanel();
		JPanel panelFotoAlumno=new JPanel();
		
		//agregar y acomodar
		add(panelDatosAlumno,BorderLayout.CENTER);
		add(panelFotoAlumno,BorderLayout.EAST);
		
		//crear etiquetas
		lbNombre=new JLabel("Nombre: ");
		lbPaterno=new JLabel("Apellido Paterno: ");
		lbMaterno=new JLabel("Apellido Materno: ");
		lbGenero=new JLabel("Sexo: ");
		lbFechaNac=new JLabel("Fecha de Nacimiento: ");
		
		//configuracion nombre
		txtNombre=new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setForeground(Color.BLUE);
		
		//configuracion paterno
		txtPaterno=new JTextField();
		txtPaterno.setEditable(false);
		txtPaterno.setBackground(Color.LIGHT_GRAY);
		txtPaterno.setForeground(Color.BLUE);
		
		//configuracion materno
		txtMaterno=new JTextField();
		txtMaterno.setEditable(false);
		txtMaterno.setBackground(Color.LIGHT_GRAY);
		txtMaterno.setForeground(Color.BLUE);
		
		//configuracion genero
		txtGenero=new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setBackground(Color.LIGHT_GRAY);
		txtGenero.setForeground(Color.BLUE);
		
		//configuracion fecha de nacimiento
		txtFechaNac=new JTextField(10);
		txtFechaNac.setEditable(false);
		txtFechaNac.setBackground(Color.LIGHT_GRAY);
		txtFechaNac.setForeground(Color.BLUE);
		
		//distribuidor grafico
		panelDatosAlumno.setLayout(new GridLayout(7,2));
		
		//se agregan al paneldatosalumno
		panelDatosAlumno.add(lbNombre);
		panelDatosAlumno.add(txtNombre);
		panelDatosAlumno.add(lbPaterno);
		panelDatosAlumno.add(txtPaterno);
		panelDatosAlumno.add(lbMaterno);
		panelDatosAlumno.add(txtMaterno);
		panelDatosAlumno.add(lbGenero);
		panelDatosAlumno.add(txtGenero);
		panelDatosAlumno.add(lbFechaNac);
		panelDatosAlumno.add(txtFechaNac);
		
		//etiqueta mostrar foto
		IbImagen=new JLabel("FOTO ALUMNO");
		//agregar al panel la foto
		panelFotoAlumno.add(IbImagen);
		
		
	}
	public void actualizarPanel(Alumno a) 
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		txtNombre.setText(a.getNombre());
		txtPaterno.setText(a.getPaterno());
		txtMaterno.setText(a.getMaterno());
		txtGenero.setText(a.getGenero().toString());
		txtFechaNac.setText(sdf.format(a.getFechaNac()));
		
		ImageIcon imagenOriginal = new ImageIcon(cargarPropiedad("rutaFotos")+a.getFoto());//para imagenes dinamicas que el usuario cargue fuera del jar
		//ImageIcon imagenOriginal=new ImageIcon("Fotos/"+a.getFoto());
		Image imagenAjustada=imagenOriginal.getImage().getScaledInstance(90, 100, Image.SCALE_SMOOTH);
		IbImagen.setText("");
		IbImagen.setIcon(new ImageIcon(imagenAjustada));
		
	}
	public String cargarPropiedad(String propiedad) {
    	Properties propiedades = new Properties();
    	InputStream is;
    	String valor="";
    	
		try {
			is=ClassLoader.getSystemResourceAsStream("mx/unam/fes/acatlan/mac/poo/backend/configuracion/configuracion.properties");
			propiedades.load(is);
			is.close();
			is = null;
			
			valor=propiedades.getProperty(propiedad);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 	valor;    	
    }

}
