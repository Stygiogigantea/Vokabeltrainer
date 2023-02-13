package steuerung;

import fachkonzept.Kasten;

public class SteurungLernen {
    private Kasten derKasten;
    
    public SteurungLernen(){
        derKasten = new Kasten();
    }

    public void geklicktGebenAufgabe(){
        derKasten.gibNaechsteVokabel();
    }
    public void geklicktLaden(String dateiname){
        derKasten.ladeVokabeln(dateiname);
    }
    public void geklicktPruefenVermutung(String vermutung){
        //TODO
    }
}
