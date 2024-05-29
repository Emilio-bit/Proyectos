package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class Persona {
	protected Date fechaNac;
	protected Genero genero;
	protected String nombre;
	protected String paterno;
	protected String materno;
	
	public Persona(Date fechaNac,Genero genero,String nombre,String paterno,String materno) 
	{
		this.fechaNac=fechaNac;
		this.genero=genero;
		this.nombre=nombre;
		this.paterno=paterno;
		this.materno=materno;
	}
	
	public void imprimirdatos() 
	{
		
	}
	public Date getFechaNac() 
	{
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) 
	{
		this.fechaNac=fechaNac;
	}
	public Genero getGenero() 
	{
		return genero;
	}
	public void setGenero(Genero genero) 
	{
		this.genero=genero;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre=nombre;
	}
	public String getPaterno() 
	{
		return paterno;
	}
	public void setPaterno(String paterno) 
	{
		this.paterno=paterno;
	}
	public String getMaterno() 
	{
		return materno;
	}
	public void setMaterno(String materno) 
	{
		this.materno=materno;
	}
	public void imprimirDatos() 
	{
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		String datos="Nombre:"+nombre+"\nApellido:"+paterno+materno+"\ngenero:"+genero+"\nfecha nacimiento"+format.format(fechaNac);
		JOptionPane.showMessageDialog(null, datos);
		
	}
	@Override
	public String toString() 
	{
		return nombre+" "+paterno+" "+materno;
	}
	public Persona() {}
	
	

}
