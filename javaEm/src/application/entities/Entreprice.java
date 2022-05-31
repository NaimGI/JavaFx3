package application.entities;

import java.util.HashMap;

public class Entreprice {
	private String nomEntreprise;
	private HashMap<Integer, Salaire> salaries;

	public Entreprice(String nomEntreprise) {
		super();
		this.nomEntreprise = nomEntreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public HashMap<Integer, Salaire> getSalaries() {
		return salaries;
	}

	public void setSalaries(HashMap<Integer, Salaire> salaries) {
		this.salaries = salaries;
	}

}
