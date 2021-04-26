import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import java.net.*;
import java.io.*;

import java.util.*;


public class client {

    public static void main (String[] args){

        BufferedReader ain;

        Socket soc;

        Socket soc_;

        ServerSocket server_;

        PrintWriter aout_;

        try {

            Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
            System.out.print("Entrer le premier nombre:");
            int aa= sc.nextInt();
            System.out.print("Entrer le second nombre: ");
            int bb= sc.nextInt();
            System.out.print("Enter the operator: ");
            char cc = sc.next().charAt(0);

            server_ = new ServerSocket(10001);

            soc_ = server_.accept();

            aout_ = new PrintWriter(new OutputStreamWriter(soc_.getOutputStream()));

            aout_.print(aa);

            aout_.print(cc);

            aout_.print(bb);

            aout_.close();


            soc = new Socket("192.168.43.68", 10000);

            ain = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            String a = null;

            while(a == null){
                a = ain.readLine();
                System.out.println(a);
            }


        }catch(IOException e){
            System.out.println(" impossible de se connecter à l'hote ");
            System.exit(1);
        }

        System.out.println("Fin");



    }


}