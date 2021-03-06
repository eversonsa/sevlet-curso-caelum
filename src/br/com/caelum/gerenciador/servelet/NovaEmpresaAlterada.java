package br.com.caelum.gerenciador.servelet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;


//@WebServlet("/NovaEmpresaAlterada")
public class NovaEmpresaAlterada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramNomeEmpresa = request.getParameter("nome");
		String paramdataAbertura = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramdataAbertura);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
		Empresa empresa = new Empresa();
		Banco banco = new Banco();
		empresa = banco.buscaPorId(id);
		
		empresa.setNome(paramNomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		
		request.setAttribute("empresa", empresa);
		response.sendRedirect("ListaEmpresaServlet");
	}

}
