package dev.hotel.json;

import java.time.LocalDate;
import java.util.List;

public class ReservationJson {
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String numeroClient;
	private List<String> chambres;
	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param numeroClient
	 * @param chambres
	 */
	public ReservationJson(LocalDate dateDebut, LocalDate dateFin, String numeroClient, List<String> chambres) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.numeroClient = numeroClient;
		this.chambres = chambres;
	}
	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @return the numeroClient
	 */
	public String getNumeroClient() {
		return numeroClient;
	}
	/**
	 * @param numeroClient the numeroClient to set
	 */
	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}
	/**
	 * @return the chambres
	 */
	public List<String> getChambres() {
		return chambres;
	}
	/**
	 * @param chambres the chambres to set
	 */
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReservationJson [dateDebut=");
		builder.append(dateDebut);
		builder.append(", dateFin=");
		builder.append(dateFin);
		builder.append(", numeroClient=");
		builder.append(numeroClient);
		builder.append(", chambres=");
		builder.append(chambres);
		builder.append("]");
		return builder.toString();
	}
	
	

}
