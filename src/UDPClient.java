import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("The Client is starting");
            System.out.println();
            DatagramSocket socket = new DatagramSocket();
            System.out.print("Enter your message: ");
            Scanner input = new Scanner(System.in);
            String requestMessage = input.nextLine();

            byte[] requestbyte = requestMessage.getBytes();
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            DatagramPacket requestpacket = new DatagramPacket(requestbyte, requestbyte.length, serverAddress, 7500);

            socket.send(requestpacket);
            byte[] responsebuffer = new byte[256];
            DatagramPacket responsepacket = new DatagramPacket(responsebuffer, responsebuffer.length);

            socket.receive(responsepacket);
            String responsemessage = new String(responsebuffer, 0, responsepacket.getLength());

            System.out.println("Server Response: " + responsemessage);
            socket.close();
        } catch (SocketException ex){
            ex.printStackTrace();
        }
    }
}
