package util;

import java.util.ArrayList;

import negocio.Horario;

public class JsonHelper {

	public static String jsonToArray(ArrayList<Horario> listaHorario) {

		String jsonHorario = "[";

		for (int i = 0; i < listaHorario.size(); i++) {
			Horario horario = listaHorario.get(i);
			jsonHorario += horario.toString();
			if (i < listaHorario.size()-1) {
				jsonHorario += ",";
			}
		}
		jsonHorario += "]";
		return jsonHorario;
	}
}
