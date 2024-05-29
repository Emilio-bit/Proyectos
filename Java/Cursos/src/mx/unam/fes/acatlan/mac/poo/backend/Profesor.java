package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;

public class Profesor extends Persona{
	private Integer noTrabajador;
	private String celula;
	
	public Profesor(Integer noTrabajador,String celula,Date fechaNac,Genero genero,String nombre,String paterno,String materno) 
	{
		super(fechaNac,genero,nombre,paterno,materno);
		this.noTrabajador=noTrabajador;
		this.celula=celula;
	}
	public Integer getNoTrabajador() 
	{
		return noTrabajador;
	}
	public void setNoTrabajador(Integer noTrabajador) 
	{
		this.noTrabajador=noTrabajador;
	}
	public String getCelula() 
	{
		return celula;
	}
	public void setCelula(String celula) 
	{
		this.celula=celula;
	}

}
