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
	
}
