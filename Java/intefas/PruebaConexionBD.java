package intefas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PruebaConexionBD {

	public static void main(String[] args) {
		ArrayList<SMDB> manejadores=new ArrayList<>();
		
		ArrayList<MySQL> mysqlTmp=new ArrayList<>();
		MySQL mysql=new MySQL("nuevo MySQL", "usuario", "contrasenia", "url", "driver", "puerto");
		mysqlTmp.add(mysql);
		manejadores.add(mysql);
		
		ArrayList<PostgreSQL> postgresqlTmp=new ArrayList<>();
		PostgreSQL postgresql=new PostgreSQL("nuevo PostgreSQL", "usuario", "contrasenia", "url", "driver", "puerto");
		postgresqlTmp.add(postgresql);
		manejadores.add(postgresql);
		
		for(SMDB temporal: manejadores) 
		{
			temporal.Imprimirdatos();
			
			if(temporal instanceof MySQL) 
			{
				JOptionPane.showMessageDialog(null, "es un MySQL");
			}
			else if(temporal instanceof PostgreSQL) 
			{
				JOptionPane.showMessageDialog(null, "es un PostgreSQL");
			}
			else if(temporal instanceof SMDB) 
			{
				JOptionPane.showMessageDialog(null, "es un SMDB");
			}
			else if(temporal instanceof Software) 
			{
				JOptionPane.showMessageDialog(null, "es un Software");
			}
		}
		
		

	}

}
