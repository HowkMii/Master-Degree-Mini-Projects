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
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.Profile;
import jade.wrapper.*;

public class LaunchJade {
    
    public LaunchJade(){
        
        try{
        
            rt = Runtime.instance();
            rt.setCloseVM(true);
            Profile pMain = new ProfileImpl(null,8888,null);
            System.out.println("Launching..."+ pMain);
            mc = rt.createMainContainer(pMain);
        
        }
        catch(Exception E){

        }
        
        try {
            
            AgentController agent1 = mc.createNewAgent("agent1",HalloWorldAgent2.class.getName(),new Object[]{});
            agent1.start();
            AgentController agent2 = mc.createNewAgent("agent2",HalloWorldAgent2.class.getName(),new Object[]{});
            agent2.start();
            
        }
        catch(Exception E){

        }





    }
    
    Runtime rt;
    
    static AgentContainer mc;

}
