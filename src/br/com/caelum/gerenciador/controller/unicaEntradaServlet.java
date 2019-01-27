package br.com.caelum.gerenciador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.caelum.gerenciador.acao.Acao;


@WebServlet("/entrada")
public class unicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//		    response.sendRedirect("entrada?acao=LoginForm");
//		    return;
//		}

        String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao;

        String nome;
        try {
            Class classe = Class.forName(nomeDaClasse); 
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request,response);
        } catch (ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] tipoEEndereco = nome.split(":");
        
        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rd =  request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);
        }       
		
//		VERSAO ANTIGA SEM REFLECTION
//		String param = request.getParameter("acao");
//		String nome = null;
//		
//		if(param.equals("ListaEmpresas")) {
//			ListaEmpresas lista = new ListaEmpresas();
//			nome = lista.executa(request, response);
//			
//		}else if(param.equals("AdicionaEmpresa")) {
//			AdicionaEmpresa adiciona = new AdicionaEmpresa();
//			nome = adiciona.executa(request, response);
//		}
//		else if(param.equals("RemoveEmpresa")) {
//			RemoveEmpresa adiciona = new RemoveEmpresa();
//			nome = adiciona.executa(request, response);
//		}
//		else if(param.equals("AlteraEmpresa")) {
//			AlteraEmpresa adiciona = new AlteraEmpresa();
//			nome = adiciona.executa(request, response);
//		}
//		else if(param.equals("EmpresaAlterada")) {
//			EmpresaAlterada adiciona = new EmpresaAlterada();
//			nome = adiciona.executa(request, response);
//		}
//		
//		else if(param.equals("FormNovaEmpresa")) {
//			FormNovaEmpresa adiciona = new FormNovaEmpresa();
//			nome = adiciona.executa(request, response);
//		}
//		
//		String[] tipoRequisicao = nome.split(":");
//		
//		if(tipoRequisicao[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRequisicao[1]);
//			rd.forward(request, response);
//		}else {
//			response.sendRedirect("WEB-INF/view/" + tipoRequisicao[1]);
//		}
		
		
	}

}
