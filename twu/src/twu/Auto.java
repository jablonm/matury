package twu;

import java.util.ArrayList;
import java.util.Comparator;

public class Auto implements Comparable<Auto>, Comparator<Auto>{

	private String rejestracja;
	private String marka;
	private String rokProdukcji;
	private String peselWlasciciela;
	private Osoba wlasciciel;
	private ArrayList<Wypadek> listaWypadkow = new ArrayList<Wypadek>();
	private Integer iloscWypadkow;
	
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
//		if (listaWypadkow.isEmpty()) {
//			return false;
//		} else {
//			return true;
//		}
		return listaWypadkow.isEmpty() == false;
	}
	
	public Auto(String rejestracja, String marka, String rokProdukcji, String peselWlasciciela) {
		this.rejestracja = rejestracja;
		this.marka = marka;
		this.rokProdukcji = rokProdukcji;
		this.peselWlasciciela = peselWlasciciela;
		iloscWypadkow = listaWypadkow.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaWypadkow == null) ? 0 : listaWypadkow.hashCode());
		result = prime * result + ((marka == null) ? 0 : marka.hashCode());
		result = prime * result + ((peselWlasciciela == null) ? 0 : peselWlasciciela.hashCode());
		result = prime * result + ((rejestracja == null) ? 0 : rejestracja.hashCode());
		result = prime * result + ((rokProdukcji == null) ? 0 : rokProdukcji.hashCode());
		result = prime * result + ((wlasciciel == null) ? 0 : wlasciciel.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (listaWypadkow == null) {
			if (other.listaWypadkow != null)
				return false;
		} else if (!listaWypadkow.equals(other.listaWypadkow))
			return false;
		if (marka == null) {
			if (other.marka != null)
				return false;
		} else if (!marka.equals(other.marka))
			return false;
		if (peselWlasciciela == null) {
			if (other.peselWlasciciela != null)
				return false;
		} else if (!peselWlasciciela.equals(other.peselWlasciciela))
			return false;
		if (rejestracja == null) {
			if (other.rejestracja != null)
				return false;
		} else if (!rejestracja.equals(other.rejestracja))
			return false;
		if (rokProdukcji == null) {
			if (other.rokProdukcji != null)
				return false;
		} else if (!rokProdukcji.equals(other.rokProdukcji))
			return false;
		if (wlasciciel == null) {
			if (other.wlasciciel != null)
				return false;
		} else if (!wlasciciel.equals(other.wlasciciel))
			return false;
		return true;
	}
	
	public int compareTo(Auto o) {
		return this.iloscWypadkow.compareTo(o.iloscWypadkow);
	}
	
	public int compare(Auto o1, Auto o2) {
		if (o1.iloscWypadkow > o2.iloscWypadkow) {
			return 1;
		} else if (o1.iloscWypadkow < o2.iloscWypadkow) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
