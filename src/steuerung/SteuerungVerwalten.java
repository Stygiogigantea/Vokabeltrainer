package steuerung;

import fachkonzept.Kasten;

public class SteuerungVerwaten{
   
    private Kasten derKasten;
    
    public SteuerungVerwaten(){
        derKasten = new Kasten();
    }

    public void geklicktAendern(int vokabelNr, String aufgabe, String ergebnis){
        derKasten.aendereVokabel(vokabelNr, aufgabe, ergebnis);
    }
    public void geklicktHinzufuegen(String aufgabe, String ergebnis){
        derKasten.fuegeVokabelHinzu(aufgabe, ergebnis);
    }
    public void geklicktLaden(String dateiname){
        derKasten.ladeVokabeln(dateiname);
    }
    public void geklicktLoeschen(int vokabelNr){
        derKasten.loescheVokabel(vokabelNr);
    }
    public void geklicktSpeichern(String dateiname){
        derKasten.speichereVokabeln(dateiname);
    }
} 