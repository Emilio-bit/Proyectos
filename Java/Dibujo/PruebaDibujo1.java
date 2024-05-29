package Dibujo;
import java.awt.Color;
//Ramirez Almazan Emilio
import javax.swing.JFrame;
public class PruebaDibujo1 {

	public static void main(String[] args) throws InterruptedException
	{
		Dib panel = new Dib(); //declaracion de metodo
	    JFrame aplicacion = new JFrame();
	    aplicacion.getContentPane().add(panel);
	    aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    aplicacion.add( panel );
	    aplicacion.setSize(900, 900);      
	    aplicacion.setVisible( true );

	}

}
