package JavaNetworkProgramming;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {

    public final static int PORT = 13;

    public static void main(String[] args) {

        //Creates a socket
        try (ServerSocket server = new ServerSocket(PORT)) {
            //iterative server,a loop is used as server
            //should be ready to handle next incoming connection
            while (true) {
                //accept a connection
                //Program stops here and waits for a client to connect
                try (Socket connection = server.accept()) {

                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();

                    out.write(now.toString() + "\r\n");
                    out.flush();
                    connection.close();
                } catch (IOException ex) {//finds issues within the connection
                }
            }
        } catch (IOException ex) {//finds issues with connection
            System.err.println(ex);
        }
    }
}

