package datenspeicherung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import fachkonzept.Vokabel;

public class Speicher {
    
	private Connection con; // Data base connection
	private PreparedStatement stmt; // SQL querry statement
	private ResultSet rs; // resultat der ausgeführten querry

	public ArrayList<Vokabel> liesVokabeln(String dateiname) throws Exception
	{
		oeffneDatenbank();

		String sqlStmt = "SELECT id,term,ergebnis,gekonnt";
		sqlStmt += "FROM vokabeln";
		sqlStmt += ("WHERE vokabeln.kastenNr = " + getKastenNr(dateiname));

		ArrayList<Vokabel> ergebnis = new ArrayList<>();
		try
		{
			stmt = con.prepareStatement(sqlStmt);
			rs = stmt.executeQuery();

			while (rs.next())
				ergebnis.add(new Vokabel(rs.getInt("id"), rs.getString("term"),
						rs.getString("ergebnis"), rs.getBoolean("gekonnt")));
		}
		catch (SQLException e)
		{
			throw new Exception(
					"Fehler beim Lesen der Vokabeln! (Speicher: Z.48)");
		}

		schliesseDatenbank();
		return ergebnis;

	}

	private int getKastenNr(String dateiname) throws Exception
	{
		oeffneDatenbank();

		String sqlStmt = "SELECT kastenNr";
		sqlStmt += "FROM kasten";
		sqlStmt += ("WHERE kastenName = " + dateiname);

		int erg = 0;
		try
		{
			stmt = con.prepareStatement(sqlStmt);
			rs = stmt.executeQuery();

			if (rs.next())
				erg = rs.getInt("id");
		}
		catch (SQLException e)
		{
			throw new Exception(
					"Fehler beim Lesen der kastenNr! (Speicher: Z.75)");
		}

		schliesseDatenbank();
		return erg;
	}

    public schreibeVokabeln(String dateiname, ArrayList<Vokabel> vokabeln){
        //TODO
    }
}
