package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Szyfrowanie {

	//https://www.cke.edu.pl/images/stories/00000000000000002012_matura2012/infor/a2_pr.pdf
	
	public static void main(String[] args) {
		Scanner scSlowa = null;
		Scanner scKlucze = null;
		try {
			scSlowa = new Scanner(new File("tj.txt"));
			scKlucze = new Scanner(new File("klucze.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scSlowa.hasNextLine() && scKlucze.hasNextLine()) {
			String haslo = scSlowa.nextLine();
			String klucz = scKlucze.nextLine();
					
			Slowo szyfr = new Slowo(haslo, klucz);
			System.out.println(szyfr);
		}
	}
	
}
