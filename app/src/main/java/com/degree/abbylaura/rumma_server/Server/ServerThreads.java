package com.degree.abbylaura.rumma_server.Server;

/**
 * Created by abbylaura on 18/02/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreads extends Thread{

    private Socket clientSocket;

    public ServerThreads(Socket clientSocket){
        super();
        this.clientSocket = clientSocket;
    }

    public void run(){
        try {
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter outToClient =
                    new PrintWriter(clientSocket.getOutputStream(), true);

            String in = inFromClient.readLine();
            System.out.println(in);
            String out = in + " | ";

            outToClient.println(out);


            clientSocket.close();
            return;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                clientSocket.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}