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

import com.lab.entities.Distrito;
import com.lab.service.DistritoService;

@Controller
public class DistritoController {

	
	@Autowired
	private DistritoService distritoService;
	
	//LISTAR 
		@RequestMapping(value = "/distritos", method = RequestMethod.GET)
		public String distritos(Model model){
			model.addAttribute("distritos", distritoService.listAllDistritos());

			return "distritos";
		}
		
		//CARGA 
		@RequestMapping(value = "/distrito/new")
		public String newDistrito(Model model){
			model.addAttribute("distrito", new Distrito());
			return "newDistrito";
		}
		
		//GUARDAR 
		@RequestMapping(value = "/distrito", method = RequestMethod.POST)
		public String saveNewDistrito(@Valid Distrito distrito, BindingResult result){
			try{
				if(result.hasErrors()){
					return "newDistrito";
				}
				distritoService.saveDistrito(distrito);
				return "redirect:/distritos";
			}
			catch(Exception e){
				return "newDistrito";
			}
		}
		
		@RequestMapping(value = "/distrito/{id}", method = RequestMethod.GET)
		public String viewDistrito(@PathVariable int id, Model model){
			model.addAttribute("distrito", distritoService.getDistritoById(id));
			return "viewDistrito";
		}
		
		@RequestMapping(value = "/distrito/edit/{id}", method = RequestMethod.GET)
		public String editDistrito(@PathVariable int id, Model model){
			model.addAttribute("distrito", distritoService.getDistritoById(id));
			return "editDistrito";
		}
		
		@RequestMapping(value = "/distrito/delete/{id}", method = RequestMethod.GET)
		public String deleteDistrito(@PathVariable int id){
			distritoService.deleteDistrito(id);
			return "redirect:/distritos";
		}
		
		@RequestMapping(value = "/distritos", method = RequestMethod.POST)
		public String buscarDistritos(Model model, @RequestParam String nombre){
			model.addAttribute("distritos", distritoService.getDistritoByNombre(nombre));
			return "distritos";
		}

}
