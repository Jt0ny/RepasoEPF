package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	private static final Logger LOG = Logger.getLogger(EstudianteController.class);
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/vistaEstudiante")
	public String vistaEstudiante (Estudiante estudiante ) {
		LOG.info("Info");
        LOG.error("Info");
        LOG.warn("Info");
        LOG.debug("Info");
		return "vistaInsertarEstu";
	}
	
	@PostMapping("/insetar")
	public String insertarEstu(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/listaEstudiantes";
	}

	@GetMapping("/listaEstudiantes")
	public String listaEstudiantes(Model model) {
		List<Estudiante>listaEstu=this.estudianteService.encontrarTodos();
		model.addAttribute("listaEstu",listaEstu);
		return "vistaListaEstu";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrarEstu (@PathVariable("id")Integer id) {
		this.estudianteService.borrarEstu(id);
		return "redirect:/estudiantes/listaEstudiantes";
	}
}
