import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class UDPServerTest {

    private static int counta(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == 'a')
                count++;
        return count;
    }

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData()).trim();

            System.out.println("FROM CLIENT:" + sentence);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = "" + counta(sentence) + "," + sentence.length();

            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);
        }
    }
}
