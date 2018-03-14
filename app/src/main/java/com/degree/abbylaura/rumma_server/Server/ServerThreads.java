package com.degree.abbylaura.rumma_server.Server;

/**
 * Created by abbylaura on 18/02/2018.
 */

import com.degree.abbylaura.rumma_server.Database.Repo.NoticeRepo;
import com.degree.abbylaura.rumma_server.Database.Schema.Notice;

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
        System.out.println("10: ServerThreads Constructor");

    }

    public void run(){
        try {
            System.out.println("11: ServerThreads run");

            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter outToClient =
                    new PrintWriter(clientSocket.getOutputStream(), true);

            String in = inFromClient.readLine();
            System.out.println(in);
            String out = in + " | ";

            System.out.println("12: ServerThreads in = " + in);


            outToClient.println(out);

            System.out.println("13: ServerThreads out = " + out);


            /*NoticeRepo noticeRepo = new NoticeRepo();
            Notice notice = new Notice();
            notice.setMemberId("0100"); //for testing
            notice.setDate("01/01/1991");
            notice.setContents(in);
            noticeRepo.insert(notice);*/


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