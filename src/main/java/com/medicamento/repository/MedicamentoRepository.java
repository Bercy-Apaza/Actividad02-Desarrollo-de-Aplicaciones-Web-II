package com.medicamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.medicamento.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	
	List<Medicamento>findByNombreContaining(String nombre);

	List<Medicamento>findByStock(int stock);
	
}
