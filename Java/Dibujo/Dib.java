package Dibujo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;
//Ramirez Almazan Emilio
@SuppressWarnings("serial")

public class Dib extends JPanel {
	public void paintComponent( Graphics g ){	   
	super.paintComponent( g );
	//forma mascara
	int x[]= {427,499,597,660,681,600,498,400,297,200,140,139,198,299,367};//coordenadas tomadas de geogebra
	int y[]= {200,163,155,200,280,400,478,516,476,400,290,199,158,163,200};
	Polygon poligono=new Polygon(x,y,15);//se hace un poligono
	 g.drawPolygon(poligono);
	 g.setColor(Color.magenta);
     g.fillPolygon(poligono);
    
     //cuernos
     int x1[]= {552,499,597};
     int y1[]= {55,163,155}; //coordenadas tomadas de geogebra
     int x2[]= {250,198,299};
     int y2[]= {55,158,163};
     Polygon poligono1=new Polygon(x1,y1,3);//por cada cuerno se hace un nuevo poligono
     Polygon poligono3=new Polygon(x2,y2,3);
     g.drawPolygon(poligono1);
     g.drawPolygon(poligono3);
     g.setColor(Color.yellow);
     g.fillPolygon(poligono1);//se colorea despues de ser dibujado
     g.fillPolygon(poligono3);
     
     //cuernos de lados
     int x3[]= {754,681,600};
     int y3[]= {399,285,400};//cuernos de la derecha
     int x4[]= {657,600,498};//coordenadas tomadas de geogebra
     int y4[]= {502,400,478};
     Polygon poligono4=new Polygon(x3,y3,3);
     Polygon poligono5=new Polygon(x4,y4,3);
     g.drawPolygon(poligono4);
     g.drawPolygon(poligono5);
     g.setColor(Color.yellow);
     g.fillPolygon(poligono4);
     g.setColor(Color.red);
     g.fillPolygon(poligono5);
     
     
     int x5[]= {81,140,200};
     int y5[]= {397,278,400};//cuernos izquierda
     int x6[]= {139,200,297};//coordenadas tomadas de geogebra
     int y6[]= {499,400,476};
     Polygon poligono6=new Polygon(x5,y5,3);
     Polygon poligono7=new Polygon(x6,y6,3);
     g.drawPolygon(poligono6);
     g.drawPolygon(poligono7);
     g.setColor(Color.red);
     g.fillPolygon(poligono7);
     g.setColor(Color.yellow);
     g.fillPolygon(poligono6);
     
     //ojos
     g.setColor(Color.yellow);;
     g.fillOval(230, 220, 135, 135);//coordenadas tomadas de geogebra
     g.fillOval(450, 220, 135, 135);
     
     //puntos de ojos
     g.setColor(Color.green);
     g.fillOval(275, 265, 40, 40);//coordenadas tomadas de geogebra
     g.fillOval(500, 265, 40, 40); 
     g.setColor(Color.black);
     g.fillOval(290, 280, 10, 10);
     g.fillOval(515, 280, 10, 10);
     
     //marcas
     g.setColor(Color.black);
     int x7[]= {260,360,300,260};
     int y7[]= {445,340,355,345};//poligonos de la izquierda
     int x8[]= {169,265,235,227};
     int y8[]= {342,350,320,290};//coordenadas tomadas de geogebra
     int x9[]= {168,230,245,280};
     int y9[]= {176,300,235,220};
     Polygon poligono8=new Polygon(x7,y7,4);
     Polygon poligono9=new Polygon(x8,y8,4);
     Polygon poligono10=new Polygon(x9,y9,4);
     g.fillPolygon(poligono8);
     g.fillPolygon(poligono9);
     g.fillPolygon(poligono10);
     
     int x10[]= {538,460,520,565};
     int y10[]= {450,330,357,340};//figuras de la derecha
     int x11[]= {638,565,585,585};
     int y11[]= {342,340,315,270};
     int x12[]= {624,585,570,520};//coordenadas tomadas de geogebra
     int y12[]= {170,284,236,220};
     Polygon poligono11=new Polygon(x10,y10,4);
     Polygon poligono12=new Polygon(x11,y11,4);
     Polygon poligono13=new Polygon(x12,y12,4);
     g.fillPolygon(poligono11);
     g.fillPolygon(poligono12);
     g.fillPolygon(poligono13);
     
     //puntos de la mascara
     g.fillOval(390, 210, 10, 10);
     g.fillOval(410, 210, 10, 10); 
     g.fillOval(390, 230, 10, 10);
     g.fillOval(410, 230, 10, 10); 
     g.fillOval(390, 250, 10, 10);//coordenadas tomadas de geogebra
     g.fillOval(410, 250, 10, 10); 
     
     g.fillOval(390, 300, 15, 15);
     g.fillOval(410, 300, 15, 15); 
     g.fillOval(390, 400, 15, 15);
     g.fillOval(410, 400, 15, 15); 
     g.fillOval(390, 420, 15, 15);//coordenadas tomadas de geogebra
     g.fillOval(410, 420, 15, 15); 
     g.fillOval(390, 440, 15, 15);
     g.fillOval(410, 440, 15, 15); 
     g.fillOval(390, 460, 15, 15);
     g.fillOval(410, 460, 15, 15);
     
     g.drawString("MAJORA'S MASK", 360, 550);//nombre del titulo
     
	}

}
