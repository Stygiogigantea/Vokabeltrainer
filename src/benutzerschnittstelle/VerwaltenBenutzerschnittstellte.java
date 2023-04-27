package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fachkonzept.Vokabel;
import steuerung.SteuerungVerwalten;

import javax.management.StringValueExp;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VerwaltenBenutzerschnittstellte extends JFrame
{

	private JPanel contentPane;
	private JTextField txtDateiname;
	private SteuerungVerwalten steuerung;
	private JTable tblProdukte;
	private JScrollPane scrProdukte;
	private JTextField txtVokabelNr;
	private JTextField txtAufgabe;
	private JTextField txtErgebnis;
	private JTextField txtGekonnt;

	// XXX launch

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					VerwaltenBenutzerschnittstellte frame = new VerwaltenBenutzerschnittstellte();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	// XXX setup

	@SuppressWarnings({"serial", "serial"})
	public VerwaltenBenutzerschnittstellte()
	{
		// setup frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 402);
		setResizable(false);
		setName("Vokabletrainer Verwaltung");
		// setup ContentPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// setup SteuerungVerwalten
		steuerung = new SteuerungVerwalten();

		// setup Button "Speichern"
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// wenn "Speichern" geklickt:
				steuerung.geklicktSpeichern(txtDateiname.getText());
			}
		});
		btnSpeichern.setBounds(10, 329, 89, 23);
		contentPane.add(btnSpeichern);

		// setup Button "Laden"
		JButton btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// wenn "Laden" geklickt:
				steuerung.geklicktLaden(txtDateiname.getText());
			}
		});
		btnLaden.setBounds(109, 329, 89, 23);
		contentPane.add(btnLaden);

		// setup Button "Hinzufügen"
		JButton btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// wenn "Hinzufügen" geklickt:

				try
				{
					steuerung.geklicktHinzufuegen(txtAufgabe.getText(),
							txtErgebnis.getText());
				}
				catch (Exception e1)
				{
					System.out.println(e1.getLocalizedMessage());
				}
			}
		});
		btnHinzufuegen.setBounds(208, 329, 89, 23);
		contentPane.add(btnHinzufuegen);

		// setup Button "Ändere"
		JButton btnAendern = new JButton("\u00C4ndern");
		btnAendern.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// wenn "Ändern" geklickt:
				String strVkbNr = txtVokabelNr.getText();
				if (strVkbNr != null)
					steuerung.geklicktAendern(Integer.parseInt(strVkbNr),
							txtAufgabe.getText(), txtErgebnis.getText());
			}
		});
		btnAendern.setBounds(307, 329, 89, 23);
		contentPane.add(btnAendern);

		// setup Button "Löschen"
		JButton btnLoeschen = new JButton("L\u00F6schen");
		btnLoeschen.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// wenn "Löschen" geklickt:
				String str = txtVokabelNr.getText();
				if (str != null)
					steuerung.geklicktLoeschen(Integer.parseInt(str));
			}
		});
		btnLoeschen.setBounds(406, 329, 89, 23);
		contentPane.add(btnLoeschen);

		// setup TextField "Dateiname"
		txtDateiname = new JTextField();
		txtDateiname.setBounds(68, 8, 99, 20);
		contentPane.add(txtDateiname);
		txtDateiname.setColumns(10);

		// setup TextField "VokabelNr"
		txtVokabelNr = new JTextField();
		txtVokabelNr.setEditable(false);
		txtVokabelNr.setBounds(10, 298, 86, 20);
		contentPane.add(txtVokabelNr);
		txtVokabelNr.setColumns(10);

		// setup TextField "Aufgabe"
		txtAufgabe = new JTextField();
		txtAufgabe.setText("");
		txtAufgabe.setBounds(109, 298, 86, 20);
		contentPane.add(txtAufgabe);
		txtAufgabe.setColumns(10);

		// setup TextField "Ergebnis"
		txtErgebnis = new JTextField();
		txtErgebnis.setBounds(208, 298, 86, 20);
		contentPane.add(txtErgebnis);
		txtErgebnis.setColumns(10);

		// setup TextField "Gekonnt"
		txtGekonnt = new JTextField();
		txtGekonnt.setBounds(307, 298, 86, 20);
		contentPane.add(txtGekonnt);
		txtGekonnt.setColumns(10);

		// setup ScrollPane
		this.scrProdukte = new JScrollPane();
		this.scrProdukte.setBounds(10, 39, 485, 233);
		this.contentPane.add(this.scrProdukte);

		// setup Table
		this.tblProdukte = new JTable();
		tblProdukte.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// wenn zeile angeklickt:
				int ausgewaehlteZeile = tblProdukte.getSelectedRow();
				String str[] = new String[4];
				for (int i = 0; i < 4; i++) // TODO update code
					if (tblProdukte.getModel().getValueAt(ausgewaehlteZeile,
							i) != null)
						str[i] = tblProdukte.getModel()
								.getValueAt(ausgewaehlteZeile, i).toString();
				
				if (str[0] != null)
					txtVokabelNr.setText(str[0]);
				else
					txtVokabelNr.setText("");
				txtAufgabe.setText(str[1]);
				txtErgebnis.setText(str[2]);
				if (str[3] != null)
					txtGekonnt.setText(str[3]);
				else
					txtGekonnt.setText("");
			}
		});
		this.scrProdukte.setViewportView(this.tblProdukte);
		this.tblProdukte.setModel(new DefaultTableModel(
				new Object[][] {{null, null, null, null},},
				new String[] {"VokabelNr", "Aufgabe", "Ergebnis", "Gekonnt"})
		{
			Class[] columnTypes = new Class[] {Integer.class, String.class,
					String.class, Boolean.class};

			public Class getColumnClass(int columnIndex)
			{
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] {false, false, false,
					false};

			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});
		this.tblProdukte.getColumnModel().getColumn(0).setResizable(false);
		this.tblProdukte.getColumnModel().getColumn(1).setResizable(false);
		this.tblProdukte.getColumnModel().getColumn(2).setResizable(false);
		this.tblProdukte.getColumnModel().getColumn(3).setResizable(false);
		
		// setup Label
		JLabel lblDateiname = new JLabel("Dateiname:");
		lblDateiname.setBounds(10, 11, 89, 14);
		contentPane.add(lblDateiname);

		JLabel lblVokabelNr = new JLabel("VokabelNr");
		lblVokabelNr.setBounds(10, 283, 89, 14);
		contentPane.add(lblVokabelNr);

		JLabel lblAufgabe = new JLabel("Aufgabe");
		lblAufgabe.setBounds(109, 283, 46, 14);
		contentPane.add(lblAufgabe);

		JLabel lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(208, 283, 46, 14);
		contentPane.add(lblErgebnis);

		JLabel lblGekonnt = new JLabel("Gekonnt");
		lblGekonnt.setBounds(307, 283, 46, 14);
		contentPane.add(lblGekonnt);
	}
}
