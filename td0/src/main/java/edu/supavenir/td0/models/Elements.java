package edu.supavenir.td0.models;

import java.util.Objects;

public class Elements {

	private String nom;
	private int evalutaion;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEvalutaion() {
		return evalutaion;
	}

	public void setEvalutaion(int evalutaion) {
		this.evalutaion = evalutaion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elements other = (Elements) obj;
		return evalutaion == other.evalutaion && Objects.equals(nom, other.nom);
	}

}
