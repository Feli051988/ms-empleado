package com.mx.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.app.dto.EmpleadoRequestDTO;
import com.mx.app.dto.EmpleadoResponseDTO;
import com.mx.app.service.EmpleadoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("Empleados/Api")
@CrossOrigin
public class EmpleadoController {

	private final EmpleadoService service;

	public EmpleadoController(EmpleadoService service) {
		this.service = service;
	}

	// http://localhost:9001/Empleados/Api/lista
	@GetMapping("/lista")
	public ResponseEntity<List<EmpleadoResponseDTO>> lista() {
		return ResponseEntity.ok(service.lista());
	}

	// http://localhost:9001/Empleados/Api/
	@GetMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> buscar(@PathVariable() Long id) {
		return ResponseEntity.ok(service.buscar(id));
	}

	// http://localhost:9001/Empleados/Api/guardar
	@PostMapping("/guardar")
	public ResponseEntity<EmpleadoResponseDTO> gurdar(@Valid @RequestBody EmpleadoRequestDTO request) {
		EmpleadoResponseDTO empleadoGuardar = service.guardar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoGuardar);
	}

	// http://localhost:9001/Empleados/Api/
	@PutMapping("/{id}")
	public ResponseEntity<EmpleadoResponseDTO> actualizar(@PathVariable() Long id,
			@Valid @RequestBody EmpleadoRequestDTO request) {

		EmpleadoResponseDTO empleadoActualizar = service.actualizar(id, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoActualizar);
	}

	// http://localhost:9001/Empleados/Api/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable() Long id) {
		service.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
