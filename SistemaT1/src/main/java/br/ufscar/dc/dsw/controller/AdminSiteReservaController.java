package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.SiteReservaDAO;
import br.ufscar.dc.dsw.domain.SiteReserva;

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

@WebServlet(urlPatterns = "/admin/reservas/*")
public class AdminSiteReservaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private SiteReservaDAO dao;

    @Override
    public void init() {
        dao = new SiteReservaDAO();
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
        List<SiteReserva> listaSiteReserva = dao.getAll();

        //System.out.println(listaSiteReserva);
        
        request.setAttribute("listaSiteReserva", listaSiteReserva);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/sitereserva/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/sitereserva/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        SiteReserva sitereserva = dao.get(id);
        request.setAttribute("sitereserva", sitereserva);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/sitereserva/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        SiteReserva sitereserva = new SiteReserva(url, nome, telefone, email, senha);
        dao.insert(sitereserva);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        
        SiteReserva sitereserva = new SiteReserva(id, url, nome, telefone, email, senha);
        dao.update(sitereserva);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        SiteReserva sitereserva = new SiteReserva(id);
        dao.delete(sitereserva);
        response.sendRedirect("lista");
    }
}
