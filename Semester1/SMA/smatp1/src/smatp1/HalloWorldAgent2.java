
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smatp1;

/**
 *
 * @author acer
 */
import jade.core.Agent;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;


public class HalloWorldAgent2 extends Agent {
    
    class MaFenetre extends JFrame implements ActionListener
    { 
        public MaFenetre ()
        { 
            setTitle("Agent Helloworld");
            setSize(200,100);
            Container contenu = getContentPane();
            contenu.setLayout(new FlowLayout() );
            Etiq= new JLabel ("Hallo World! My name is " + getLocalName());
            contenu.add(Etiq);
            boutonCalcul= new JButton("Fermer");
            contenu.add(boutonCalcul);
            boutonCalcul.addActionListener(this);
        }
        
        public void actionPerformed (ActionEvent e)
        { 
            if (e.getSource() == boutonCalcul){
                doDelete(); // make an agent terminate
                this.dispose();
            }// fin du if
        } 

        private JLabel Etiq;

        private JButton boutonCalcul;
        
    } // fin de la classe MaFenetre
    
    protected void setup() // The setup() method is intended to include agent initializations
            // Examples of typical operations that an agent performs in its setup() method are: 
            //      showing a GUI, 
            //      opening a connection to a database, 
            //      registering the services it provides in the yellow pages catalogue
            //      and starting the initial behaviours. 
            // It is good practice not to define any constructor in an agent class and to 
            // perform all initializations inside the setup() method. This is because at
            // construction time the agent is not yet linked to the underlying 
            // JADE run-time and thus some of the methods inherited from the Agent 
            // class may not work properly.
    {
        
        MaFenetre fen= new MaFenetre();
        
        fen.setVisible(true);
        
        System.out.println("Hello World. I’m an agent!");
        System.out.println("My local-name is "+getLocalName());
        System.out.println("My AID local-name is "+getAID().getLocalName());
        System.out.println("My AID is "+getAID());
        System.out.println("My GUID is "+getAID().getName());
        System.out.println("My addresses are:");
        Iterator it = getAID().getAllAddresses();
        while (it.hasNext()) {
            System.out.println("- "+it.next());
        }
        
    }
    
    protected void takeDown() // is invoked just before an agent terminates 
                              // in order to perform various clean-up operations
    {
        doDelete();
    }
}