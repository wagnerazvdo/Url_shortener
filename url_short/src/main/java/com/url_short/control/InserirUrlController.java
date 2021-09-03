package com.url_short.control;

import java.io.IOException;

import com.url_short.persistence.LinkDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

///////////////////////// CLASSE PARA INSERIR DADOS NA URL /////////////////////////////


@WebServlet("/InserirUrlController")
public class InserirUrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public InserirUrlController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String msg = "OK"; 
		try {
			LinkDAO linkDAO = new LinkDAO();
			if  (!linkDAO.create(request.getParameter("url")))
					msg = "OK";
		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage(); 
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect("index.jsp");
	}

}
