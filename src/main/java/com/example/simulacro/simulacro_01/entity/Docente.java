package com.example.simulacro.simulacro_01.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="docente")
@Getter
@Setter
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocente;
	private String nombre;
	private String dni;
	private int estado;
	private LocalDateTime fechaRegistro;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUbigeo")
	private Ubigeo ubigeo;

	@Override
	public String toString() {
		return "Docente [idDocente=" + idDocente + ", nombre=" + nombre + ", dni=" + dni + ", estado=" + estado
				+ ", fechaRegistro=" + fechaRegistro + ", ubigeo=" + ubigeo.getIdUbigeo() + "]";
	}
	
}
