package dao;

import java.util.ArrayList;
import java.util.Date;

import negocio.EnumTipoHorario;
import negocio.Horario;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class HorarioDAO {

	public void inserirHorario(Horario horario) {

		ObjectContainer db = Db4o.openFile("database");

		try {
			db.store(horario);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
			System.out.println("Arqivo fechado");
		}
		System.out.println("Inserido com sucesso");
	}

	public ArrayList<Horario> listarHorarios() {
		Horario horario = new Horario(null, null);
		ObjectContainer db = null;
		ArrayList<Horario> arrayList = new ArrayList<Horario>();
		try {
			db = Db4o.openFile("database");
			ObjectSet result = db.queryByExample(horario);

			for (Object object : result) {
				Horario h = (Horario) object;
				arrayList.add(h);
			}

		} finally {
			db.close();
			System.out.println("Arqivo fechado");
		}
		return arrayList;
	}

	public static void main(String[] args) {
		Horario horario = new Horario(new Date(), EnumTipoHorario.ENTRADA);

		// inserirHorario(horario);
		// listarHorarios();
	}

}
