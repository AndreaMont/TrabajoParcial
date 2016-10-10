package com.seguro.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seguro.dto.Vehiculo;
import com.seguro.model.vehiculoModel;

/**
 * Servlet implementation class vehiculoController
 */
@WebServlet({ "/listVehiculo", "/insertVehiculo", "/deleteVehiculo", "/updateVehiculo" })
public class vehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private vehiculoModel vmodel=null;
	private Vehiculo v=new Vehiculo(); 
	private String mensaje = null;
	private String destino = "/panelVehiculos.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		vmodel=new vehiculoModel();
		
	}
    public vehiculoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String path = request.getServletPath();
		
		try {
			switch (path) {
		
			case "/insertVehiculo":
				insert(request);
				destino="panelVehiculos.jsp";				
				break;
				
			case "/newVehiculo":
				//mensaje=list(request,vmodel);
				destino="agregarVehiculo.jsp";				
				break;
			
			
			case "/listVehiculo":
				//mensaje=list(request,vmodel);
				destino="/panelVehiculos.jsp";
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
	
		v.setModelo(request.getParameter("modelo"));
		v.setMarca(request.getParameter("marca"));
		v.setPlaca(request.getParameter("placa"));
		v.setTipoCaja(request.getParameter("tipoCaja"));
		v.setAnio(Integer.parseInt(request.getParameter("anio")));
		v.setKilometraje(Integer.parseInt(request.getParameter("kilometraje")));
		v.setEstado(request.getParameter("estado"));
		
		vmodel.registrarVehiculo(v);
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
