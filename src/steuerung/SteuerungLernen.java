package steuerung;

import fachkonzept.Kasten;

public class SteuerungLernen {
    private Kasten derKasten;
    
    public SteuerungLernen(){
        derKasten = new Kasten();
    }

    public void geklicktGebenAufgabe(){
        derKasten.gibNaechsteVokabel();
    }
    public void geklicktLaden(String dateiname) throws Exception{
        derKasten.ladeVokabeln(dateiname); //evtl Vokabel als Text returnen um sie in der GUI zu laden
    }
    public void geklicktPruefenVermutung(String vermutung){
        //TODO
    }
}
