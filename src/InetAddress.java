

public class InetAddress {
    public static void main(String[] args) throws Exception {
        java.net.InetAddress ip=null;

        ip = java.net.InetAddress.getByName("www.sharesansar.com");
        System.out.println("Hostname " + ip.getHostName());
        System.out.println("IP Address " + ip.getHostAddress());

    }

}
