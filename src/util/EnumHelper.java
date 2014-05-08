package util;

import negocio.EnumTipoHorario;

public class EnumHelper {
	
	
	public static EnumTipoHorario getENUM(String vString){
		
		EnumTipoHorario[] values = EnumTipoHorario.values();
		
		for (EnumTipoHorario enumTipoHorario : values) {
			
			if(vString.endsWith(enumTipoHorario.toString())){
				return enumTipoHorario;
			}
		}
		
		return null;
	}

}
