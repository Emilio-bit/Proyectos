package intefas;

import javax.swing.JOptionPane;

public class PostgreSQL extends SMDB implements ConexionBD {

	public PostgreSQL(String nombreBD, String usuario, String pasword, String url, String driver, String puerto) {
		super(nombreBD, usuario, pasword, url, driver, puerto);
	}

	@Override
	public void conectar() {
		
		System.out.println("Cargando driver.....");
    	System.out.println("Conectando PostgreSQL....");

	}

	@Override
	public void desconectar() {
		System.out.println("Desconectando PostgreSQK....");

	}
	
	public void Imprimirdatos() 
	{
		JOptionPane.showMessageDialog(null, "Mysql"+nombreBD
				                      +"\nusuario:"+usuario +"\ncontrasenia:"+pasword
				                      +"\nURL:"+url +"\ndriver:"+driver
				                      +"\npuerto:"+puerto);
	}


}
