package org.eclipse.om2m.ipu.sample;
 
import java.net.ServerSocket;
import java.net.Socket;
 
public class myServer extends java.lang.Thread {
 
    private boolean OutServer = false;
    private ServerSocket server;
    private final int ServerPort = 9487;// 要監控的port
    public String data = "";

    public myServer() {
        try {
            server = new ServerSocket(ServerPort);
 
        } catch (java.io.IOException e) {
            System.out.println("Socket啟動有問題 !");
            System.out.println("IOException :" + e.toString());
        }
    }
 
    public void run() {
        Socket socket;
        java.io.BufferedInputStream in;
        java.io.BufferedOutputStream out;
        System.out.println("伺服器已啟動 !");
        while (!OutServer) {
            socket = null;
            try {
                synchronized (server) {
                    socket = server.accept();
                }
                System.out.println("取得連線 : InetAddress = "
                        + socket.getInetAddress());
                // TimeOut時間
                socket.setSoTimeout(15000);
 
                out = new java.io.BufferedOutputStream(socket.getOutputStream());

                for(int i=0; i<5; i++) {
                    data = "";
                    Desk tmp = SampleMonitor.DESKS.get(Desk.TYPE+"_"+i);
                    data += String.valueOf(tmp.getState());
                    data += "," + String.valueOf(tmp.getTemperature());
                    data += "," + String.valueOf(tmp.getHeight());
                    data += "," + String.valueOf(tmp.getBright());
                    data += "," + String.valueOf(tmp.getSeatNumber());
                    data += "," + String.valueOf(tmp.getSocket()) + "\n";
                
                    out.write(data.getBytes());
                    out.flush();
                }
                out.close();
                out = null;
                socket.close();
                
            } catch (java.io.IOException e) {
                System.out.println("Socket連線有問題 !");
                System.out.println("IOException :" + e.toString());
            }
 
        }
    }

    /*public static void main(String args[]) {
        SocketServer server = new SocketServer();
        server.start();    
    }*/
}
