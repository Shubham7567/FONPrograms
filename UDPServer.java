import java.net.*;
import java.nio.charset.StandardCharsets; 

class UDPServer
{
    public static int CountA(String sentance)
    {
        int count = 0;
        for (int i = 0; i < sentance.length(); i++)
            if (sentance.charAt(i) == 'a')
                count++;
        return count;
    }
    public static void main(String[] args) throws Exception
    {
        DatagramSocket serveSocket = new DatagramSocket(9876);
        byte[] recieveData = new byte[1024];
        byte[] sendData = new byte[1024];
        String sentance="";
        do
        {
            DatagramPacket recievePackate = new DatagramPacket(recieveData, recieveData.length);
            serveSocket.receive(recievePackate); 
            recieveData = new byte[1024];
            System.out.println("Data from Client : "+sentance);
            System.out.println("Total accurance of a in Data : "+ CountA(sentance));
            System.out.println("Data length from Client : "+sentance.length());
            // InetAddress Address = recievePackate.getAddress();
            // int port = recievePackate.getPort();
            // String capitalizedSentance = sentance.toUpperCase();
            // sendData = capitalizedSentance.getBytes();
            // DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,Address,port);
            // serveSocket.send(sendPacket);
        }while(!sentance.equals("bye"));
    }
}