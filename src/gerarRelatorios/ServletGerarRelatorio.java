package gerarRelatorios;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HorarioDAO;

import negocio.Horario;

import util.EnumHelper;
import util.FileControler;
import util.ServletHelper;

/**
 * Servlet implementation class ServletCadastrarEmpresa
 */
@WebServlet(name = "gerarRelatorio", urlPatterns = { "/gerarRelatorio" })
public class ServletGerarRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletGerarRelatorio() {
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

		request.setAttribute("horarios", horarioDAO.listarHorarios());

		if (flagEscrita) {
			System.out.println("Arquivo salvo com sucesso");
			request.setAttribute("msg", "Horas Registradas com sucesso!");
		} else {
			request.setAttribute("msg", "Erro ao registar horas.");
		}

		ServletHelper.forward(request, response, "PontoEletronico.jsp");
	}

}
