package com.degree.abbylaura.rumma_server.Server;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.degree.abbylaura.rumma_server.App.App;
import com.degree.abbylaura.rumma_server.Database.Data.DatabaseHelper;
import com.degree.abbylaura.rumma_server.Database.Data.DatabaseManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by abbylaura on 18/02/2018.
 */

public class Server extends IntentService{

    // Used to identify when the IntentService finishes
    public static final String TRANSACTION_DONE = "TRANSACTION_DONE";

    // Validates resource references inside Android XML files
    public Server() {
        super(Server.class.getName());
    }

    public Server(String name) {
        super(name);
        System.out.println("2: Server constructor");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("3: Server onHandleIntent");

        NestedServer nServer = new NestedServer();
        nServer.talkToClient();

        Intent i = new Intent(TRANSACTION_DONE);
        Server.this.sendBroadcast(i);
    }

    public class NestedServer{

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        int portNumber = 9000;

        public NestedServer(){
            super();
            System.out.println("4: NestedServer constructor");

        }

        public void talkToClient(){
            System.out.println("5: NestedServer talkToClient");

            try{
                System.out.println("6: NestedServer talkToClient try block");

                serverSocket = new ServerSocket(portNumber);

                System.out.println("7: server socket created");

                while(true) {
                    try {
                        System.out.println("8: NestedServer talkToClient -> try -> whule -> try");

                        clientSocket = serverSocket.accept();
                        System.out.println("9: NestedServer serverSocket.accept");


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





}