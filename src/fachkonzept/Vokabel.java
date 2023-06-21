package fachkonzept;
public class Vokabel {
    private int vokabelNr;
    private String aufgabe;
    private String ergebnis;
    private boolean gekonnt;
    
    public Vokabel(int vokabelNr, String aufgabe, String ergebis, boolean gekonnt){
        this.vokabelNr = vokabelNr;
        this.aufgabe = aufgabe;
        this.ergebnis = ergebis;
        this.gekonnt = gekonnt;
    }

    public boolean pruefeVermutung(String vermutung){
        if(vermutung.equals(ergebnis))
            return true;
        return false;
    }
    public void setzeGekonnt(boolean gekonnt){
        this.gekonnt = gekonnt;
    }
    //getter
    public int liesVokabelNr(){
        return vokabelNr;
    }
    public String liesAufgabe(){
        return aufgabe;
    }
    public String liesErgebnis(){
        return ergebnis;
    }
    public boolean istGekonnt(){
        return gekonnt;
    }

}
 