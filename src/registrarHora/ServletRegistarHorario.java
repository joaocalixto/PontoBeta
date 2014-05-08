package registrarHora;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Horario;
import util.EnumHelper;
import util.FileControler;
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Date agora = new Date(System.currentTimeMillis());

		String absoluteDiskPath = getServletContext().getRealPath("");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String textoPonto = request.getParameter("selectTipoEntrada") + " : "
				+ sdf.format(agora);

		boolean flagEscrita = FileControler.escreverArquivo(textoPonto,
				absoluteDiskPath);

		Horario horario = new Horario(new Date(), EnumHelper.getENUM(request
				.getParameter("selectTipoEntrada")));

		HorarioDAO horarioDAO = new HorarioDAO();

		horarioDAO.inserirHorario(horario);
		
		Gson gson = new Gson();

		request.setAttribute("horarios", );

		if (flagEscrita) {
			System.out.println("Arquivo salvo com sucesso");
			request.setAttribute("msg", "Horas Registradas com sucesso!");
		} else {
			request.setAttribute("msg", "Erro ao registar horas.");
		}

		ServletHelper.forward(request, response, "PontoEletronico.jsp");
	}

}
