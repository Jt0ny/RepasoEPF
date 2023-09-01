package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public void insertar (Estudiante estudiante);
	
	public List<Estudiante> buscarTodos();
	
	public Estudiante buscarEstu(Integer id);
	
	public void eliminarEstu(Integer id);
	
	public Estudiante buscarEstuCedula(String cedula);
	
	

}
