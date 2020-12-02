package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.SiteReservaDAO;
import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.CidadeDAO;
import br.ufscar.dc.dsw.dao.PromoHotelDAO;

import br.ufscar.dc.dsw.domain.PromoHotel;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Cidade;

import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/hoteluser/*")
public class HotelController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private HotelDAO daoHotel;
    private CidadeDAO daoCidade;
    private PromoHotelDAO dao;

    @Override
    public void init() {
        this.dao = new PromoHotelDAO();
        this.daoCidade = new CidadeDAO();
        this.daoHotel = new HotelDAO();
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String verifica = request.getParameter("AreaParaNaoCadastrados");

			if (verifica.equals("listaTodosHoteis"))
				listaTodosHoteis(request, response);
			else
				if(verifica.equals("listaHoteisPorCidade"))
					listaHoteisPorCidade(request, response);
        } catch (RuntimeException | IOException | ServletException e) {
        	//throw new ServletException(e);
        }

    	Hotel usuario = (Hotel) request.getSession().getAttribute("usuarioLogado");
    	Erro erros = new Erro();
    	String[] dominio = usuario.getEmail().split("@");  //para definir o papel do usuario pelo dominio email
    	//System.out.println(usuario.getAll);
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    		return;
    	} else if (!dominio[1].equals("hotel.com")) {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [HOTEL] tem acesso a essa página");
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
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Hotel usuario = (Hotel) request.getSession().getAttribute("usuarioLogado");
    	List<PromoHotel> listaPromoHotel = dao.getPromohotel(usuario.getId());
        request.setAttribute("listaPromoHotel", listaPromoHotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/hotel/promohotel/lista.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Long, String> getSites() {
        Map<Long, String> sites = new HashMap<>();
        for (SiteReserva sitereserva : new SiteReservaDAO().getAll()) {
            sites.put(sitereserva.getId(), sitereserva.getNome());
        }
        return sites;
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("hoteis", getHoteis());
    	//Hotel usuario = (Hotel) request.getSession().getAttribute("usuarioLogado");
    	//request.setAttribute("hotel", usuario);
        request.setAttribute("sites", getSites());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/hotel/promohotel/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        PromoHotel promohotel = dao.get(id);
        request.setAttribute("promohotel", promohotel);
        //Hotel usuario = (Hotel) request.getSession().getAttribute("usuarioLogado");
    	//request.setAttribute("hotel", usuario);
        //request.setAttribute("hoteis", getHoteis());
        request.setAttribute("sites", getSites());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/hotel/promohotel/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Float preco = Float.parseFloat(request.getParameter("preco"));
        String iniciopromo = request.getParameter("iniciopromo");
        String fimpromo = request.getParameter("fimpromo");

        /*Long hotelID = Long.parseLong(request.getParameter("hotel"));
        Hotel hotel = new HotelDAO().get(hotelID);*/
        Hotel hotel = (Hotel) request.getSession().getAttribute("usuarioLogado");
    	//request.setAttribute("hotel", usuario);
        Long SitereservaID = Long.parseLong(request.getParameter("sitereserva"));
        SiteReserva sitereserva = new SiteReservaDAO().get(SitereservaID);
        System.out.println(preco);
        System.out.println(iniciopromo);
        System.out.println(fimpromo);
        System.out.println(hotel);
        System.out.println(SitereservaID);
        System.out.println(sitereserva);

        PromoHotel promohotel = new PromoHotel(preco, iniciopromo, fimpromo, hotel, sitereserva);
        dao.insert(promohotel);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        Float preco = Float.parseFloat(request.getParameter("preco"));
        String iniciopromo = request.getParameter("iniciopromo");
        String fimpromo = request.getParameter("fimpromo");

        /*Long hotelID = Long.parseLong(request.getParameter("hotel"));
        Hotel hotel = new HotelDAO().get(hotelID);*/
        Hotel hotel = (Hotel) request.getSession().getAttribute("usuarioLogado");
        Long SitereservaID = Long.parseLong(request.getParameter("sitereserva"));
        SiteReserva sitereserva = new SiteReservaDAO().get(SitereservaID);
        System.out.println(preco);
        System.out.println(iniciopromo);
        System.out.println(fimpromo);
        System.out.println(hotel);
        System.out.println(SitereservaID);
        System.out.println(sitereserva);

        PromoHotel promohotel = new PromoHotel(id, preco, iniciopromo, fimpromo, hotel, sitereserva);
        dao.update(promohotel);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        PromoHotel promohotel = new PromoHotel(id);
        dao.delete(promohotel);
        response.sendRedirect("lista");
    }

    private void listaTodosHoteis(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listaHoteis = daoHotel.getAll();
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
