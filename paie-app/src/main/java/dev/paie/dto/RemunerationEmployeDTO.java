package dev.paie.dto;

public class RemunerationEmployeDTO {

	private String matricule;
	private String nomEntreprise;
	private String titreProfil;
	private String grade;
	/**
	 * @param matricule
	 * @param nomEntreprise
	 * @param titreProfil
	 * @param grade
	 */
	public RemunerationEmployeDTO(String matricule, String nomEntreprise, String titreProfil, String grade) {
		this.matricule = matricule;
		this.nomEntreprise = nomEntreprise;
		this.titreProfil = titreProfil;
		this.grade = grade;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the nomEntreprise
	 */
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	/**
	 * @param nomEntreprise the nomEntreprise to set
	 */
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	/**
	 * @return the titreProfil
	 */
	public String getTitreProfil() {
		return titreProfil;
	}
	/**
	 * @param titreProfil the titreProfil to set
	 */
	public void setTitreProfil(String titreProfil) {
		this.titreProfil = titreProfil;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
