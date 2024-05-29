package kirby;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Dibujo extends JPanel{
	
	   public void paintComponent( Graphics g ){	   
	      super.paintComponent( g );    
	          
	    // Cuerpo
	      g.setColor(Color.pink);
	       g.fillOval(100, 100, 200, 200);
	     g.setColor(Color.black);   //contorno
	       g.drawOval(100, 100, 200, 200);
	       
	   /*Ojos
	         g.fillOval(160, 130, 28, 70);
	          g.fillOval(210, 130, 28, 70);
	               
	     //detalles de los ojos         
	      g.setColor(Color.white);
	       g.fillOval(166, 135, 15, 28);
	        g.fillOval(216, 135, 15, 28);
	        g.setColor(Color.blue);
	       g.fillOval(165, 169, 16, 27);
	        g.fillOval(215, 169, 16, 27);
	      g.setColor(Color.black);
	       g.fillOval(164, 169, 18, 20);
	        g.fillOval(214, 169, 18, 20);  
	       
	      // mejillas??
	        g.setColor(Color.red);
	       g.fillOval(135, 192, 30,18);
	        g.fillOval(232, 192, 30,18);
	         g.setColor(Color.black); //contorno
	        g.drawOval(135, 192, 30,18);
	         g.drawOval(232, 192, 30,18);
	         
	       //boca
	      g.setColor(Color.black);
	       g.fillOval(185, 190, 30,40);
	      
	       //detalle de la boca
	      g.setColor(Color.pink);
	       g.fillRect(185, 190, 30, 15);
	      
	      //Lengua
	      g.setColor(Color.red);
	       g.fillOval(188, 213, 24,17);
	      g.setColor(Color.black); //contorno
	       g.drawOval(188, 213, 24,17);*/
	       
	     
	   } 
	} 
