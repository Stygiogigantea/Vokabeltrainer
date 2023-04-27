package fachkonzept;

public class Vokabel
{
	private int vokabelNr;
	private String aufgabe;
	private String ergebnis;
	private boolean gekonnt;

	public Vokabel(int vokabelNr, String aufgabe, String ergebis,
			boolean gekonnt)
	{
		this.vokabelNr = vokabelNr;
		this.aufgabe = aufgabe;
		this.ergebnis = ergebis;
		this.gekonnt = gekonnt;
	}

	public boolean pruefeVermutung(String vermutung)
	{
		if (vermutung.equals(ergebnis))
			return true;
		else
			return false;
	}

	// XXX setters
	
	public void setzeVokabelNr(int vokabelNr)
	{
		this.vokabelNr = vokabelNr;
	}

	public void setzeAufgabe(String aufgabe)
	{
		this.aufgabe = aufgabe;
	}

	public void setzeErgebnis(String ergebnis)
	{
		this.ergebnis = ergebnis;
	}

	public void setzeGekonnt(boolean gekonnt)
	{
		this.gekonnt = gekonnt;
	}

	// XXX getters

	public int liesVokabelNr()
	{
		return vokabelNr;
	}

	public String liesAufgabe()
	{
		return aufgabe;
	}

	public String liesErgebnis()
	{
		return ergebnis;
	}

	public boolean istGekonnt()
	{
		return gekonnt;
	}

	
	//TODO add Exceptions �ndere & l�sche
}
