package twu;

import java.util.ArrayList;

public class Auto {

	private String rejestracja;
	private String marka;
	private String rokProdukcji;
	private String peselWlasciciela;
	private Osoba wlasciciel;
	private ArrayList<Wypadek> listaWypadkow = new ArrayList<Wypadek>();
	
	public String getRejestracja() {
		return rejestracja;
	}
	public void setRejestracja(String rejestracja) {
		this.rejestracja = rejestracja;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getRokProdukcji() {
		return rokProdukcji;
	}
	public void setRokProdukcji(String rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	public String getPeselWlasciciela() {
		return peselWlasciciela;
	}
	public void setPeselWlasciciela(String peselWlasciciela) {
		this.peselWlasciciela = peselWlasciciela;
	}
	public Osoba getWlasciciel() {
		return wlasciciel;
	}
	public void setWlasciciel(Osoba wlasciciel) {
		this.wlasciciel = wlasciciel;
	}
	public ArrayList<Wypadek> getListaWypadkow() {
		return listaWypadkow;
	}
	public void setListaWypadkow(ArrayList<Wypadek> listaWypadkow) {
		this.listaWypadkow = listaWypadkow;
	}
	
	public void dodajWypadek(Wypadek wypadek) {
		listaWypadkow.add(wypadek);
		//System.out.println("Dodano wypadek " + wypadek.getDataWypadku() + " do auta " + this.getRejestracja());
	}
	
	public boolean czyWypadek() {
		if (listaWypadkow.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public Auto(String rejestracja, String marka, String rokProdukcji, String peselWlasciciela) {
		this.rejestracja = rejestracja;
		this.marka = marka;
		this.rokProdukcji = rokProdukcji;
		this.peselWlasciciela = peselWlasciciela;
	}
	
}
