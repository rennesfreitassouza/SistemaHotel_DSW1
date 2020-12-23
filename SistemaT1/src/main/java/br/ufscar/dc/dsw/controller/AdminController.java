package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Admin;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Erro erros = new Erro();
    	Admin usuario = null;
    	try {
    		usuario = (Admin) request.getSession().getAttribute("usuarioLogado");
    	}
    	catch(ClassCastException e) {
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
	    	request.setAttribute("mensagens", erros);
	    	RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
	    	System.out.println(erros); //printa erros no terminal
	    	rd.forward(request, response);
    	}
    	
    	int index =  -1;
    	if (usuario != null)
    		index = usuario.getLogin().indexOf('@');
    	else{
    		erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
	    	request.setAttribute("mensagens", erros);
	    	RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
	    	System.out.println(erros.getErros()); //printa erros no terminal
	    	rd.forward(request, response);
    	}
	   	if (index == -1) {
       		erros.add("Login inválido!");
	   		System.out.println(erros.getErros()); //printa erros no terminal
	   		}
       	else {
	    	String[] dominio = usuario.getLogin().split("@"); //para definir o papel do usuario pelo dominio do email

	    	if (usuario == null)
	    		response.sendRedirect(request.getContextPath());
	    	else if (dominio[1].equals("admin.com")) {
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/login_admin.jsp");
	            dispatcher.forward(request, response);
	    	}
	    	else {
	    		erros.add("Acesso não autorizado!");
	    		erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
	    		request.setAttribute("mensagens", erros);
	    		System.out.println(erros.getErros()); //printa erros no terminal
	    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
	    		rd.forward(request, response);
	    	}
    	}
    }
}
