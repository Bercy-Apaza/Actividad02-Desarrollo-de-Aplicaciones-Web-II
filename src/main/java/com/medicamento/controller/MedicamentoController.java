package com.medicamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicamento.entity.Medicamento;
import com.medicamento.service.MedicamentoService;

@RestController
@RequestMapping("/actividad/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping("/id/{param_nombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>>listarMedicamento(){
		List<Medicamento>lista=service.listaMedicamento();
		return ResponseEntity.ok(lista);	
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento>buscaPorId(@PathVariable("paramId") int idMedicamento){
		Optional<Medicamento>optMedicamento = service.buscarPorId(idMedicamento);
		if(optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/nombre/{param_nombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>>listarPorNombre(@PathVariable("param_nombre") String nombre){
		List<Medicamento>lista=service.listaPorNombre(nombre);
		if(org.springframework.util.CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/stock/{param_stock}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>>BuscarPorStock(@PathVariable("param_stock")int stock){
		List<Medicamento>lista=service.buscarPorStock(stock);
		if(org.springframework.util.CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	
	//http://localhost:8090/actividad/medicamento/id/1
	//http://localhost:8090/actividad/medicamento/nombre/Altalgina
	//http://localhost:8090/actividad/medicamento/stock/100
	
}
