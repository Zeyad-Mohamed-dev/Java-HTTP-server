package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HttpServer {
    private ServerSocket serverSocket;
    private final static int port = 4100;
    private PrintWriter out;
    private BufferedReader in;
    private boolean listening = true;
    public HttpServer() throws IOException {

        serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        System.out.println(in.readLine());

        getMehtod(in.readLine(), out);
        clientSocket.close();
    }


    public void getMehtod(String reqString, PrintWriter out) {
        String method = reqString.substring(0, reqString.indexOf(" "));
        System.out.println(method);
        if (method.equals("GET")) {
            //header
            out.println("HTTP/1.1 200 ok");
            out.println("Content-Type: text/plain");
            out.println();
            //body
            out.println("Allowed get request");
        } else  {
            out.println("HTTP/1.1 403 Forbidden");
            out.println("Content-Type: text/plain");
            out.println();
            out.println("Not allowed request");
        }
    }

}
