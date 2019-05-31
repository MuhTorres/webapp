package model;

import javax.persistence.*;

@Entity(name="CANDIDATOS")
public class Candidato {

	@Id
	@Column(name = "NUMERO")
	private int numero;

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "VOTOS")
	private int votos;	

    public int getNumero() 
    {
		return this.numero;
    }
    
    public int getVotos() 
    {
		return this.votos;
    }
    
    public String getNome()
    {
		return this.nome;
    }
}
