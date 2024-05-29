package herencia;

import javax.swing.JOptionPane;

public class Alumno extends Persona{
	private String foto;
	private String promedio;
	private String cuenta;
	
	/*public Alumno(String foto,String promedio,String cuenta) 
	{
		this.foto=foto;
		this.promedio=promedio;
		this.cuenta=cuenta;
	}*/
	public void imprimirdatos1() 
	{
		JOptionPane.showMessageDialog(null, "imprimir datos persona"
				                      +"\ncuenta"+cuenta
				                      +"\npromedio"+promedio);
		super.imprimirdatos1();
	}
	public String getFoto() 
	{
		return foto;
	}
	public void setFoto(String foto) 
	{
		this.foto=foto;
	}
	public String getPromedio() 
	{
		return promedio;
	}
	public void setPromedio(String promedio) 
	{
		this.promedio=promedio;
	}
	public String getCuenta() 
	{
		return cuenta;
	}
	public void setCuenta(String cuenta) 
	{
		this.cuenta=cuenta;
	}
	
	

}
