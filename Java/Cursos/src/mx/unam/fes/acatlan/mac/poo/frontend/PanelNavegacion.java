package mx.unam.fes.acatlan.mac.poo.frontend;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNavegacion extends JPanel implements ActionListener {
	
	private JButton btnSiguiente;
	private JButton btnAnterior;
	
	private final static String SIGUIENTE_CURSO="SIGUIENTE CURSO";
	private final static String ANTERIOR_CURSO="ANTERIOR CURSO";
	private InterfazAplicacionCurso ventanaPrincipal;
	public PanelNavegacion(InterfazAplicacionCurso ventanaPrincipal) 
	{
		this.ventanaPrincipal=ventanaPrincipal;
		setLayout(new FlowLayout());
		//setLayout(new BorderLayout());
		TitledBorder border=BorderFactory.createTitledBorder("Navegacion");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		btnSiguiente=new JButton(">");
		btnSiguiente.setActionCommand(SIGUIENTE_CURSO);
		btnSiguiente.addActionListener(this);
		
		btnAnterior=new JButton("<");
		btnAnterior.setActionCommand(ANTERIOR_CURSO);
		btnAnterior.addActionListener(this);
		
		add(btnAnterior);
		add(btnSiguiente);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombreEvento=e.getActionCommand();
		if(nombreEvento.equals(SIGUIENTE_CURSO)) 
		{
			ventanaPrincipal.siguiente();
		}
		else if(nombreEvento.equals(ANTERIOR_CURSO))
				{
			ventanaPrincipal.anterior();
				}
		/*{
			JOptionPane.showMessageDialog(null, "clic siguiente curso");
		}else if(nombreEvento.equals(ANTERIOR_CURSO)) 
		{
			JOptionPane.showMessageDialog(null, "clic anterior tutor");
		}*/
	}

}
