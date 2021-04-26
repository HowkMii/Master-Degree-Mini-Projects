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
            
            AgentController ReceivAgent = mc.createNewAgent("Bettaj",ReceivAgent.class.getName(),new Object[]{});
            ReceivAgent.start();
            AgentController ComAgent = mc.createNewAgent("Ali",ComAgent.class.getName(),new Object[]{});
            ComAgent.start();
            
        }
        catch(Exception E){

        }





    }
    
    Runtime rt;
    
    static AgentContainer mc;

}

