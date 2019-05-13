package com.desafiouno.springboot.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class fechaPOJO implements Serializable {

	/**
	 * Periodo: type: object properties: id: type: integer format: int64
	 * fechaCreacion: type: string format: date fechaFin: type: string format: date
	 * fechas: type: array items: type: string format: date
	 */
	private static final long serialVersionUID = 3560972546182458142L;

	private Long id = null;
	private LocalDate fechaCreacion = null;
	private LocalDate fechaFin = null;
	private List<LocalDate> fechas = null;
	private List<LocalDate> fechasFaltantes = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void addFechasItem(LocalDate fechasItem) {
		if (this.fechas == null) {
			this.fechas = new ArrayList<>();
		}
		this.fechas.add(fechasItem);
	}
	
	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void addFechasFaltantesItem(LocalDate fechasFaltantesItem) {
		if (this.fechasFaltantes == null) {
			this.fechasFaltantes = new ArrayList<>();
		}
		this.fechasFaltantes.add(fechasFaltantesItem);
	}

}