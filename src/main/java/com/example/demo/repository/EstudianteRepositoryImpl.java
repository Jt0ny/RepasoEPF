package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	@Transactional (value = TxType.NOT_SUPPORTED)
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante>myQuery =this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
		
		return myQuery.getResultList();
	}

	@Override
	@Transactional (value = TxType.NOT_SUPPORTED)
	public Estudiante buscarEstu(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminarEstu(Integer id) {
		Estudiante estudiante2= this.buscarEstu(id);
		this.entityManager.remove(estudiante2);
		
	}

	@Override
	@Transactional (value = TxType.NOT_SUPPORTED)
	public Estudiante buscarEstuCedula(String cedula) {
		TypedQuery<Estudiante>myQuery =this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:datoCedula",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	
}
