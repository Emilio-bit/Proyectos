package frida;

public class Domicilio {
	public String calle ;
	public String  colonia;
	public String numero;
	public String cp;
	
	//Contructor por defecto
	public Domicilio(){
	}	
	//Setters y Getters
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}

	
	
}
