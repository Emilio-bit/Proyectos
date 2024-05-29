package frida;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ValidacionFecha {
	private SimpleDateFormat formatoEntrada=new SimpleDateFormat("ddMMyyyy");
	
	//métodos
	public Date validarCadenaF(String fechaE) {
		Date fechaValida=null;
		Date fechaActual = new Date();
		String fechaE2=null;
		char fechaArray[]=null;
		int fechaArray2[]= {0,0,0};
		int v=0,i=0;
		fechaE2=fechaE;//Guarda los mismos valores en ambas variables (fechaE2 y fechaE)
		try {
			fechaValida=formatoEntrada.parse(fechaE);
		} catch(ParseException e) {
			fechaValida=null;//Asigna valor null a fechaValida
		}
		if(fechaValida==null)
			return fechaValida;//Devuelve fechaValida con valor null
		else {
			fechaArray=fechaE.toCharArray();//Pasa la fecha de entrada de tipo String a fechaArray un arreglo de caracteres
			if(fechaArray.length!=8) {
				fechaValida=null;//Asigna valor null a fechaValida
				return fechaValida;//Devuelve fechaValida con valor null
			}else {
				if(fechaE2.equals(fechaE)) {
					for(i=0;i<2;i++) {
						if(i==0)
							fechaArray2[i]=(10*Character.getNumericValue(fechaArray[i])+Character.getNumericValue(fechaArray[i+1]));
						else
							fechaArray2[i]=(10*Character.getNumericValue(fechaArray[i+1])+Character.getNumericValue(fechaArray[i+2]));
						}
						fechaArray2[i]=(1000*Character.getNumericValue(fechaArray[i+2]))+
						(100*Character.getNumericValue(fechaArray[i+3]))+
						(10*Character.getNumericValue(fechaArray[i+4]))+
						(Character.getNumericValue(fechaArray[i+5]));
					if(fechaArray2[1]<0||fechaArray2[1]>12) {
						fechaValida=null;
						return fechaValida;
					}
					else {
						switch(fechaArray2[1]) {
						case 1: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 2: if(fechaArray2[0]<=28 && fechaArray2[0]>0)
									v=1;
						break;
						case 3: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 4: if(fechaArray2[0]<=30 && fechaArray2[0]>0)
									v=1;
						break;
						case 5: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 6: if(fechaArray2[0]<=30 && fechaArray2[0]>0)
									v=1;
						break;
						case 7: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 8: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 9: if(fechaArray2[0]<=30 && fechaArray2[0]>0)
									v=1;
						break;
						case 10: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						break;
						case 11: if(fechaArray2[0]<=30 && fechaArray2[0]>0)
									v=1;
						default: if(fechaArray2[0]<=31 && fechaArray2[0]>0)
									v=1;
						}
						if(v==1) {
							if(fechaValida.before(fechaActual)){
								return fechaValida;
							}else {
								fechaValida=null;
								return fechaValida;
							}
						}else {
							fechaValida=null;
							return fechaValida;
						}
						
					}
				}else {
					fechaValida=null;
					return fechaValida;
				}

			}
		}

	}
}	
	
	
