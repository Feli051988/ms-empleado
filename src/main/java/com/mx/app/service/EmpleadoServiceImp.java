package com.mx.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mx.app.dto.EmpleadoRequestDTO;
import com.mx.app.dto.EmpleadoResponseDTO;
import com.mx.app.entity.Empleado;
import com.mx.app.mapper.EmpleadoMapper;
import com.mx.app.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	private final EmpleadoRepository repo;
	private final EmpleadoMapper mapper;

	public EmpleadoServiceImp(EmpleadoRepository repo, EmpleadoMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public EmpleadoResponseDTO guardar(EmpleadoRequestDTO request) {

		Empleado empleado = mapper.toEntity(request);

		Empleado empleadoGuardar = repo.save(empleado);

		return mapper.toResponse(empleadoGuardar);
	}

	@Override
	public EmpleadoResponseDTO actualizar(Long id, EmpleadoRequestDTO request) {

		Empleado empleado = repo.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		empleado.setId(request.getId());
		empleado.setNombre(request.getNombre());
		empleado.setDepto(request.getDepto());
		empleado.setFechaIngreso(request.getFechaIngreso());
		empleado.setSueldo(request.getSueldo());
		empleado.setCorreo(request.getCorreo());
		empleado.setTelefono(request.getTelefono());

		Empleado empleadoActulizar = repo.save(empleado);

		return mapper.toResponse(empleadoActulizar);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		if (!repo.existsById(id)) {
			throw new RuntimeException("no existe el empleado con el ID");
		}

		repo.deleteById(id);
	}

	@Override
	public EmpleadoResponseDTO buscar(Long id) {
		Empleado empleado = repo.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		return mapper.toResponse(empleado);
	}

	@Override
	public List<EmpleadoResponseDTO> lista() {
		// TODO Auto-generated method stub
		return repo.findAll().stream().map(mapper::toResponse).toList();
	}

}
