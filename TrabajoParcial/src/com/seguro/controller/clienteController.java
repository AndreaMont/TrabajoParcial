package com.seguro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seguro.dto.Cliente;
import com.seguro.model.clienteModel;

/**
 * Servlet implementation class clienteController
 */
@WebServlet({ "/insertCliente", "/updateCliente", "/deleteCliente", "/loginCliente", "/logoutCliente" })
public class clienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private clienteModel cmodel = null;
	private Cliente c = new Cliente();
	private String destino = "index.jsp";
	private String mensaje=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	private HttpSession session=null;
    
	public clienteController() {
		super();
		// TODO Auto-generated constructor stub
		cmodel = new clienteModel();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		session = request.getSession(true);// Crear session

		String path = request.getServletPath();
		
		try {
			switch (path) {
			case "/loginCliente":
				String usuario=request.getParameter("usuario");
				String contrasenia=request.getParameter("contrasenia");
				
				c=cmodel.inicioSesion(usuario,contrasenia);
				
				if(c!=null){
					session.setAttribute("usuario", c);
					session.setAttribute("ID", session.getId());
					destino="cliente.jsp";
					
				}else{
					request.setAttribute("mensaje","credenciales no validas");
					destino="index.jsp";					
				}
				
				break;

			case "/insertCliente":
				insert(request);
				destino="cliente.jsp";				
				break;
			
			case "/logoutCliente":
				session.invalidate();
				destino="index.jsp";
				break;
			case "/listCliente":
				mensaje=list(request,cmodel);
				destino="/panelClientes.jsp";
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
	
		c.setNombre(request.getParameter("nombre"));
		c.setApellido(request.getParameter("apellido"));
		c.setDni(Integer.parseInt(request.getParameter("dni")));
		c.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		c.setFechaNacimiento(request.getParameter("fechaNacimiento"));
		c.setUsuario(request.getParameter("usuario"));
		c.setContrasenia(request.getParameter("contrasenia"));
		
		cmodel.registrarCliente(c);
	}

	protected String list(HttpServletRequest request,clienteModel climodel)
	throws ServletException,IOException,SQLException{
		
		String error=null;
		List<Cliente> list=climodel.listarClientes();
		if(list!=null){
			request.setAttribute("listclientes", list);
			
		}else{
			error="Sin acceso a Base de datos";
		}
		return error;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
