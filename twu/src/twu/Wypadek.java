package twu;

import java.util.Calendar;
import java.util.Date;

public class Wypadek implements Comparable<Wypadek>{
	
	private Calendar dataWypadku;
	private String rejestracja;
	private Float kwotaOdszkodowania;
	private Auto auto;
	
	public Calendar getDataWypadku() {
		return dataWypadku;
	}
	public void setDataWypadku(Calendar dataWypadku) {
		this.dataWypadku = dataWypadku;
	}
	public String getRejestracja() {
		return rejestracja;
	}
	public void setRejestracja(String rejestracja) {
		this.rejestracja = rejestracja;
	}
	public Float getKwotaOdszkodowania() {
		return kwotaOdszkodowania;
	}
	public void setKwotaOdszkodowania(Float kwotaOdszkodowania) {
		this.kwotaOdszkodowania = kwotaOdszkodowania;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	public Wypadek(Calendar dataWypadku, String rejestracja, Float kwotaOdszkodowania) {
		this.dataWypadku = dataWypadku;
		this.rejestracja = rejestracja;
		this.kwotaOdszkodowania = kwotaOdszkodowania;
	}
	public int compareTo(Wypadek o) {
		return this.kwotaOdszkodowania.compareTo(o.kwotaOdszkodowania);
	}
	

}
