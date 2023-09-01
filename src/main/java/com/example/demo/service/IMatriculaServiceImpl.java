package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class IMatriculaServiceImpl implements IMateriaRepository{

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	@Transactional (value =  TxType.REQUIRED)
	public void insertar(Materia materia) {
		this.iMateriaRepository.insertar(materia);
		
	}

	@Override
	public Materia buscarMateria(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
