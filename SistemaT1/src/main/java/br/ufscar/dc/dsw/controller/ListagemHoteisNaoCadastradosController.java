package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.CidadeDAO;

@WebServlet(urlPatterns = "/listaHoteis")
public class ListagemHoteisNaoCadastradosController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private HotelDAO daoHotel;
	private CidadeDAO daoCidade;
	
	@Override
	public void init() {
		this.daoHotel = new HotelDAO();
		this.daoCidade = new CidadeDAO();
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
			String verifica = request.getParameter("AreaParaNaoCadastrados");
			if (verifica != null && verifica.equals("listaHoteisPorCidade"))
				listaHoteisPorCidade(request, response);
			else
				listaTodosHoteis(request, response);
        } catch (RuntimeException | IOException | ServletException e) {
        	throw new ServletException(e);
        }
    }
	
    private void listaTodosHoteis(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listaHoteis = daoHotel.getAll(); //listaHoteis recebe a lista de hotéis ordenados pelo nome. 
        request.setAttribute("listaHoteis", listaHoteis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaTodosHoteis.jsp");
        dispatcher.forward(request, response);
    }

    private void listaHoteisPorCidade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cidade> listaCidades = daoCidade.getAll();
        request.setAttribute("listaCidades", listaCidades);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaTodosHoteisPorCidade.jsp");
        dispatcher.forward(request, response);
    }
}
