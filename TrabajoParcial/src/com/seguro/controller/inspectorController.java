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

import com.seguro.dto.Inspector;
import com.seguro.model.inspectorModel;

/**
 * Servlet implementation class inspectorController
 */
@WebServlet({ "/listInspector", "/insertInspector", "/deleteInspector", "/updateInspector", "/loginInspector", "/logoutInspector" })
public class inspectorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private inspectorModel imodel=null;
	private Inspector i=new Inspector();
	private String destino="index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private HttpSession session=null;
    public inspectorController() {
        super();
        // TODO Auto-generated constructor stub
        imodel=new inspectorModel();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(true);// Crear session

		String path = request.getServletPath();
		
		try {
			switch (path) {
			case "/loginInspector":
				String usuario=request.getParameter("usuario");
				String contrasenia=request.getParameter("contrasenia");
				
				i=imodel.inicioSesion(usuario,contrasenia);
				
				if(i!=null){
					session.setAttribute("usuario", i);
					session.setAttribute("ID", session.getId());
					destino="cliente.jsp";
					
				}else{
					request.setAttribute("mensaje","credenciales no validas");
					destino="index.jsp";					
				}
				
				break;

			case "/insertInspector":
				insert(request);
				destino="index.jsp";				
				break;
			
			case "/logoutInspector":
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

	protected void insert(HttpServletRequest request) throws ServletException, IOException,SQLException {
		// TODO Auto-generated method stub
		i.setApellido(request.getParameter("apellido"));
		i.setNombre(request.getParameter("nombre"));
		i.setUsuario(request.getParameter("usuario"));
		i.setContrasenia(request.getParameter("contrasenia"));
		
		imodel.registrarInspector(i);
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
