package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping("/vistaMateria")
	public String vistaMateria (Materia materia) {
		return "vistaInsertarMateria";
	}
	
	@PostMapping("/insetar")
	public String insertarMateria(Materia materia) {
		materia.setNumEstudiantes(0);
		this.iMateriaService.crearM(materia);
		return "redirect:/materias/vistaMateria";
	}
}
