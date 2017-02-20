package twu;

import java.util.ArrayList;

public class Osoba {
	
	private String pesel;
	private String imie;
	private String nazwisko;
	private Miejscowosc miejscowosc;
	private ArrayList<Auto> listaAut = new ArrayList<Auto>();
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Miejscowosc getMiejscowosc() {
		return miejscowosc;
	}
	public void setMiejscowosc(Miejscowosc miejscowosc) {
		this.miejscowosc = miejscowosc;
	}
	
	public void dodajAuto(Auto auto) {
		listaAut.add(auto);
		//System.out.println("Dodano auto " + auto.getRejestracja() + " do właścicila " + this.getPesel());
	}
	
	public ArrayList<Auto> listaAut() {
		return listaAut;
	}
	
	public Osoba(String pesel, String imie, String nazwisko, Miejscowosc miejscowosc) {
		this.pesel = pesel;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
	}
	
	@Override
	public String toString() {
		return "Osoba [pesel=" + pesel + ", imie=" + imie + ", nazwisko=" + nazwisko + ", miejscowosc=" + miejscowosc.getTypMiejscowosci()
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((listaAut == null) ? 0 : listaAut.hashCode());
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
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
		Osoba other = (Osoba) obj;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (listaAut == null) {
			if (other.listaAut != null)
				return false;
		} else if (!listaAut.equals(other.listaAut))
			return false;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}
	
}
