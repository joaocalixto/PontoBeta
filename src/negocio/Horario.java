package negocio;

import org.joda.time.DateTime;

import util.ObjectHelper;
import util.StringHelper;

public class Horario {

	private DateTime horaEntrada;
	private DateTime horaAlmoco;
	private DateTime horaVoltaAlmoco;
	private DateTime horaSaida;
	private String ddMMyyyy;
	private String usuario;

	public Horario(DateTime horaEntrada, DateTime horaAlmoco, DateTime horaVoltaAlmoco, DateTime saida, String ddMMyyyy, String usuario) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaAlmoco = horaAlmoco;
		this.horaVoltaAlmoco = horaVoltaAlmoco;
		this.horaSaida = saida;
		this.ddMMyyyy = ddMMyyyy;
		this.usuario = usuario;
	}

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(DateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public DateTime getHoraAlmoco() {
		return horaAlmoco;
	}

	public void setHoraAlmoco(DateTime horaAlmoco) {
		this.horaAlmoco = horaAlmoco;
	}

	public DateTime getHoraVoltaAlmoco() {
		return horaVoltaAlmoco;
	}

	public void setHoraVoltaAlmoco(DateTime horaVoltaAlmoco) {
		this.horaVoltaAlmoco = horaVoltaAlmoco;
	}

	public DateTime getHoraSaida() {
		return this.horaSaida;
	}

	public void setHoraSaida(DateTime saida) {
		this.horaSaida = saida;
	}

	public String getDdMMyyyy() {
		return ddMMyyyy;
	}

	public void setDdMMyyyy(String ddMMyyyy) {
		this.ddMMyyyy = ddMMyyyy;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {

		return "{\"dia\":" + StringHelper.aspasDuplas + this.ddMMyyyy + StringHelper.aspasDuplas + " , " + StringHelper.aspasDuplas
				+ "usuario" + StringHelper.aspasDuplas + ":" + StringHelper.aspasDuplas + this.usuario + StringHelper.aspasDuplas + ", "
				+ StringHelper.aspasDuplas + "horaEntrada" + StringHelper.aspasDuplas + ":"
				+ StringHelper.aspasDuplas+ ObjectHelper.returnEmptyOrHour(this.horaEntrada) +StringHelper.aspasDuplas+ ", "+StringHelper.aspasDuplas+"horaSaida"+StringHelper.aspasDuplas+":"+StringHelper.aspasDuplas+"" + ObjectHelper.returnEmptyOrHour(this.horaSaida)+StringHelper.aspasDuplas+
				", "+StringHelper.aspasDuplas+"horaVoltaAlmoco"+StringHelper.aspasDuplas+":" + StringHelper.aspasDuplas+ObjectHelper.returnEmptyOrHour(this.horaVoltaAlmoco) + StringHelper.aspasDuplas+", "+StringHelper.aspasDuplas+"horaAlmoco"+StringHelper.aspasDuplas+":"
				+ StringHelper.aspasDuplas+ObjectHelper.returnEmptyOrHour(this.horaAlmoco) +StringHelper.aspasDuplas+ "}";
	}

}
