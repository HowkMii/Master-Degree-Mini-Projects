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
import jade.core.behaviours.TickerBehaviour;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Searcher extends Agent {

    class MaFenetre extends JFrame implements ActionListener
    { 
        public MaFenetre ()
	{ 
            setTitle("Agent Client: "+getLocalName());
            setSize(250,100);
            Container contenu = getContentPane();
            contenu.setLayout(new FlowLayout() );
            Etiq= new JLabel ("type de service");
            contenu.add(Etiq);	 
            Ts= new JTextField (15) ; // on chercher le service
            contenu.add(Ts);
            boutonCalcul= new JButton("Search");
            contenu.add(boutonCalcul);
            boutonCalcul.addActionListener(this);
            boutonFin= new JButton("Kill");
            contenu.add(boutonFin);
            boutonFin.addActionListener(this); 
	} // fin du constructeur
	
        public void actionPerformed (ActionEvent e)
	{ 
            if (e.getSource()==boutonCalcul) doWake(); //active l’agent après un doWait()
            else doDelete();
	} 
	
        private JButton boutonFin,boutonCalcul;
	
    } // fin de la classe MaFenetre
	
    protected void setup() 
    {
	fen= new MaFenetre();
        fen.setVisible(true);
        doWait(); // suspendre l’agent pour prendre le temps d’écrire dans les zones de texte
	// Ajouter un TickerBehaviour pour chercher  les agents proposant le service demandé toutes les  10 seconds
	addBehaviour(new TickerBehaviour(this, 10000) 
        { 
            // pour chercher le service on utilise tickerbehavior 
            // execute une tache toute les 10 second (10000)
            protected void onTick() 
            {
		// Mise à jour de la liste des agents service
                // executé tout les 10 second
		DFAgentDescription template = new DFAgentDescription(); // pour faire la recherche 
		ServiceDescription sd = new ServiceDescription(); //
		sd.setType(Ts.getText()); // type de service saisit dans textField
		template.addServices(sd); // chercher la description du service et non pas de l'agent
		try 
                {
                    DFAgentDescription[] result = DFService.search(myAgent,template); // search pour faire la recherche
                    // result: tableau de description d'agents qui fournissent le service recherché
                    // tableau de DFAgentDescription
                    ServiceAgents = new AID[result.length]; 
                    // depuis le tableau result on prende seulement les ID des Agents
                    // car on a besoins seulement de l'id de l'agent
                    // on peut contacter l'agent car on a son ID
                    System.out.println("----------------------- Les agents proposant ce service sont------------------- -------");
                    for (int i = 0; i < result.length; ++i) 
                    {   
                        // pour faire le transfert depuis result a ServiceAgents
                        ServiceAgents[i] = result[i].getName();
                        System.out.println(result[i].getName());
                        while(result[i].getAllServices().hasNext())
                        {
                            System.out.println(result[i].getAllServices().next().toString());
                        }
                    }
              
                    if(result.length==0)
                        System.out.println("Aucun agent ne propose ce service pour le moment."); 
		}
		catch (FIPAException fe) {
                    fe.printStackTrace();
		}
            } // fin de la method onTick
	}
        );
    }// fin de setup
	
    protected void takeDown() // executé lors du click sur le bouton kill
    {
	// Close the GUI 
	fen.dispose(); // cacher la fenetre
	// Printout a dismissal message 
	System.out.println("Service-agent: " +getAID().getName()+" terminating."); 	
    } // fin de takeDown
    
    public JLabel Etiq;
    
    public JTextField Ts ;
    
    MaFenetre fen;
    
    // The list of agents that propose the service
    private AID[] ServiceAgents;

}// fin de la classe searcher
