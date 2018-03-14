package com.degree.abbylaura.rumma_server.Server;

import android.content.Context;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by abbylaura on 18/02/2018.
 */

public class Server{


    public static void main(String[] args){
        //super();

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        int portNumber = 9002;

        try{
            serverSocket = new ServerSocket(portNumber);
            while(true) {
                try {
                    clientSocket = serverSocket.accept();
                    new ServerThreads(clientSocket).start();

                } catch (IOException e) {
                    System.err.println("IO error " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try{
                serverSocket.close();
            } catch (IOException e){
                System.out.println(e);
            }

        }
    }





}