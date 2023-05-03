package datenspeicherung;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fachkonzept.Vokabel;

public class Speicher
{
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private String accdbLocation; 
	
	public Speicher() {
		System.out.println(new File("VokabeltrainerDB.accdb").getAbsolutePath());
		accdbLocation = "jdbc:ucanaccess:VokabeltrainerDB.accdb";
		//TODO update
		
	}
	
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
					"Fehler beim Lesen der Vokabeln! (Speicher: Z.38)");
		}

		schliesseDatenbank();
		return ergebnis;

	}

	private int getKastenNr(String dateiname) throws Exception //TODO remove
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
					"Fehler beim Lesen der kastenNr! (Speicher: Z.66)");
		}

		schliesseDatenbank();
		return erg;
	}

	public void schreibeVokabeln(String dateiname, ArrayList<Vokabel> vokabeln)
			throws Exception
	{
		oeffneDatenbank();

		for (int i = 0, l = vokabeln.size(); i < l; i++)
		{
			String sqlStmt = "INSERT INTO vokabel (id, term, ergebnis, gekonnt)";
			sqlStmt += " VALUES (?, ?, ?, ?)";

			try
			{
				stmt = con.prepareStatement(sqlStmt);

				// setze "?" werte
				stmt.setInt(1, vokabeln.get(i).liesVokabelNr());
				stmt.setString(2, vokabeln.get(i).liesAufgabe());
				stmt.setString(3, vokabeln.get(i).liesErgebnis());
				stmt.setBoolean(4, vokabeln.get(i).istGekonnt());

				// querry ausführen
				stmt.executeUpdate();
			}
			catch (SQLException e)
			{
				throw new Exception("Fehler beim Hinzufügen des Produkts!");
			}
		}

		schliesseDatenbank();
	}

	private void oeffneDatenbank() throws Exception
	{
		try
		{
			con = DriverManager.getConnection(accdbLocation);
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim oeffnen der Datenbank!");
		}
	}

	private void schliesseDatenbank() throws Exception
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			stmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			throw new Exception("Fehler beim Schliessen der Datenbank!");
		}
	}
}
