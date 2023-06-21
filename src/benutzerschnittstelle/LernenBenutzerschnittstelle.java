package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import steuerung.SteuerungLernen;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class LernenBenutzerschnittstelle extends JFrame
{

	private JPanel contentPane;
	private JButton btnVokabelnVerwalten;
	private JTextField textTermAbfrage;
	private JTextField textDefinitionEingabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LernenBenutzerschnittstelle frame = new LernenBenutzerschnittstelle();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public LernenBenutzerschnittstelle()
	{
		JFrame lernGUI = new JFrame();
<<<<<<< HEAD
		final SteuerungLernen dieSteuerungLernen = new SteuerungLernen();
=======
		SteuerungLernen dieSteuerungLernen = new SteuerungLernen();
>>>>>>> 4f125b29ef88922f6b7e71c121c17b69637a1887
		lernGUI.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Not supported yet.");
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Not supported yet.");
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
<<<<<<< HEAD
				if(e.getKeyCode() == KeyEvent.VK_ENTER) //Enter taste zur Abgabe nutzen
=======
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
>>>>>>> 4f125b29ef88922f6b7e71c121c17b69637a1887
				{
					//TODO
					dieSteuerungLernen.geklicktPruefenVermutung(textDefinitionEingabe.getText()); // Text aus Definitionsfeld lesen und pruefen
				}
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVokabelnVerwalten = new JButton("VokabelnVerwalten");
		btnVokabelnVerwalten.setBounds(5, 5, 426, 23);
		btnVokabelnVerwalten.setToolTipText("Klicken Sie diesen Knopf um zur Verwaltungsansicht zu wechseln");
		contentPane.add(btnVokabelnVerwalten);
		
		textTermAbfrage = new JTextField();
		textTermAbfrage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTermAbfrage.setToolTipText("Zeigt den Term an, den Sie definieren muessen");
		textTermAbfrage.setEditable(false);
		textTermAbfrage.setBounds(145, 100, 116, 38);
		contentPane.add(textTermAbfrage);
		textTermAbfrage.setColumns(10);
		
		textDefinitionEingabe = new JTextField();
		textDefinitionEingabe.setToolTipText("Geben Sie hier die Definition des abgefragten Termes an.\r\nDrucken Sie Enter um ihre Antwort einzureichen");
		textDefinitionEingabe.setBounds(70, 150, 261, 31);
		contentPane.add(textDefinitionEingabe);
		textDefinitionEingabe.setColumns(10);
	}
