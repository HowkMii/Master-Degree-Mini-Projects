/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smatp4;

/**
 *
 * @author acer
 */
import jade.core.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Service extends Agent {

    class MaFenetre extends JFrame implements ActionListener
    { 
        public MaFenetre ()
	{ 
            setTitle("Agent Prestataire: "+getLocalName());
            setSize(250,100);
            Container contenu = getContentPane();
            contenu.setLayout(new FlowLayout() );

            Etiq= new JLabel ("type de service");
            contenu.add(Etiq);	 
            Ts= new JTextField (15) ;
            contenu.add(Ts);
            Etiq2= new JLabel ("Nom de service");
            contenu.add(Etiq2);	
            Ns= new JTextField (15) ; // saisir nom du service
            contenu.add(Ns); 
            boutonCalcul= new JButton("Register"); // pour enregistrer le service
            contenu.add(boutonCalcul);
            boutonCalcul.addActionListener(this);
            boutonFin= new JButton("Deregister"); // pour se derengistrer
            contenu.add(boutonFin);
            boutonFin.addActionListener(this);
	}

	public void actionPerformed (ActionEvent e)
	{ 
            if (e.getSource()==boutonCalcul) 
                doWake();   // réveiller l’agent. De etat "waiting" à l'etat "actif"
                            // lors du lancement si on execute sans dowait l'agent va prendre un contenu vide
                            // on a pas encore ecrit qlq chose 
                            // doWait: l'agent attent jusqu'a reactivement avec doWake
                            // on aura le temps pour saisir les données
            else 
                doDelete();
	} 

	private JButton boutonFin,boutonCalcul;
    
    } // fin de la classe MaFenetre

    protected void setup() 
    {
        fen= new MaFenetre();
        fen.setVisible(true);  	
        // inscription au DF
        // description de agent
        // description du service fournis par l'agent
                
        DFAgentDescription dfd = new DFAgentDescription(); // description de l'agent
        dfd.setName(getAID()); // description de l'agent
        ServiceDescription sd = new ServiceDescription(); // description du service de l'agent
        //attendre l’appui sur le bouton
        doWait(); // bloquer l’agent pour saisir les données dans les zones de text 
        sd.setType(Ts.getText()); 
        sd.setName(Ns.getText()); 
        dfd.addServices(sd); // ajout le service au service
        try 
        { 
            DFService.register(this, dfd); // enregister le service au pres du DF
            // this reference l'instance de l'agent et du service
	} 
        catch (FIPAException fe) 
        { 
            fe.printStackTrace(); 
	}
        System.out.println(" Enregistrement réalisé avec succès");
    } // fin de setup 

    protected void takeDown() 
    {   // derengister button click
	// Deregister from the yellow pages 
	try { 
            DFService.deregister(this); // pour derengistrer le service du DF
	} 
	catch (FIPAException fe) { 
            fe.printStackTrace(); 
	} 
	// Close the GUI 
	fen.dispose(); 
	// Printout a dismissal message 
        System.out.println("Service-agent: " +getAID().getName()+"  terminating."); 
    
    } // fin de takeDown

    public JLabel Etiq,Etiq2;
    
    public JTextField Ts,Ns ;
    
    boolean flag=false ;
    
    MaFenetre fen;

}// fin de Service

