/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahttp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author qukev
 */
public class JavaHTTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try(Socket socket = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n"+today;
                String printScreen = "\nHello, this is a short demonstration of HTTP servers in Java";
                String githubLink = "\nThe link to the Github gist can be found at: https://github.com/fishingguy456/Code-in-Java-HTTP";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                socket.getOutputStream().write(printScreen.getBytes("UTF-8"));
                socket.getOutputStream().write(githubLink.getBytes("UTF-8"));
            }
        }
    }

}
