package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.PromoHotelDAO;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.SiteReserva;
import br.ufscar.dc.dsw.domain.PromoHotel;

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
        String promo_inicio = request.getParameter("promoinicio");
        String promo_fim = request.getParameter("promofim");
        String promo_site = request.getParameter("promosite");
        
        Hotel hotel_selecionado = new HotelDAO().getByNome(hotel_sel);
        String buffer = "teste";
        Long hotel_id = hotel_selecionado.getId();
        String email = hotel_selecionado.getEmail();
        String cnpj = hotel_selecionado.getCnpj();
        List <PromoHotel> promo_selecionado = new PromoHotelDAO().getPromohotel(hotel_id, cnpj);
        String promoinicio = promo_selecionado.get(0).getIniciopromo();
        String promofim = promo_selecionado.get(0).getFimpromo();
        SiteReserva promosite = promo_selecionado.get(0).getSitereserva();

        //System.out.println(hotel_selecionado.getEmail());
        //System.out.println(buffer);
        //System.out.println(email);
        //System.out.println(cnpj);
        if (email_sel != null && email_sel.toLowerCase().equals("true"))
            buffer = email;
        if (cnpj_sel != null && cnpj_sel.toLowerCase().equals("true"))
            buffer = cnpj;
        if (promo_inicio != null && promo_inicio.toLowerCase().equals("true"))
            buffer = promoinicio;
        if (promo_fim != null && promo_fim.toLowerCase().equals("true"))
            buffer = promofim;
        if (promo_site != null && promo_site.toLowerCase().equals("true"))
            buffer = promosite.getUrl();
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
