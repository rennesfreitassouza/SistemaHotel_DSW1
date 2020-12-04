package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.HotelDAO;

import br.ufscar.dc.dsw.domain.Hotel;

@WebServlet(urlPatterns = {"/MostraDadosHotelSelecionadoController"})
public class MostraDadosHotelSelecionadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String hotel_sel = request.getParameter("hotel");
        //System.out.println(hotel_sel);
        String email_sel = request.getParameter("emailsel");
        //System.out.println(email_sel);
        String cnpj_sel = request.getParameter("cnpjsel");
        //System.out.println(cnpj_sel);
        Hotel hotel_selecionado = new HotelDAO().getByNome(hotel_sel);
        String buffer = "teste";
        String email = hotel_selecionado.getEmail();
        String cnpj = hotel_selecionado.getCnpj();
        //System.out.println(hotel_selecionado.getEmail());
        //System.out.println(buffer);
        //System.out.println(email);
        //System.out.println(cnpj);
        if (email_sel.toLowerCase().equals("true"))
            buffer = email;
        if (cnpj_sel.toLowerCase().equals("true"))
            buffer = cnpj;
        response.getWriter().println(buffer);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}