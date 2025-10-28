package org.example;

import java.io.PrintWriter;

public class HttpResponse {

    public void writeOkResponse(PrintWriter out, String body) {
        out.println("HTTP/1.1 200 ok");
        out.println("Content-Type: text/plain");
        out.println();
        out.println(body);
    }

    public void writeErrorResponse(PrintWriter out, int code ,String body) {
        out.println("HTTP/1.1 " + code + " " + "Internal Server Error");
        out.println("Content-Type: text/plain");
        out.println();
        out.println(body);
    }
}
