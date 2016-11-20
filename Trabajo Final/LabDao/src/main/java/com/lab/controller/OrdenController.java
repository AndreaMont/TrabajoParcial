package com.lab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private double precio;
	
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
	public String saveNewOrden(@Valid Orden o, BindingResult result, Model model){
		try{
			if(result.hasErrors()){
				model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
				model.addAttribute("medicamentos",medicamentoService.listAllMedicamentos());
				
				model.addAttribute("message", result.toString());
				return "newOrden";
			}
			precio=ordenService.calcularImporteTotal(o);
			o.setMontototal(precio);
			ordenService.saveOrden(o);
			model.addAttribute("message", "El monto total="+precio);
			return "ordenes";
		} catch (Exception e){
			model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
			model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
			model.addAttribute("message",e.getMessage());
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
	
		
	 
	@RequestMapping(value = "/fechasenviorange", method = RequestMethod.POST)
	public String listarordenesRangee(Model model, @RequestParam String fe1,@RequestParam String fe2){
		
		model.addAttribute("ordenes",ordenService.findByFechaEnvio(fe1, fe2));
	
		
		return "ordenes";
	}
	
	@RequestMapping(value = "/fechasordenrange", method = RequestMethod.POST)
	public String listarordenesRangeo(Model model, @RequestParam String fo1,@RequestParam String fo2){
		
		model.addAttribute("ordenes",ordenService.findByFechaOrden(fo1, fo2));
	
		return "ordenes";
	}
	
	@RequestMapping(value = "/ordenesfarmacia", method = RequestMethod.POST)
	public String listarOrdenesFarmacia(Model model, Orden orden){
		
	
		model.addAttribute("ordenes",ordenService.getOrdenByFarmacia(orden.getFarmacia().getId_farmacia()));
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		return "ordenes";
	}
	
	
	
}
