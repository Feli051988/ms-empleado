package com.mx.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EMPLEADOS_TEST2026")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Empleado {
	
	@Id
	@Column(name="ID", columnDefinition = "NUMBER")
	private Long id;
	
	@Column(name="NOMBRE", columnDefinition = "NVARCHAR2(50)", nullable = false, length = 50)
	private String nombre;
	
	@Column(name="DEPTO", columnDefinition = "NVARCHAR2(50)", nullable = false, length = 50)
	private String depto;
	
	@Column(name="FECHA_INGRESO", columnDefinition = "DATE", nullable = false)
	private LocalDate fechaIngreso;
	
	@Column(name="SUELDO", columnDefinition = "NUMBER", nullable = false)
	private double sueldo;
	
	@Column(name="CORREO", columnDefinition = "NVARCHAR2(50)")
	private String correo;
	
	@Column(name="TELEFONO", columnDefinition = "NVARCHAR2(50)", nullable = false, length = 50)
	private String telefono;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	


}
