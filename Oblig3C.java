//Deloppgave C av Oblig3
//Skrevet av Hans Petter de Fine (hptsfine)
//Innleveringsfrist 11.10.2013

import easyIO.*;

class Oblig3C {
    public static void main (String[] args) {
	//Main-metode, med validering for aa sikre at det kommer inn peker til en tekstfil
	if (args.length < 1) {
	    System.out.println("Skriv: > java Oblig3B <tekstfil>");
	}//Avslutter if 
	else {
	        String  filnavn = args[0];
		Ordpar op = new Ordpar();
		op.finneOrdpar(filnavn);

	}//Avslutter else
    }//Avslutter main-metoden
}//Avslutter klassen Oblig3C

//En klasse for aa telle opp antall ordpar i filen
class Ordpar {
    Out skjerm = new Out();
    FinneOrd fo = new FinneOrd();
    OrdAnalyse oa = new OrdAnalyse();  	
 


    
    //Metode for aa kalle de andre metodene som brukes
    void finneOrdpar(String filnavn) {

	oa.analyser(filnavn);
	telleOppAntallPar(filnavn);
	//	skriveUtAlice();
	
    }//Avslutter metoden finneOrdPar

    //Metode for aa telle opp antall ordpar som brukes i filen
    void telleOppAntallPar(String filnavn) {

	In frafil = new In(filnavn);
	String ordet = frafil.inWord();
	int[][] antallPar = new int[oa.antUnikeOrd][oa.antUnikeOrd];

	String finn = "alice";
	boolean funn = false;
	int posisjon = 0;

	while (!frafil.endOfFile()) {
	    String forrigeOrd = ordet;
	    boolean funneti = false;
	    boolean funnetj = false;

	    for (int i = 0;i < oa.antUnikeOrd && !funneti; i++) {
		if (oa.ord[i].equalsIgnoreCase(forrigeOrd)) {
		    funneti = true;
		    ordet = frafil.inWord();
		    for (int j = 0; j < oa.antUnikeOrd && !funnetj; j++) {
			if (oa.ord[j].equalsIgnoreCase(ordet)) {
			    funnetj = true; 
			    antallPar[i][j]++;
			}//Avslutter if
		    }//Avslutter while
		}//Avslutter if
	    }//Avslutter while	
	}//Avslutter ytterste while


	//Tester metoden ved aa skrive ut alle ord som etterfoelger Alice
	//Finner hvilken posisjon i ord-arrayen Alice staar
	for (int i = 0; i < oa.antUnikeOrd; i++) {
	    if (oa.ord[i].equalsIgnoreCase(finn)) {
		funn = true;
		posisjon = i;
	    }//Avslutter if      
	}//Avslutter for-loekka
	
	//Skriver ut alle ordene som er brukt etter denne posisjonen
	if (funn == true) {
	    fo.skjermLinje(75);
	    skjerm.outln("Etter " + oa.ord[posisjon] + " har disse ordene blitt brukt:");
	    fo.skjermLinje(1);
	    for (int j = 0; j < antallPar.length; j++) {
		if (antallPar[posisjon][j] > 0) {
		    skjerm.outln(oa.ord[j]);
		}//Avslutter if
	    }//Avslutter for-loekke
	}//Avslutter if
	else {
	    fo.skjermLinje(1);
	    skjerm.outln("Finner ikke Alice, let i naermeste kaninhule.");
	}//Avslutter else
    }//Avslutter metoden telleOppAntallPar	
}//Avslutter klassen Ordpar
