package steuerung;

import fachkonzept.Kasten;

public class SteuerungLernen {
    private Kasten derKasten;
    
    public SteuerungLernen(){
        derKasten = new Kasten();
    }

<<<<<<< HEAD
    public void geklicktGebenAufgabe() throws Exception{
        derKasten.gibNaechsteVokabel();
    }
    public void geklicktLaden(String dateiname) throws Exception{
        derKasten.ladeVokabeln(dateiname);
=======
    public void geklicktGebenAufgabe(){
        derKasten.gibNaechsteVokabel();
    }
    public void geklicktLaden(String dateiname) throws Exception{
        derKasten.ladeVokabeln(dateiname); //evtl Vokabel als Text returnen um sie in der GUI zu laden
>>>>>>> 4f125b29ef88922f6b7e71c121c17b69637a1887
    }
    public void geklicktPruefenVermutung(String vermutung){
        //TODO
    }
}
