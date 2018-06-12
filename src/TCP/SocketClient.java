package TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    Scanner input = new Scanner(System.in);
    int x =0;
    public static void main(String[] args) throws Exception {
        SocketClient client= new SocketClient();
        client.run();

    }

    private void run() throws Exception {
        Socket sock=new Socket("192.168.10.10",444);
        PrintStream PS= new PrintStream(sock.getOutputStream());
        PS.println("Hello to server!");
        while(x<100){
            System.out.print("> ");
            PS.println(input.nextLine());
        }



        InputStreamReader IR= new InputStreamReader(sock.getInputStream());

        BufferedReader BR= new BufferedReader(IR);
        String message= BR.readLine();
        System.out.println(message);
    }
}
