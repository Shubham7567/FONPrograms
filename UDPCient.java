import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets; 

public class UDPCient {
    public static void main(String[] args)throws Exception
    {
        BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] recieveData = new byte[1024];
        byte[] sendData = new byte[1024];
        String sentance = "";
        while(!sentance.equals("bye"))
        {
            sentance = inFromUSer.readLine();
            InetAddress Address = InetAddress.getLocalHost();
            sendData = sentance.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,Address,9876);
            clientSocket.send(sendPacket);
        }
        clientSocket.close();
    }
}
