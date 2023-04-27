package fachkonzept;

import datenspeicherung.Speicher;
import java.util.ArrayList;

public class Kasten
{
	private ArrayList<Vokabel> vokabeln;
	private Speicher derSpeicher;

	public Kasten()
	{
		derSpeicher = new Speicher();
	}

	public void aendereVokabel(int vokabelNr, String aufgabe, String ergebnis)
	{
		
		for (int i = 0; i < vokabeln.size(); i++)
			if (vokabeln.get(i).liesVokabelNr() == vokabelNr)
				vokabeln.set(i,
						new Vokabel(vokabelNr, aufgabe, ergebnis, false));
	}

	private boolean alleVokabelnGekonnt()
	{
		for (int i = 0; i < vokabeln.size(); i++)
		{
			if (!vokabeln.get(i).istGekonnt())
				return false;
		}
		return true;
	}

	public void fuegeVokabelHinzu(String aufgabe, String ergebnis)
			throws Exception
	{
		vokabeln.add(
				new Vokabel(gibNaechsteVokabelNr(), aufgabe, ergebnis, false));
	}

	public Vokabel gibNaechsteVokabel() throws Exception
	{
		return vokabeln.get(gibNaechsteVokabelNr());
	}

	private int gibNaechsteVokabelNr() throws Exception
	{
		if (vokabeln != null)
			return vokabeln.size();
		else
			throw new Exception("Error: Vokabeln nicht geladen!");
	}

	public void ladeVokabeln(String dateiname)
	{
		try
		{
			vokabeln = derSpeicher.liesVokabeln(dateiname);
		}
		catch (Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}

	public ArrayList<Vokabel> liesVokabeln()
	{
		return vokabeln;
	}

	public void loescheVokabel(int vokabelNr)
	{
		for (int i = 0; i < vokabeln.size(); i++)
			if (vokabeln.get(i).liesVokabelNr() == vokabelNr)
				vokabeln.remove(vokabelNr);
	}

	public void nimmVokabelZurueck(Vokabel vokabel)
	{
		// TODO
	}

	private void setzeZurueckGekonnt()
	{
		for (int i = 0; i < vokabeln.size(); i++)
			vokabeln.get(i).setzeGekonnt(true);
	}

	public void speichereVokabeln(String dateiname)
	{
		try
		{
			derSpeicher.schreibeVokabeln(dateiname, vokabeln);
		}
		catch (Exception e)
		{
			System.out.println(e.getLocalizedMessage());
			// TODO update code
		}
	}
}
