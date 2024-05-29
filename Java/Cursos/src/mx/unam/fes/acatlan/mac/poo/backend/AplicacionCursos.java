package mx.unam.fes.acatlan.mac.poo.backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AplicacionCursos {
	private Integer posicionAlumnoActual;
	private ArrayList<Curso> cursos;
	private ArrayList<Profesor> profesores;
	private ArrayList<Alumno> alumnos;
	
	public AplicacionCursos(Integer posicionAlumnoActual,ArrayList<Profesor> profesores, ArrayList<Alumno> alumnos, ArrayList<Curso> cursos ) {
		this.posicionAlumnoActual=posicionAlumnoActual;
		this.profesores=profesores;
		this.alumnos=alumnos;
		this.cursos=cursos;
	}
	
	public AplicacionCursos() 
	{
		cursos=new ArrayList<Curso>();
		
		Curso cursoTmp=new Curso(101,100,"programacion 1");
		cursos.add(cursoTmp);
		cursoTmp=new Curso(102,90,"disenio 1");
		cursos.add(cursoTmp);
		cursoTmp=new Curso(103,80,"programacion 2");
		cursos.add(cursoTmp);
		cursoTmp=new Curso(104,50,"redes");
		cursos.add(cursoTmp);
		cursoTmp=new Curso(105,65,"disenio de bases de datos");
		cursos.add(cursoTmp);
		
		profesores=new ArrayList<Profesor>();
		
		Profesor profesorTmp= new Profesor(100, "hvo764", new Date(),Genero.FEMENINO,"Dyana Erika", "Marron", "Luna" );
		profesores.add(profesorTmp);
		
		profesorTmp=new Profesor(48, "hwg478", new Date(),Genero.MASCULINO,"Miguel Angel", "Guadarrama", "Garcia");
		profesores.add(profesorTmp);
		
		profesorTmp=new Profesor(87, "may844", new Date(),Genero.MASCULINO,"Eduardo Eloy", "Loza", "Pacheco");
		profesores.add(profesorTmp);
		
		profesorTmp=new Profesor(99, "pow987", new Date(),Genero.MASCULINO,"Enrique", "Espinoza", "Loyola");
		profesores.add(profesorTmp);
		
		profesorTmp=new Profesor(99, "lkn159", new Date(),Genero.FEMENINO,"Mayra", "Olguin", "Rosas");
		profesores.add(profesorTmp);
		
		
		
	    //Profesor profesorTmp=new Profesor("mujer.jpg","")
		
		alumnos=new ArrayList<Alumno>();
		
		Alumno alumnoTmp=new Alumno("mujer.jpg","101010","9","karla","Romero","Cruz",Genero.FEMENINO,new Date());
		alumnos.add(alumnoTmp);
		
		alumnoTmp=new Alumno("hombre.jpg","101011","8","Ignacio","Luna","Rojas",Genero.MASCULINO,new Date());
		alumnos.add(alumnoTmp);
		
		alumnoTmp=new Alumno("hombre.jpg","101012","8.5","Miguel","Rivas","Moreno",Genero.MASCULINO,new Date());
		alumnos.add(alumnoTmp);
		
		alumnoTmp=new Alumno("mujer.jpg","101020","7.5","Elena","Lemus","Galvan",Genero.FEMENINO,new Date());
		alumnos.add(alumnoTmp);
		
	}
	
	public Integer getPosicionAlumnoActual() 
	{
		return posicionAlumnoActual;
	}
	public void setPosicionAlumnoActual(Integer posicionAlumnoActual) 
	{
		this.posicionAlumnoActual=posicionAlumnoActual;
	}
	public ArrayList<Curso> getCursos()
	{
		return cursos;
	}
	public void setCursos(ArrayList<Curso> cursos) 
	{
		this.cursos=cursos;
	}
	public ArrayList<Profesor> getProfesores() 
	{
		return profesores;
	}
	public void setProfesores(ArrayList<Profesor> profesores) 
	{
		this.profesores=profesores;
	}
	public ArrayList<Alumno> getAlumnos()  
	{
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) 
	{
		this.alumnos=alumnos;
	}
	
	public Alumno getAlumnoActual() 
	{
		if(alumnos.size()>0)
			return alumnos.get(posicionAlumnoActual);
		else
			return null; 
	}
	public Alumno getAlumnoSiguiente() 
	{
		if(posicionAlumnoActual==alumnos.size()-1) {
			posicionAlumnoActual=0;
			return alumnos.get(0);
			
		}
		else
			return alumnos.get(++posicionAlumnoActual);
	}
	
	
	public AplicacionCursos(Integer posicionAlumnoActual) 
	{
		this.posicionAlumnoActual=posicionAlumnoActual;
	}

	public Alumno getAlumnoanterior() {
		if(posicionAlumnoActual==0) {
			posicionAlumnoActual=alumnos.size()-1;
			return alumnos.get(alumnos.size()-1);
			
		}
		else
			return alumnos.get(--posicionAlumnoActual);
		
	}
	
	

}