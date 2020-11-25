package src.br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.br.ufscar.dc.dsw.dao.*;
import src.br.ufscar.dc.dsw.domain.*;

@WebServlet(urlPatterns = "/listaHoteis/*")
public class HotelController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private HotelDAO dao;
	
	@Override
	public void init() {
		dao = new HotelDAO();
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
		try {
			listaHoteis(request, response);
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }
	
    private void listaHoteis(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listaHoteis = dao.getAll();
        request.setAttribute("listaHoteis", listaHoteis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
        dispatcher.forward(request, response);
    }
}
