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

        getMehtod(in.readLine(), out);
        clientSocket.close();
    }


    public void getMehtod(String reqString, PrintWriter out) {
        String method = reqString.substring(0, reqString.indexOf(" "));
        HttpResponse response = new HttpResponse();
        System.out.println(method);
        if (method.equals("GET")) {
            response.writeOkResponse(out, "Allowed method: GET");
        } else  {
            response.writeErrorResponse(out, 500, "Method not supported yet");
        }
    }

}
