package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.AdminDAO;
import br.ufscar.dc.dsw.domain.Admin;

import br.ufscar.dc.dsw.dao.SiteReservaDAO;
import br.ufscar.dc.dsw.domain.SiteReserva;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;

import br.ufscar.dc.dsw.util.Erro;

@WebServlet(name = "LoginAdmin", urlPatterns = { "/login_admin.jsp", "/logout.jsp" })
public class LoginAdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
			if (!erros.isExisteErros()) {
				
				AdminDAO daoAdmin = new AdminDAO();
				Admin usuarioAdmin = daoAdmin.getbyLogin(login);
				
				HotelDAO daoHotel = new HotelDAO();
				Hotel usuarioHotel = daoHotel.getbyLogin(login);
				//System.out.println(daoAdmin.getAll());
				
				SiteReservaDAO daoSiteReserva = new SiteReservaDAO();
				SiteReserva usuarioSiteReserva = daoSiteReserva.getbyLogin(login);
	           	
	           	int index = login.indexOf('@');
	           	if (index == -1)
	           		erros.add("Login inválido!");
	           	else{
	           		String[] dominio = login.split("@"); //separando o email de login em um array com as palavras antes e depois do "@"
				
					if (dominio.length != 1 && dominio[1].equals("admin.com")) {
						if (usuarioAdmin != null) {
							if (usuarioAdmin.getSenha().equals(senha)) {
								request.getSession().setAttribute("usuarioLogado", usuarioAdmin);
								response.sendRedirect("admin/");
							}
							else{
								erros.add("Senha inválida!");
								request.setAttribute("mensagens", erros);
            					RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            					rd.forward(request, response);
							}
							return;
						}
					}
					
					else
						if (dominio.length != 1 && dominio[1].equals("hotel.com")) {
							if (usuarioHotel != null) {
								if (usuarioHotel.getSenha().equals(senha)) {
									request.getSession().setAttribute("usuarioLogado", usuarioHotel);
									response.sendRedirect("hoteluser/");
									//System.out.println("senha igual");
								}
								else{
									//System.out.println("senha diferente");
									erros.add("Senha inválida!");
									request.setAttribute("mensagens", erros);
            						RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            						rd.forward(request, response);
									System.out.println(erros.getErros().get(0));
								}
								return;
							}
					}
					
					else {
						if (dominio.length != 1 && dominio[1].equals("siteres.com")) {
							if (usuarioSiteReserva != null) {
								if (usuarioSiteReserva.getSenha().equals(senha)) {
									request.getSession().setAttribute("usuarioLogado", usuarioSiteReserva);
									response.sendRedirect("sitereservauser/");
								}
								else{
									erros.add("Senha inválida!");
									request.setAttribute("mensagens", erros);
            						RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            						rd.forward(request, response);
								}
								return;
							}
						}
						else
							erros.add("Usuário não encontrado!");
					}
				}
	        }
		}
		request.getSession().invalidate();
		System.out.println(erros.getErros()); //printa erros no terminal

		request.setAttribute("mensagens", erros);

		String URL = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(URL);
		rd.forward(request, response);
	}
}
