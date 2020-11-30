package src.br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import src.br.ufscar.dc.dsw.bean.ListagemPorCidadeBean;
import src.br.ufscar.dc.dsw.domain.Hotel;

@WebServlet(urlPatterns = {"/ListagemDeHoteisPorCidadeController"})
public class ListagemDeHoteisPorCidadeController extends HttpServlet{
    private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("term");

        Gson gsonBuilder = new GsonBuilder().create();
        List<String> hoteisPorCidade = new ArrayList<>();
        for (Hotel hotel : new ListagemPorCidadeBean().getHotelPorCidade(nome)) {
        	hoteisPorCidade.add(hotel.getNomeHotel());
        }

        System.out.println(gsonBuilder.toJson(hoteisPorCidade));
        response.getWriter().write(gsonBuilder.toJson(hoteisPorCidade));
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
