//Deloppgave A av Oblig3
//Skrevet av Hans Petter de Fine (hptsfine)
//Innleveringsfrist 11.10.2013

import easyIO.*;

class Oblig3A {
    public static void main(String[] args) {
	//Main-metode, med validering for aa sikre at det kommer inn peker til en tekstfil
	if (args.length < 1) {
	    System.out.println("Skriv: > java Oblig3A <tekstfil>");
	}//Avslutter if 
	else {
	    String  filnavn = args[0];
	    OrdAnalyse oa = new OrdAnalyse();
	    oa.analyser(filnavn);
	}//Avslutter else
    }//Avslutter metoden main
}//Avslutter klassen Oblig3

class OrdAnalyse {
   
    String[] ord = new String[5000];
    int[] antall = new int[5000];
    int antUnikeOrd = 0;
    int lengde = 0;
    Out tilfil = new Out("oppsummering.txt");

    //Analyser-metode i klassen OrdAnalyse, brukes for aa kalle de andre metodene i klassen
    void analyser(String filnavn) {

	telleOppOrd(filnavn);
	skrivTilFil();

    }//Avslutter metoden analyser

    //Egen metode for aa telle opp alle ordene i tekst-filen
    void telleOppOrd(String filnavn) {
	In frafil = new In(filnavn);
   
	for (int i = 1; !frafil.endOfFile(); i++) {
	    String s = frafil.inWord();
	    int sum = 0;
  
	    for (int j = 0; j < ord.length; j++) {
		String t = ord[j];
		if (s.equalsIgnoreCase(t)) {
		    antall[j]++;
		    sum++;
		}//Avslutter if
	    }//Avslutter indre for-loekke

	    if (sum == 0) {
		ord[antUnikeOrd] = s;
		antall[antUnikeOrd] = 1;
		antUnikeOrd++;	     
	    }//Avslutter if
	    lengde = i;
	}//Avslutter for-loekka
	
	frafil.close();

    }//Avslutter metoden telleOppOrd
	
	//Metode for aa skrive fra en fil til en annen fil
    void skrivTilFil() {

	tilfil.outln("Antall ord lest: " + lengde + " og antall unike ord: " + antUnikeOrd + ".");
	filLinje(1);

	for (int i = 0; i < antUnikeOrd; i++) {
	    tilfil.out(ord[i], 20);
	    tilfil.outln(antall[i], 5, Out.LEFT);
	}//Avslutter for-loekka

	tilfil.close();
    }//Avslutter metoden skrivTilFil
	
	//Metode for aa legge inn tomme linjer i filen
    void filLinje(int y) { 
	
	for (int i = 0; i < y; i++) {
	    tilfil.outln("");
	}//Avslutter for-loekken
    }//Avslutter metoden filLinje
	
}//Avslutter klassen OrdAnalyse
