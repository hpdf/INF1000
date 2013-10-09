//Deloppgave B av Oblig3
//Skrevet av Hans Petter de Fine (hptsfine)
//Innleveringsfrist 11.10.2013

import easyIO.*;

class Oblig3B {
    public static void main(String[] args) {
	//Main-metode, med validering for aa sikre at det kommer inn peker til en tekstfil
	if (args.length < 1) {
	    System.out.println("Skriv: > java Oblig3B <tekstfil>");
	}//Avslutter if 
	else {
	    String  filnavn = args[0];
	    FinneOrd fo = new FinneOrd();
	    fo.ordFinner(filnavn);

	}//Avslutter else
    }//Avslutter metoden main
}//Avslutter klassen Oblig3

class FinneOrd {
    Out skjerm = new Out();
    OrdAnalyse oa = new OrdAnalyse();
    
    //Metode for aa kalle andre metoder i klassen FinneOrd og andre klasser
    void ordFinner(String filnavn) {

	oa.telleOppOrd(filnavn);
	vanligeOrd();

    }//Avslutter metoden ordFinner
	

 //Metode for aa skrive ut paa skjermen de ordene som er brukt mer enn ti prosent av det ordet som er brukt mest
    void vanligeOrd() {

	//Prosenten settes som int selv om den er et desimaltall, siden antall bare er i heltall. Runder ikke av.
	int prosent = 10;
	int tiprosent = finneStoerste() / 100 * prosent;

	skjermLinje(75);
	skjerm.outln("De mest vanlige ordene i filen er:");
	skjermLinje(1);

	for (int i = 0; i < oa.antall.length; i++) {
	    if (tiprosent <= oa.antall[i]) {
		skjerm.out("Vanlige ord: " + oa.ord[i], 20);
		skjerm.out("(" + oa.antall[i], 5);
		skjerm.outln(" forekomster)");
	     
	    }//Avslutter if-loekken
	}//Avslutter for-loekken

    }//Avslutter metoden valigeOrd

    //Metode for aa finne det ordet som er brukt flest ganger i filen
    int finneStoerste() {
	int maks = oa.antall[0];
	for (int i =1; i < oa.antall.length; i++) {
	    if (oa.antall[i] > maks) {
		maks = oa.antall[i];
	    }//Avslutter if
	}//Avslutter for-loekka
	return maks;
    }//Avslutter metoden finneStoerste

	
    //Metode for aa legge inn tomme linjer paa skjermutskriften
    void skjermLinje(int y) { 
	
	for (int i = 0; i < y; i++) {
	    skjerm.outln("");
	}//Avslutter for-loekken
    }//Avslutter metoden skjermLinje	
}//Avslutter klassen FinneOrd

