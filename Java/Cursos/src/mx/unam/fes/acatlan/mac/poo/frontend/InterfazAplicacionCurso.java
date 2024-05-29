package mx.unam.fes.acatlan.mac.poo.frontend;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mx.unam.fes.acatlan.mac.poo.backend.Alumno;
import mx.unam.fes.acatlan.mac.poo.backend.AplicacionCursos;
import mx.unam.fes.acatlan.mac.poo.backend.Curso;
import mx.unam.fes.acatlan.mac.poo.backend.Profesor;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class InterfazAplicacionCurso extends JFrame{
	//panel alumno
	private PanelDatos panelDatos;
	//panel registro
	private PanelRegistro panelRegistro;
	//panel navegacion
	private PanelNavegacion panelNavegacion;
	
	private AplicacionCursos aplicacionCursos;

	public InterfazAplicacionCurso() 
	{
		setTitle("aplicacion Curso");
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		//crear paneles
		panelDatos=new PanelDatos();
		panelRegistro=new PanelRegistro(this);
		panelNavegacion=new PanelNavegacion(this);
		
		//organiza paneles
		add(panelDatos,BorderLayout.NORTH);
		add(panelRegistro,BorderLayout.CENTER);
		add(panelNavegacion,BorderLayout.SOUTH);

		mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());
		
		
	}
	public void mostrarInformacionAlumno(Alumno alu) 
	{
		panelDatos.actualizarPanel(alu);
	}
	public void mostrarInformacionCursos(Curso curso) {
		panelRegistro.actualizarCursos(curso);
	}
	public void mostrarInformacionTutor(Profesor tut) {
		panelRegistro.actualizarTutor(tut);
	}
	public void siguiente() 
	{
		Alumno alumno=aplicacionCursos.getAlumnoSiguiente();
		mostrarInformacionAlumno(alumno);
		mostrarInformacionCursos(alumno.getCurso());
		mostrarInformacionTutor(alumno.getProfesor());
	}
public void anterior() 
	{
		Alumno alumno=aplicacionCursos.getAlumnoanterior();
		mostrarInformacionAlumno(alumno);
		mostrarInformacionCursos(alumno.getCurso());
		mostrarInformacionTutor(alumno.getProfesor());
	}
	public void agregarCurso(Curso curso) 
	{
		JOptionPane.showMessageDialog(this, "se registra curso"+curso.toString());
		aplicacionCursos.getAlumnoActual().registarCurso(curso);
	}
	public void registarTutor(Profesor prof) 
	{
		JOptionPane.showMessageDialog(this, "se registra tutor"+prof.toString());
		aplicacionCursos.getAlumnoActual().agregarTutor(prof);
	}
	public void borrarCurso() 
	{
		aplicacionCursos.getAlumnoActual().eliminarCurso();
		mostrarInformacionCursos(null);
		
	}
	public void borrarTutor() 
	{
		aplicacionCursos.getAlumnoActual().eliminarTutor();
		mostrarInformacionTutor(null);
		
	}
	public ArrayList<Curso> getCursos()
	{
		return aplicacionCursos.getCursos();
	}
	public ArrayList<Profesor> getTutores()
	{
		return aplicacionCursos.getProfesores();
	}
	
	public static void main(String[] args) {
		InterfazAplicacionCurso interfaz =new InterfazAplicacionCurso();
		interfaz.setVisible(true);

	}

}