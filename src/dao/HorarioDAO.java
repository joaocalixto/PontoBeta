package dao;

import java.io.File;
import java.util.ArrayList;

import negocio.Horario;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class HorarioDAO {

	public void inserirHorario(Horario horario) {

		ObjectContainer db = Db4o.openFile("database.db");

		try {
			db.store(horario);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
	}

	public ArrayList<Horario> listarHorarios() {
		Horario horario = new Horario(null, null, null, null, null, null);
		ObjectContainer db = null;
		ArrayList<Horario> arrayList = new ArrayList<Horario>();
		try {
			db = Db4o.openFile("database.db");
			ObjectSet result = db.queryByExample(horario);

			for (Object object : result) {
				Horario h = (Horario) object;
				arrayList.add(h);
			}

		} finally {
			db.close();
		}
		return arrayList;
	}

	public Horario getHorarioDia(String dia) {
		Horario horario = new Horario();
		horario.setDdMMyyyy(dia);
		ObjectContainer db = null;

		Horario Hararioretorno = null;
		try {
			db = Db4o.openFile("database.db");
			ObjectSet result = db.queryByExample(horario);

			Hararioretorno = (Horario) result.next();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}

		return Hararioretorno;
	}
	
	public Horario getHorarioDia(String dia, String usuario) {
		Horario horario = new Horario();
		horario.setDdMMyyyy(dia);
		ObjectContainer db = null;

		Horario Hararioretorno = null;
		try {
			db = Db4o.openFile("database.db");
			ObjectSet result = db.queryByExample(horario);

			for (Object object : result) {
				Horario h = (Horario) object;
				
				if(h.getUsuario() != null){
					if(h.getUsuario().equalsIgnoreCase(usuario)){
						return h;
					}
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}

		return Hararioretorno;
	}


	public void atualizarHorario(String dia, Horario horario) {

		ObjectContainer db = null;
		Horario Hararioretorno = null;
		try {
			db = Db4o.openFile("database.db");
			Horario query = new Horario();
			query.setDdMMyyyy(dia);
			query.setUsuario(horario.getUsuario());

			ObjectSet result = db.queryByExample(query);
			Horario hAntigo = (Horario) result.next();

			hAntigo.setHoraAlmoco(horario.getHoraAlmoco());
			hAntigo.setHoraEntrada(horario.getHoraEntrada());
			hAntigo.setHoraSaida(horario.getHoraSaida());
			hAntigo.setHoraVoltaAlmoco(horario.getHoraVoltaAlmoco());

			db.store(hAntigo);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}

	}

	public void deleteAll() {

		ObjectContainer db = null;
		Horario Hararioretorno = null;
		try {
			db = Db4o.openFile("database.db");
			ObjectSet objects = db.queryByExample(null);
			for (Object object : objects) {
				db.delete(object);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
	}

	public static void main(String[] args) {
		Horario horario = new Horario();

		horario.setDdMMyyyy("09/05/2014");

		HorarioDAO dao = new HorarioDAO();
		dao.deleteAll();

		System.out.println("Depois-------");
		ArrayList<Horario> listarHorarios = dao.listarHorarios();

		for (Horario horario2 : listarHorarios) {
			System.out.println(horario2);
		}

	}

}
