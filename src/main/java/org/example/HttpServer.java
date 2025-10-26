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

        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println();
        out.println("Hello client");
        clientSocket.close();

    }



}
