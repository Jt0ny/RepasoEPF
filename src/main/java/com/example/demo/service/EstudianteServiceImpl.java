package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	
	@Override
	@Transactional (value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Estudiante> encontrarTodos() {
		return this.estudianteRepository.buscarTodos();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Estudiante buscarEstu(Integer id) {
	
		return this.estudianteRepository.buscarEstu(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrarEstu(Integer id) {
	this.estudianteRepository.eliminarEstu(id);
	}

}
