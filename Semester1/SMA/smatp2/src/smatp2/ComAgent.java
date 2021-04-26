/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smatp2;

/**
 *
 * @author acer
 */
import jade.core.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;



public class ComAgent extends Agent {

	class MaFenetre extends JFrame implements ActionListener
	{ 
		public MaFenetre ()
		{ 
			setTitle("Agent Expéditeur");
			setSize(250,100);
			Container contenu = getContentPane();
			contenu.setLayout(new FlowLayout() );
			
			Etiq= new JLabel ("Hallo World! My name is "+getLocalName());
			contenu.add(Etiq);	 
			boutonCalcul= new JButton("Kill");
			contenu.add(boutonCalcul);
			boutonCalcul.addActionListener(this);
			Etiq2= new JLabel ("je vais envoyer un message dans 5 s.");
			contenu.add(Etiq2);	 
			
		}

		public void actionPerformed (ActionEvent e)
		{ 
			if (e.getSource()==boutonCalcul) {
			  doDelete();
			  this.dispose();
			}//fin du if
		 
		} 

		private JButton boutonCalcul;

	} // fin de la classe MaFenetre

	protected void setup() 
	{
		MaFenetre fen= new MaFenetre();
		fen.setVisible(true);
		doWait(5000);
		addBehaviour(new EnvoiMessage());

	} // fin de setup 

	public class EnvoiMessage extends Behaviour // must implement two abstract methods: 
                                                    // action(), done() 
	{

		private boolean finished = false;

		public void action() // The action() method defines the operations to be 
                                     // performed when the behaviour is in execution.
		{
			ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
			msg.setContent("Bonjour je suis l'agent " + getLocalName());
			AID receiver = new AID("Bettaj", AID.ISLOCALNAME);
			msg.addReceiver(receiver);
			send(msg);
			finished= true;
		}

		public boolean done() // The done() method returns a boolean value 
                                      // to indicate whether or not a behaviour has completed and is to
                                      // be removed from the pool of behaviours an agent is executing.
		{
			if (finished) {
				Etiq.setText("Ca y est, le Message est envoyé !!");
				Etiq2.setText("");
				}
			return finished;
		}

	} // fin de EnvoiMessage


	public JLabel Etiq,Etiq2;

}



