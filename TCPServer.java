import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String capitalizedSentence; 

      ServerSocket welcomeSocket = new ServerSocket(6789); 
  
      while(true) { 
  
            Socket connectionSocket = welcomeSocket.accept(); 

           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream())); 


           DataOutputStream  outToClient = 
             new DataOutputStream(connectionSocket.getOutputStream()); 

           clientSentence = "" + inFromClient.readLine().length() + '\n'; 
          System.out.println(clientSentence);
          clientSentence = "The length is " + clientSentence;
           capitalizedSentence = clientSentence; 

           outToClient.writeBytes(clientSentence + '\n'); 
        } 
    } 
} 
 
