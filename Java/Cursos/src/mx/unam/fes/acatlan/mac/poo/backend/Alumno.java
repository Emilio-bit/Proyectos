package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;

public class Alumno extends Persona{
	private String foto;
	private String promedio;
	private String cuenta;
	private Curso curso;
	private Profesor profesor;
	
	public Alumno(Date fechaNac,Genero genero,String nombre,String paterno,String materno,String foto,String promedio,String cuenta
			      ,Curso curso,Profesor profesor) 
	{
		super(fechaNac,genero,nombre,paterno,materno);
		this.foto=foto;
		this.promedio=promedio;
		this.cuenta=cuenta;
		this.curso=curso;
		this.profesor=profesor;
	}
	

	


	public Alumno(String string, String string2, String string3, String string4, String string5, String string6,
			Genero femenino, Date date) {
		// TODO Auto-generated constructor stub
	}


	public String getFoto() 
	{
		return foto;
	}
	public void setFoto(String foto) 
	{
		this.foto=foto;
	}
	public String getPromedio() 
	{
		return promedio;
	}
	public void setPromedio(String promedio) 
	{
		this.promedio=promedio;
	}
	public String getCuenta() 
	{
		return cuenta;
	}
	public void setCuenta(String cuenta) 
	{
		this.cuenta=cuenta;
	}
	public Curso getCurso() 
	{
		return curso;
	}
	public void setCurso(Curso curso) 
	{
		this.curso=curso;
	}
	public Profesor getProfesor() 
	{
		return profesor;
	}
	public void setProfesor(Profesor profesor) 
	{
		this.profesor=profesor;
	}
	public void registarCurso(Curso curso) 
	{
		this.curso=curso;
	}
	public void eliminarCurso() 
	{
		curso=null;
	}
	public void  agregarTutor(Profesor profesor) 
	{
		this.profesor=profesor;
	}
	public void eliminarTutor() 
	{
		profesor=null;
	}

}
