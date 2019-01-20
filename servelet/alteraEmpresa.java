package br.com.caelum.gerenciador.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

@WebServlet("/alteraEmpresa")
public class alteraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Banco banco = new Banco();
		Empresa empresas = banco.buscaPorId(id); 
		
		request.setAttribute("empresa", empresas);
		RequestDispatcher rd = request.getRequestDispatcher("/formularioAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
