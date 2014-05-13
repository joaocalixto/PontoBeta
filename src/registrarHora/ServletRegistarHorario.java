package registrarHora;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EnumTipoHorario;
import negocio.Horario;

import org.joda.time.DateTime;

import util.DateHelper;
import util.EnumHelper;
import util.JsonHelper;
import util.ServletHelper;
import dao.HorarioDAO;

/**
 * Servlet implementation class ServletCadastrarEmpresa
 */
@WebServlet(name = "registrarHora", urlPatterns = { "/registrarHora" })
public class ServletRegistarHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRegistarHorario() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String tipoEntrada = request.getParameter("selectTipoEntrada");
		String usuario = request.getParameter("usuario");
		
		HorarioDAO horarioDAO = new HorarioDAO();
		
		//horarioDAO.deleteAll();
		
		if(tipoEntrada != null && !tipoEntrada.equals("null")){
			
			if(usuario != null && !usuario.equals("null")){
				
				Horario horario = new Horario();
				
				boolean isNew = false;
				
				String formatToDataQuery = DateHelper.formatToDataQuery(new DateTime());
				Horario horarioDia = horarioDAO.getHorarioDia(formatToDataQuery,usuario);
				
				if(horarioDia == null) {
					isNew = true;
				}else {
					horario = horarioDia;
				}
				
				EnumTipoHorario enumTipoHorario = EnumHelper.getENUM(tipoEntrada);
				int ordinal = enumTipoHorario.ordinal();
				
				switch (ordinal) {
				case 0:
					horario.setHoraEntrada(new DateTime());
					break;
				case 1:
					horario.setHoraAlmoco(new DateTime());
					break;
				case 2:
					horario.setHoraVoltaAlmoco(new DateTime());
					break;
				case 3:
					horario.setHoraSaida(new DateTime());
					break;
				default:
					break;
				}
				
				
				horario.setDdMMyyyy(formatToDataQuery);
				horario.setUsuario(usuario);
				
				if(!isNew) {
					horarioDAO.atualizarHorario(formatToDataQuery, horario);
				}else {
					horarioDAO.inserirHorario(horario);
				}
				
			}
		}
		
		String json = JsonHelper.jsonToArray(horarioDAO.listarHorarios());

		request.setAttribute("horarios", json);

		ServletHelper.forward(request, response, "PontoEletronico.jsp");
	}
	
	

}
