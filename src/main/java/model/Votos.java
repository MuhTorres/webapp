package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "VOTOS")
public class Votos {
	@Id
	@Column(name = "VOTO_ID", insertable = false, updatable = false)
	private int id;

	@Column(name = "USER_ID")	
	private String titulo;

	@Column(name = "CAND_ID")
	private int candidato;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCandidato() {
		return candidato;
	}

	public void setCandidato(int candidato) {
		this.candidato = candidato;
	}	
}
