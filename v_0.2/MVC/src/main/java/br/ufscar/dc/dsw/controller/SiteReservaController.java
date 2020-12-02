package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PromoHotelDAO;
import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/sitereservauser/*")
public class SiteReservaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
   
    private PromoHotelDAO dao;

    @Override
    public void init() {
        dao = new PromoHotelDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	SiteReserva usuario = (SiteReserva) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	String[] dominio = usuario.getEmail().split("@"); //para definir o papel do usuario pelo dominio do email
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    		return;
    	} else if (!dominio[1].equals("siteres.com")) {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [SiteReserva] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    		return;
    	}
    	
    	String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            lista(request, response);
                    
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SiteReserva usuario = (SiteReserva) request.getSession().getAttribute("usuarioLogado");
    	List<PromoHotel> listaPromoHotel = dao.getPromoSite(usuario.getId());
        request.setAttribute("listaPromoHotel", listaPromoHotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/sitereserva/lista.jsp");
        dispatcher.forward(request, response);
    }
}