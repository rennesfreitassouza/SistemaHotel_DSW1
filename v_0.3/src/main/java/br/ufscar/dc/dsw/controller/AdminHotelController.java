package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.HotelDAO;
//import br.ufscar.dc.dsw.dao.SiteReservaDAO;
import br.ufscar.dc.dsw.domain.Hotel;
//import br.ufscar.dc.dsw.domain.SiteReserva;

import java.io.IOException;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/hoteis/*")
public class AdminHotelController extends HttpServlet {

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

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listaHotel = dao.getAll();

        //System.out.println(listaHotel);
           
        request.setAttribute("listaHotel", listaHotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/hotel/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/hotel/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Hotel hotel = dao.get(id);
        request.setAttribute("hotel", hotel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/hotel/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Hotel hotel = new Hotel(cnpj, nome, cidade, email, senha);
        dao.insert(hotel);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        
        Hotel hotel = new Hotel(id, cnpj, nome, cidade, email, senha);
        dao.update(hotel);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Hotel hotel = new Hotel(id);
        dao.delete(hotel);
        response.sendRedirect("lista");
    }
}
