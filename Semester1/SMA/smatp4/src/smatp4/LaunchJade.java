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
            AgentController Service0 = mc.createNewAgent("Service0",Service.class.getName(),new Object[]{});
            Service0.start();
            AgentController Service1 = mc.createNewAgent("Service1",Service.class.getName(),new Object[]{});
            Service1.start();
            AgentController Service2 = mc.createNewAgent("Service2",Service.class.getName(),new Object[]{});
            Service2.start();
            AgentController Service3 = mc.createNewAgent("Service3",Service.class.getName(),new Object[]{});
            Service3.start();
            AgentController Searcher = mc.createNewAgent("Searcher",Searcher.class.getName(),new Object[]{});
            Searcher.start();
        }
        catch(Exception E){

        }





    }
    Runtime rt;
    static AgentContainer mc;
}

