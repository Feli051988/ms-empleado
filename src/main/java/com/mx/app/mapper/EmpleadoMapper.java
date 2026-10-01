package com.mx.app.mapper;

import org.springframework.stereotype.Component;

import com.mx.app.dto.EmpleadoRequestDTO;
import com.mx.app.dto.EmpleadoResponseDTO;
import com.mx.app.entity.Empleado;

@Component
public class EmpleadoMapper {

	public Empleado toEntity(EmpleadoRequestDTO dto) {

		Empleado empleado = new Empleado();

		empleado.setId(dto.getId());
		empleado.setNombre(dto.getNombre());
		empleado.setDepto(dto.getDepto());
		empleado.setFechaIngreso(dto.getFechaIngreso());
		empleado.setSueldo(dto.getSueldo());
		empleado.setCorreo(dto.getCorreo());
		empleado.setTelefono(dto.getTelefono());

		return empleado;

	}

	public EmpleadoResponseDTO toResponse(Empleado emplado) {

		EmpleadoResponseDTO response = new EmpleadoResponseDTO();

		response.setId(emplado.getId());
		response.setNombre(emplado.getNombre());
		response.setDepto(emplado.getDepto());
		response.setFechaIngreso(emplado.getFechaIngreso());
		response.setSueldo(emplado.getSueldo());
		response.setCorreo(emplado.getCorreo());
		response.setTelefono(emplado.getTelefono());

		return response;

	}

}
