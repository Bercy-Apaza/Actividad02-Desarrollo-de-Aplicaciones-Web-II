package com.medicamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicamento.entity.Medicamento;
import com.medicamento.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	
	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	public List<Medicamento> listaMedicamento() {
		return repository.findAll();
	}

	@Override
	public List<Medicamento> listaPorNombre(String nombre) {
		return repository.findByNombreContaining(nombre);
	}

	@Override
	public List<Medicamento> buscarPorStock(int stock) {
		return repository.findByStock(stock);
	}

	@Override
	public Optional<Medicamento> buscarPorId(int idMedicamento) {
		
		return repository.findById(idMedicamento);
	}

}
