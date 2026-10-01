package com.mx.app.service;

import java.util.List;

import com.mx.app.dto.EmpleadoRequestDTO;
import com.mx.app.dto.EmpleadoResponseDTO;

public interface EmpleadoService {
	
	EmpleadoResponseDTO guardar(EmpleadoRequestDTO request);
	EmpleadoResponseDTO actualizar(Long id, EmpleadoRequestDTO request);
	void eliminar(Long id);
	
	EmpleadoResponseDTO buscar(Long id);
	List<EmpleadoResponseDTO> lista();

}
