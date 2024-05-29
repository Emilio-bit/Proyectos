package intefas;

import javax.swing.JOptionPane;

public class MySQL extends SMDB implements ConexionBD, RespaldoBD {
	
    public MySQL(String nombreBD, String usuario, String pasword, String url, String driver, String puerto) {
		super(nombreBD, usuario, pasword, url, driver, puerto);
		
	}

	public void conectar() 
    {
    	System.out.println("Cargando driver.....");
    	System.out.println("Conectando MySQL....");
    }
	
	public void desconectar() 
	{
		System.out.println("Desconectando MySQL....");
		
	}

	@Override
	public void generarRespaldo(String ruta) {
		System.out.println("Genendo respaldo de la BD en MySQL en la ruta: "+ruta);
		
	}
	
	public void Imprimirdatos() 
	{
		JOptionPane.showMessageDialog(null, "Mysql"+nombreBD
				                      +"\nusuario:"+usuario+"\ncontrasenia:"+pasword
				                      +"\nURL:"+url+"\ndriver:"+driver
				                      +"\npuerto:"+puerto);
	}

}
