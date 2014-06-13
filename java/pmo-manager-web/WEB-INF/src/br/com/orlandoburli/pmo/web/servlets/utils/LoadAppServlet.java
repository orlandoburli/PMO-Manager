package br.com.orlandoburli.pmo.web.servlets.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.orlandoburli.framework.core.log.Log;
import br.com.orlandoburli.pmo.model.utils.DBUtils;

@WebServlet(value = "/load", loadOnStartup = 1)
public class LoadAppServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		init();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			System.getProperties().load(getServletContext().getResourceAsStream("pmo.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.info("Inicializando app PMO Manager");

		Log.info("Propriedades carregadas.");

		DBUtils.checkDaos();

		Log.info("DAOs checadas.");

		Log.info("App PMO Manager inicializado.");
	}
}
