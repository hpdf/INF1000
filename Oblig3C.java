//Skrevet av Hans Petter de Fine / hptsfine
//Dato 11.10.13

import easyIO.*;

class Oblig3C {
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



    }//Avslytter metoden main
}//Avslutter klassen Oblig3

class OrdAnalyse {
    Out skjerm = new Out();
   
    String[] ord = new String[5000];
    int[] antall = new int[5000];
    int antUnikeOrd = 0;
    int lengde = 0;

    //Analyse-metode i klassen OrdAnalyse, brukes for aa kalle de andre metodene i klassen
    void analyser(String filnavn) {

	telleOppOrd(filnavn);
	skrivTilFil();
	vanligeOrd();
	ordPar();

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
	Out tilfil = new Out("oppsummering.txt");
	tilfil.outln("Antall ord lest: " + lengde + " og antall unike ord: " + antUnikeOrd + ".");
	tilfil.outln("");
	for (int i = 0; i < antUnikeOrd; i++) {
	    tilfil.out(ord[i], 20);
	    tilfil.outln(antall[i], 5, Out.LEFT);
	}//Avslutter for-loekka

	tilfil.close();
    }//Avslutter metoden skrivTilFil

    //Metode for aa finne det ordet som er brukt flest ganger i filen
    int finneStoerste() {
	int maks = antall[0];
	for (int i =1; i < antall.length; i++) {
	    if (antall[i] > maks) {
		    maks = antall[i];
		}//Avslutter if
	}//Avslutter for-loekka
	    return maks;
    }//Avslutter metoden finneStoerste

    //Metode for aa skrive ut paa skjermen de ordene som er brukt mer enn ti prosent av det ordet som er brukt mest
    void vanligeOrd() {
	//Prosenten settes som int selv om den er et desimaltall, siden antall bare er i heltall. Runder ikke av.
	int prosent = 10;
	int tiprosent = finneStoerste() / 100*prosent;

	for (int i = 0; i < antall.length; i++) {
	    if (tiprosent <= antall[i]) {
		skjerm.out("Vanlige ord: " + ord[i], 20);
		skjerm.out("(" + antall[i], 5);
		skjerm.outln(" forekomster)");
	     
	    }//Avslutter if-loekken
	}//Avslutter for-loekken

    }//Avslutter metoden vanligeOrd


    void ordPar () {
	int[][] antallPar = new int[antUnikeOrd][antUnikeOrd];
	antallPar[4][4] = 9;
	skjerm.out("Ordpar 4 er: ");
	skjerm.outln(antallPar[4][4]);
    }//Avslutter metoden ordPar

}//Avslutter klassen OrdAnalyse