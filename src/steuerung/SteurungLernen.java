package steuerung;

import fachkonzept.Kasten;

public class SteurungLernen {
    private Kasten derKasten;
    
    public SteurungLernen(){
        derKasten = new Kasten();
    }

    public void geklicktGebenAufgabe() throws Exception{
        derKasten.gibNaechsteVokabel();
    }
    public void geklicktLaden(String dateiname) throws Exception{
        derKasten.ladeVokabeln(dateiname);
    }
    public void geklicktPruefenVermutung(String vermutung){
        //TODO
    }
}
