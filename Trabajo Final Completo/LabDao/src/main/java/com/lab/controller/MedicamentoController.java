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
import com.lab.service.MedicamentoService;
import com.lab.service.TipoMedicamentoService;

@Controller
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@RequestMapping(value = "/medicamentos", method = RequestMethod.GET)
	public String medicamentos(Model model){
		model.addAttribute("medicamentos", medicamentoService.listAllMedicamentos());
		model.addAttribute("medicamento", new Medicamento());
		model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
		return "medicamentos";
	}
	
	@RequestMapping(value = "/medicamento/new", method = RequestMethod.GET)
	public String newMedicamento(Model model){
		model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
		model.addAttribute("medicamento", new Medicamento());
		return "newMedicamento";
	}
	
	@RequestMapping(value = "/medicamento", method = RequestMethod.POST)
	public String saveNewMedicamento(@Valid Medicamento medicamento, BindingResult result, Model model){
		try{
			if(result.hasErrors()){
				model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
				return "newMedicamento";
			}
			medicamentoService.saveMedicamento(medicamento);
			return "redirect:/medicamentos";
		} catch (Exception e){
			model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
			return "newMedicamento";
		}
	}
	
	@RequestMapping(value = "/medicamento/{id}", method = RequestMethod.GET)
	public String viewMedicamento(@PathVariable int id,Model model){
		Medicamento medicamento = medicamentoService.getMedicamentoById(id);
		
		model.addAttribute("medicamento", medicamento);
		
		return "viewMedicamento";
	}
	
	@RequestMapping(value = "/medicamento/edit/{id}", method = RequestMethod.GET)
	public String editMedicamento(@PathVariable int id, Model model){
		Medicamento medicamento = medicamentoService.getMedicamentoById(id);
		
		model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
		model.addAttribute("medicamento", medicamento);
		
		return "editMedicamento";
	}
	
	@RequestMapping(value = "/medicamento/delete/{id}", method = RequestMethod.GET)
	public String deleteMedicamento(@PathVariable int id, Model model){
		medicamentoService.deleteMedicamento(id);
		return "redirect:/medicamentos";
	}
	
	@RequestMapping(value = "/medicamentos", method = RequestMethod.POST)
	public String buscarMedicamento(Model model, @RequestParam String nombre){
		
		model.addAttribute("medicamentos", medicamentoService.getMedicamentoByNombre(nombre));
		model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
		model.addAttribute("medicamento", new Medicamento());
		
		return "medicamentos";
	}
	
	@RequestMapping(value = "/medicamentostipomedicamentos", method = RequestMethod.POST)
	public String buscarMedicamentoTipoMedicamento(Model model, Medicamento medicamento){
		
		model.addAttribute("medicamentos", medicamentoService.getMedicamentoByTipoMedicamento(medicamento.getTipoMedicamento().getId_tipomedicamento()));
		model.addAttribute("tipomedicamentos", tipoMedicamentoService.listAllTipoMedicamentos());
		model.addAttribute("cantidadtipomedicamento",medicamentoService.countMedicamentoByTipo(medicamento.getTipoMedicamento().getId_tipomedicamento()));
		return "medicamentos";
	}

}
