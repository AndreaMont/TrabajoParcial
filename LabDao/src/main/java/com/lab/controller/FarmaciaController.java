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

import com.lab.entities.Farmacia;
import com.lab.service.FarmaciaService;

@Controller
public class FarmaciaController {
	
	@Autowired
	private FarmaciaService farmaciaService;
	
	@RequestMapping(value = "/farmacias", method = RequestMethod.GET)
	public String farmacia(Model model){
		model.addAttribute("farmacias", farmaciaService.listAllFarmacia());
		return "farmacias";
	}
	
	@RequestMapping(value = "/farmacia/new")
	public String newFarmacia(Model model){
		model.addAttribute("farmacia", new Farmacia());
		return "newFarmacia";
	}
	
	@RequestMapping(value = "/farmacia", method = RequestMethod.POST)
	public String saveFarmacia(@Valid Farmacia farmacia, BindingResult result, Model model){
		try{
			if(result.hasErrors()){
				return "newFarmacia";
			}
			farmaciaService.saveFarmacia(farmacia);
			return "redirect:/farmacias";
		} catch (Exception e){
			return "newFarmacia";
		}
	}
	
	@RequestMapping(value = "/farmacia/{id}", method = RequestMethod.GET)
	public String viewFarmacia(@PathVariable int id, Model model){
		model.addAttribute("farmacia", farmaciaService.getFarmaciaById(id));
		return "viewFarmacia";
	}
	
	@RequestMapping(value = "/farmacia/delete/{id}", method = RequestMethod.GET)
	public String deleteFarmacia(@PathVariable int id, Model model){
		farmaciaService.deleteFarmacia(id);
		return "redirect:/farmacias";
	}
	
	@RequestMapping(value = "/farmacias", method = RequestMethod.POST)
	public String buscarFarmacia(Model model, @RequestParam String distrito){
		model.addAttribute("farmacias", farmaciaService.getByNamedistrito(distrito));
		return "farmacias";
	}

}
