package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

import twu.Auto;
import twu.Miejscowosc;
import twu.Miejscowosc.TypMiejscowosci;
import twu.Osoba;
import twu.Wypadek;

// https://www.cke.edu.pl/images/stories/Arkusze08matura/inform_cz_2.pdf

public class Main {

	public static void main(String[] args) {

		ArrayList<Osoba> listaWlascicieli = new ArrayList<Osoba>();
		ArrayList<Auto> listaAut = new ArrayList<Auto>();
		ArrayList<Wypadek> listaWypadkow = new ArrayList<Wypadek>();

		Scanner scOsoba = null;
		Scanner scAuto = null;
		Scanner scWypadek = null;
		try {
			scOsoba = new Scanner(new File("osoby.txt"));
			scAuto = new Scanner(new File("auta.txt"));
			scWypadek = new Scanner(new File("wypadki.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scOsoba.hasNextLine()) {
			String osobaLine = scOsoba.nextLine();
			String[] osobaParam = osobaLine.split(" ");

			TypMiejscowosci typMiejscowosci = TypMiejscowosci.valueOf(osobaParam[3]);
			Miejscowosc miejscowosc = new Miejscowosc(typMiejscowosci);

			Osoba osoba = new Osoba(osobaParam[0], osobaParam[1], osobaParam[2], miejscowosc);
			listaWlascicieli.add(osoba);
		}

		while (scAuto.hasNextLine()) {
			String autoLine = scAuto.nextLine();
			String[] autoParam = autoLine.split(" ");

			Auto auto = new Auto(autoParam[0], autoParam[1], autoParam[2], autoParam[3]);
			for (Osoba wlasciciel : listaWlascicieli) {
				if (wlasciciel.getPesel().equals(autoParam[3])) {
					auto.setWlasciciel(wlasciciel);
				}
			}
			listaAut.add(auto);
		}

		while (scWypadek.hasNextLine()) {
			DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			Calendar cal = Calendar.getInstance();
			String wypadekLine = scWypadek.nextLine();
			String[] wypadekParam = wypadekLine.split(" ");
			Wypadek wypadek;

			try {
				cal.setTime(format.parse(wypadekParam[1]));
				wypadek = new Wypadek(cal, wypadekParam[2], Float.parseFloat(wypadekParam[3]));
				listaWypadkow.add(wypadek);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		for (Osoba osoba : listaWlascicieli) {
			for (Auto auto : listaAut) {
				if (auto.getPeselWlasciciela().equals(osoba.getPesel())) {
					osoba.dodajAuto(auto);
				}
			}
		}

		for (Wypadek wypadek : listaWypadkow) {
			for (Auto auto : listaAut) {
				if (wypadek.getRejestracja().equals(auto.getRejestracja())) {
					auto.dodajWypadek(wypadek);
				}
			}
		}

		// Zadanie 1:
		int ileOsobMialoWypadek = 0;
		for (Osoba osoba : listaWlascicieli) {
			boolean czyWypadek = false;
			for (Auto auto : osoba.listaAut()) {
				if (auto.czyWypadek() == true) {
					czyWypadek = true;
				}
			}
			if (czyWypadek == true) {
				ileOsobMialoWypadek++;
			}
		}
		System.out.println("1. " + ileOsobMialoWypadek + " osób miało przynajmniej jeden wypadek.");

		// Zadanie 2:
		Wypadek najwiekszeOdszkodowanie = Collections.max(listaWypadkow);
		for (Auto auto : listaAut) {
			for (Wypadek wypadek : auto.getListaWypadkow()) {
				if (wypadek.equals(najwiekszeOdszkodowanie)) {
					Osoba wlascicielNajwiekszeOdszkodowanie = auto.getWlasciciel();
					System.out.println(
							"2. " + "Największe odszkodowanie wypłacono " + wlascicielNajwiekszeOdszkodowanie.getImie()
									+ " " + wlascicielNajwiekszeOdszkodowanie.getNazwisko() + " dla samochodu "
									+ auto.getRejestracja() + " w kwocie " + wypadek.getKwotaOdszkodowania() + ".");
				}
			}
		}

		 // Zadanie 3;
		Float sumaOdszkodowan2006 = 0.0f;
		Float sumaOdszkodowan2007 = 0.0f;
		Calendar cal2006 = Calendar.getInstance();
		cal2006.set(Calendar.YEAR, 2006);
		Calendar cal2007 = Calendar.getInstance();
		cal2007.set(Calendar.YEAR, 2007);
		
		for (Wypadek wypadek : listaWypadkow) {
			if (cal2006.get(Calendar.YEAR) == wypadek.getDataWypadku().get(Calendar.YEAR)) {
				sumaOdszkodowan2006 += wypadek.getKwotaOdszkodowania();
				//System.out.println(cal.get(Calendar.YEAR) + " " + wypadek.getDataWypadku().get(Calendar.YEAR));
			} else if (cal2007.get(Calendar.YEAR) == wypadek.getDataWypadku().get(Calendar.YEAR)) {
				sumaOdszkodowan2007 += wypadek.getKwotaOdszkodowania();
			}
		}
		System.out.println("3. " + "Suma odszkodowań 2006: " + sumaOdszkodowan2006 + ", 2007: " + sumaOdszkodowan2007 + ".");
	}

}
