package intefas;

import javax.swing.JOptionPane;

public class SMDB extends Software{
	protected String nombreBD;
	protected String usuario;
	protected String pasword;
	protected String url;
	protected String driver;
	protected String puerto;
	public SMDB(String nombreBD, String usuario, String pasword, String url, String driver, String puerto) {
		this.nombreBD = nombreBD;
		this.usuario = usuario;
		this.pasword = pasword;
		this.url = url;
		this.driver = driver;
		this.puerto = puerto;
	}
	
	public void Imprimirdatos() 
	{
		JOptionPane.showMessageDialog(null, "imprimir datos de SMDB");
	}
	

}
