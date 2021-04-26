import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {


    public static void main(String[] args) {
        ServerSocket serveur;
        Socket socketClient;
        PrintWriter contentSended;
        Scanner scanner = new Scanner(System.in);
        System.out.print("give the equation like 52+3 or 21/3 : ");
        String st = scanner.nextLine();
        System.out.print(" *** Now go and excute the Client class *** ");


        try{
            serveur = new ServerSocket(10001);
            socketClient = serveur.accept();
            contentSended = new PrintWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            contentSended.println(st);
            contentSended.close();
        }catch (IOException e){

            System.out.println("error ");
        }
    }
}