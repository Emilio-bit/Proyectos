package herencia;

import java.sql.Date;

import javax.swing.JOptionPane;

public class Persona {
	protected Date fechaNac;
	private Genero genero;
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
	public void imprimirdatos1() 
	{
		JOptionPane.showMessageDialog(null, "imprimir datos persona"
				                         +"genero"+genero
				                         +"nombre"+nombre);
	}

public Persona() {}

}
