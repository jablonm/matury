package main;

public class Slowo {

	private String slowo;
	private String klucz;
	private String slowoZaszyfrowane = "";
	private String slowoOdszyfrowane = "";
	
	public Slowo(String slowo, String klucz) {
		this.slowo = slowo;
		this.klucz = klucz;
		wyznaczKluczSzyfrowania();
		zaszyfruj();
		odszyfruj();
	}

	public void wyznaczKluczSzyfrowania() {
		if (klucz.length() < slowo.length()) {
			while (klucz.length() != slowo.length()) {
				if (klucz.length() < slowo.length() - klucz.length()) {
					klucz += klucz.substring(0, klucz.length());
				} else {
					klucz += klucz.substring(0, slowo.length() - klucz.length());
				}
			}
		}
	}
	
	public void zaszyfruj() {
		char[] znakiSlowa = slowo.toCharArray();
		char[] znakiKlucz = klucz.toCharArray();
		
		for (int x = 0; x<znakiSlowa.length && x<znakiKlucz.length; x++) {
			int znakiKluczSzyfr = znakiKlucz[x] - 64;
			int sumaZnakow = znakiSlowa[x] + znakiKluczSzyfr;
			if (sumaZnakow > 90) {
				sumaZnakow -= 26;
				slowoZaszyfrowane += ((char)sumaZnakow); 
			} else {
				slowoZaszyfrowane += ((char)sumaZnakow);
			}
		}
	}
	
	public void odszyfruj() {
		char[] znakiSlowaZaszyfrowanego = slowoZaszyfrowane.toCharArray();
		char[] znakiKlucza = klucz.toCharArray();
		
		for (int x = 0; x<znakiSlowaZaszyfrowanego.length && x<znakiKlucza.length; x++) {
			int znakiKluczaSzyfr = znakiKlucza[x] - 64;
			int sumaZnakow = znakiSlowaZaszyfrowanego[x] - znakiKluczaSzyfr;
			if (sumaZnakow < 65) {
				sumaZnakow += 26;
				slowoOdszyfrowane += ((char)sumaZnakow);
			} else {
				slowoOdszyfrowane += ((char)sumaZnakow);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Slowo [slowo=" + slowo + ", klucz=" + klucz + ", slowoZaszyfrowane=" + slowoZaszyfrowane
				+ ", slowoOdszyfrowane=" + slowoOdszyfrowane + "]";
	}
	
}
