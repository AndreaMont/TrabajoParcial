package com.lab.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab.entities.Medicamento;
import com.lab.entities.Orden;
import com.lab.service.FarmaciaService;
import com.lab.service.MedicamentoService;
import com.lab.service.OrdenService;


@Controller
public class OrdenController {

	
	@Autowired
	private OrdenService ordenService;
	@Autowired
	private FarmaciaService farmaciaService;
	@Autowired
	private MedicamentoService medicamentoService;
	

	
	@RequestMapping(value = "/ordenes", method = RequestMethod.GET)
	public String ordenes(Model model){
		model.addAttribute("ordenes", ordenService.listAllOrden());
		model.addAttribute("orden", new Orden());
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
		return "ordenes";
	}
	
	@RequestMapping(value = "/orden/new")
	public String newOrden(Model model){
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
		model.addAttribute("orden", new Orden());
		return "newOrden";
	}
	
	@RequestMapping(value = "/orden", method = RequestMethod.POST)
	public String saveNewOrden(@Valid Orden orden, BindingResult result, Model model){
		try{
			if(result.hasErrors()){
				model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
				model.addAttribute("medicamentos",medicamentoService.listAllMedicamentos());
				
				model.addAttribute("message", result.toString());
				return "newOrden";
			}
			
	
			
			Medicamento medicamento;
			medicamento=medicamentoService.getMedicamentoById(orden.getMedicamento().getId_medicamento());
	
			double montototal=orden.getCantidad()*medicamento.getPreciounitario();
			orden.setMontototal(montototal);
			ordenService.saveOrden(orden);
			//model.addAttribute("message", "El monto total="+precio);
			return "redirect:/ordenes";
		} catch (Exception e){
			model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
			model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
			//model.addAttribute("message",e.getMessage());
			//System.out.println(e.getMessage());
			return "newOrden";
		}
	}
	
	@RequestMapping(value = "/orden/{id}", method = RequestMethod.GET)
	public String viewOrden(@PathVariable int id,Model model){
		Orden orden =ordenService.getOrdenById(id);
		
		model.addAttribute("orden", orden);
		
		return "viewOrden";
	}
	
	@RequestMapping(value = "/orden/edit/{id}", method = RequestMethod.GET)
	public String editOrden(@PathVariable int id, Model model){
		Orden orden = ordenService.getOrdenById(id);
		
		model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		model.addAttribute("orden", orden);
		
		return "editOrden";
	}
	
	@RequestMapping(value = "/orden/delete/{id}", method = RequestMethod.GET)
	public String deleteOrden(@PathVariable int id, Model model){
		ordenService.deleteOrden(id);
		return "redirect:/ordenes";
	}
	
	
	@RequestMapping(value = "/fechasordenrange", method = RequestMethod.POST)
	public String listarordenesRangeo(Model model, @RequestParam String date1,
			@RequestParam String date2)
	{
		
		

		
		model.addAttribute("ordenes",ordenService.findByF_ordenBetween(date1, date2));
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());

		model.addAttribute("orden",new Orden());
	
		return "ordenes";
	}
	
	@RequestMapping(value = "/ordenesfarmacia", method = RequestMethod.POST)
	public String listarOrdenesFarmacia(Model model, Orden orden){
		
		model.addAttribute("ordenes",ordenService.getOrdenByFarmacia(orden.getFarmacia().getId_farmacia()));
		model.addAttribute("ordenes", ordenService.getFarmaciaOrderByMontoTotalDESC(orden.getFarmacia().getId_farmacia()));
		model.addAttribute("cantiordenes", ordenService.countOrdenByFarmacia(orden.getFarmacia().getId_farmacia()));
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		
		return "ordenes";
	}
	
	
	
}
