package com.medicamento.service;

import java.util.List;
import java.util.Optional;

import com.medicamento.entity.Medicamento;

public interface MedicamentoService {
	
	public List<Medicamento>listaMedicamento();
	
	public Optional<Medicamento> buscarPorId(int idMedicamento);
	
	public List<Medicamento>listaPorNombre(String nombre);
	
	public List<Medicamento>buscarPorStock(int stock);
	
}
