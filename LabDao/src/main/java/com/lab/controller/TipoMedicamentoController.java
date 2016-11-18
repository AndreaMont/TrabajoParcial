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

import com.lab.entities.TipoMedicamento;
import com.lab.service.TipoMedicamentoService;

@Controller
public class TipoMedicamentoController {
	
	@Autowired
	private TipoMedicamentoService tipomedicamentoService;
	
	//LISTAR tipomedicamentos
	@RequestMapping(value = "/tipomedicamentos", method = RequestMethod.GET)
	public String tipoMedicamentos(Model model){
		model.addAttribute("tipomedicamentos", tipomedicamentoService.listAllTipoMedicamentos());
		return "tipomedicamentos";
	}
	
	//CARGA newTipoMedicamento
	@RequestMapping(value = "/tipoMedicamento/new")
	public String newtipoMedicamento(Model model){
		model.addAttribute("tipoMedicamento", new TipoMedicamento());
		return "newTipoMedicamento";
	}
	
	//GUARDAR newTipoMedicamento
	@RequestMapping(value = "/tipomedicamento", method = RequestMethod.POST)
	public String saveNewTipoMedicamento(@Valid TipoMedicamento tipomedicamento, BindingResult result){
		try{
			if(result.hasErrors()){
				return "newTipoMedicamento";
			}
			tipomedicamentoService.saveTipoMedicamento(tipoMedicamento);
			return "redirect:/tipomedicamentos";
		}
		catch(Exception e){
			return "newTipoMedicamento";
		}
	}
	
	@RequestMapping(value = "/tipomedicamento/{id}", method = RequestMethod.GET)
	public String viewTipoMedicamento(@PathVariable int id, Model model){
		model.addAttribute("tipomedicamento", tipomedicamentoService.getTipoMedicamentoById(id));
		return "viewTipoMedicamento";
	}
	
	@RequestMapping(value = "/tipomedicamento/edit/{id}", method = RequestMethod.GET)
	public String editTipoMedicamento(@PathVariable int id, Model model){
		model.addAttribute("tipomedicamento", tipomedicamentoService.getTipoMedicamentoById(id));
		return "editTipoMedicamento";
	}
	
	@RequestMapping(value = "/tipomedicamento/delete/{id}", method = RequestMethod.GET)
	public String deleteTipoMedicamento(@PathVariable int id){
		tipomedicamentoService.deleteTipoMedicamento(id);
		return "redirect:/tipomedicamentos";
	}
	
	@RequestMapping(value = "/tipomedicamentos", method = RequestMethod.POST)
	public String buscarTipoMedicamento(Model model, @RequestParam String nombre){
		model.addAttribute("tipomedicamentos", tipomedicamentoService.getTipoMedicamentoByName(nombre));
		return "tipomedicamentos";
	}

}
