package com.seguro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seguro.dto.Usuario;
import com.seguro.model.usuarioModel;

/**
 * Servlet implementation class usuarioController
 */
@WebServlet({ "/login", "/register", "/logout" })
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private usuarioModel umodel = null;
	private Usuario u = new Usuario();
	private String destino = "index.jsp";
	
	private HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarioController() {
        super();
        // TODO Auto-generated constructor stub
        umodel = new usuarioModel();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		try{
			switch (path) {
			case "/login":
				String correo=request.getParameter("correo");
				String password=request.getParameter("password");
				
				u=umodel.inicioSesion(correo, password);
				
				if(u!=null){
					session.setAttribute("usuario", u);
					session.setAttribute("ID", session.getId());
					switch (u.getTipoUsuario()) {
					case "INSPECTOR":
						destino="panelinspector.jsp";						
						break;
					case "CLIENTE":
						destino="catalogoc.jsp";
						break;
					}
					
				}else{
					request.setAttribute("mensaje","credenciales no validas");
					destino="index.jsp";					
				}
				
				break;

			case "/register":
				insert(request);
				destino="index.jsp";				
				break;
			
			case "/logout":
				session.invalidate();
				destino="index.jsp";
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

	private void insert(HttpServletRequest request) throws SQLException {
		// TODO Auto-generated method stub
		u.setApellidos(request.getParameter("apellido"));
		u.setNombres(request.getParameter("nombre"));
		u.setCorreo(request.getParameter("correo"));
		u.setPassword(request.getParameter("password"));
		
		umodel.registrarUsuario(u);
		
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
		doGet(request, response);
	}

}
