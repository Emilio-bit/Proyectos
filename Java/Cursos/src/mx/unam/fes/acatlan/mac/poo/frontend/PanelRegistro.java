package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mx.unam.fes.acatlan.mac.poo.backend.Curso;
import mx.unam.fes.acatlan.mac.poo.backend.Profesor;

public class PanelRegistro extends JPanel implements ActionListener{
	
	private JLabel IbCursos;
	//private JComboBox<String> cbCurso;
	private JComboBox<Curso> cbCurso;
	
	private JLabel IbTutor;
	//private JComboBox<String> cbTutor;
	private JComboBox<Profesor> cbTutor;
	
	private JButton btnRegistraCurso;
	private JButton btnEliminarCurso;
	private JButton btnRegistraTutor;
	private JButton btnEliminarTutor;
	
	private JLabel lbTutorRegistrado;
	private JTextField txtTutorRegistrado;
	
	//etiqueta para mostrar cursos
	private JLabel lbCursoRegistrado;
	private JTextField txtCursoRegistrado;
	
	private final static String REGISTRAR_CURSO="REGISTRAR CURSO";
	private final static String ELIMINAR_CURSO="ELIMINAR CURSO";
	private final static String REGISTRAR_TUTOR="REGISTRAR TUTOR";
	private final static String ELIMINAR_TUTOR="ELIMINAR TUTOR";
	
	private InterfazAplicacionCurso ventanaPrincipal;
	
	
	public PanelRegistro(InterfazAplicacionCurso ventanaPrincipal) 
	{
		this.ventanaPrincipal=ventanaPrincipal;
		setLayout(null);
		//setLayout(new BorderLayout());
		TitledBorder border=BorderFactory.createTitledBorder("Registro a Cursos");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		IbCursos=new JLabel("Curso: ");
		IbTutor=new JLabel("Tutor: ");
		
		lbCursoRegistrado = new JLabel ("Curso inscrito:");
		lbTutorRegistrado = new JLabel ("Tutor inscrito");
		
		cbCurso=new JComboBox();
		cbCurso.setModel(new DefaultComboBoxModel(ventanaPrincipal.getCursos().toArray()));
		/*cbCurso.addItem("Curso 1");
		cbCurso.addItem("Curso 2");
		cbCurso.addItem("Curso 3");
		cbCurso.addItem("Curso 4");*/
		
	    cbTutor=new JComboBox();
	    cbTutor.setModel(new DefaultComboBoxModel(ventanaPrincipal.getTutores().toArray()));
	    /*cbTutor.addItem("Tutor 1");
	    cbTutor.addItem("Tutor 2");
	    cbTutor.addItem("Tutor 3");*/
	    
	    btnRegistraCurso=new JButton("Registar curso");
	    btnRegistraCurso.setActionCommand(REGISTRAR_CURSO);
	    btnRegistraCurso.addActionListener(this);
	    
	    btnEliminarCurso=new JButton("Eliminar Curso");
	    btnEliminarCurso.setActionCommand(ELIMINAR_CURSO);
	    btnEliminarCurso.addActionListener(this);
	    
	    btnRegistraTutor=new JButton("Registrar tutor");
	    btnRegistraTutor.setActionCommand(REGISTRAR_TUTOR);
	    btnRegistraTutor.addActionListener(this);
	    
	    btnEliminarTutor=new JButton("Eliminar tutor");
	    btnEliminarTutor.setActionCommand(ELIMINAR_TUTOR);
	    btnEliminarTutor.addActionListener(this);
	    
	    IbCursos.setBounds(5, 50, 50, 20);
	    cbCurso.setBounds(60, 50, 200, 20);
	    IbTutor.setBounds(5, 100, 500, 20);
	    cbTutor.setBounds(60, 100, 200, 20);
	    
	    btnRegistraCurso.setBounds(10, 150, 140, 20);
	    btnEliminarCurso.setBounds(160, 150, 140, 20);
	    btnRegistraTutor.setBounds(310, 150, 140, 20);
	    btnEliminarTutor.setBounds(460, 150, 140, 20);
	    
	    txtCursoRegistrado = new JTextField();
		txtCursoRegistrado.setEditable(false);
		txtCursoRegistrado.setBackground(Color.LIGHT_GRAY);
		txtCursoRegistrado.setForeground(Color.BLACK);
		
		//Creacion y configuracion de la zona de texto para el tutor registrado
		txtTutorRegistrado = new JTextField();
		txtTutorRegistrado.setEditable(false);
		txtTutorRegistrado.setBackground(Color.LIGHT_GRAY);
		txtTutorRegistrado.setForeground(Color.BLACK);
	    
		add(IbCursos);
		add(cbCurso);
		add(lbCursoRegistrado);
		add(txtCursoRegistrado);
		add(IbTutor);
		add(cbTutor);
		add(lbTutorRegistrado);
		add(txtTutorRegistrado);
		add(btnRegistraCurso);
		add(btnEliminarCurso);
		add(btnRegistraTutor);
		add(btnEliminarTutor);

	    

	    
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String nombreEvento=e.getActionCommand();
		if(nombreEvento.equals(REGISTRAR_CURSO))
		{
			Curso c=(Curso) cbCurso.getSelectedItem();
			ventanaPrincipal.agregarCurso(c);
		}else if(nombreEvento.equals(ELIMINAR_CURSO))
				{
			     ventanaPrincipal.borrarCurso();
	            }else if(nombreEvento.equals(REGISTRAR_TUTOR)) 
	            {
	            	Profesor p=(Profesor)cbTutor.getSelectedItem();
	            	ventanaPrincipal.registarTutor(p);
	            }else if(nombreEvento.equals(ELIMINAR_CURSO)) 
	            {
	            	ventanaPrincipal.borrarTutor();
	            }
		/*{
			JOptionPane.showMessageDialog(null, "clic registar curso");
		}else if(nombreEvento.equals(REGISTRAR_TUTOR)) 
		{
			JOptionPane.showMessageDialog(null, "clic registar tutor");
		}else if(nombreEvento.equals(ELIMINAR_TUTOR)) 
		{
			JOptionPane.showMessageDialog(null, "clic eliminar tutor");
		}else if(nombreEvento.equals(ELIMINAR_CURSO)) 
		{
			JOptionPane.showMessageDialog(null, "clic eliminar curso");
		}*/
	}
	public void actualizarCursos(Curso c) {
		if(c!=null) 
		txtCursoRegistrado.setText(c.getNombreCurso());
		else
			txtCursoRegistrado.setText("");
	}
	public void actualizarTutor(Profesor t) {
		if(t!=null)
		txtTutorRegistrado.setText(t.getNombre()+" "+t.getPaterno()+" "+t.getMaterno());
		else
			txtTutorRegistrado.setText("");
	}

}
