package negocio;

import java.util.Date;

public class Horario {
	
	public Date horario;
	
	public EnumTipoHorario tipoHorario;

	public Horario(Date horario, EnumTipoHorario tipoHorario) {
		super();
		this.horario = horario;
		this.tipoHorario = tipoHorario;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public EnumTipoHorario getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(EnumTipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	
}
