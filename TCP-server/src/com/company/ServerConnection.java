package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread {
    private Socket socket;
    private DataInputStream inStream;
    private DataOutputStream outStream;
    double N1=0;
    double N2=0;
    int port=0;
    Singleton singleton=Singleton.getInstance();
    //private Server server;
    public ServerConnection(Socket sok)
    {
        socket=sok;
        singleton.getMap().put(getPort(),this);
        System.out.println(singleton.getMap().keySet());
        Update();
        this.start();
    }
    public void run(){//клиент закрывается если минус -1 то удалить из мап
        try {
             inStream=new DataInputStream(socket.getInputStream());
             int close=inStream.readInt();
             if(close==-1)
             {
                 singleton.getMap().remove(getPort(),this);
                 outStream.writeInt(0);
                 System.out.println(singleton.map.keySet());
                 //inStream.close();
                 //outStream.close();
                 socket.close();
             }
            //Update();  нужно чтобы была эта строчка
            //int number=inStream.readInt();
             if(close==1)
             {
                 port=inStream.readInt();
                 N1= inStream.readDouble();
                 N2= inStream.readDouble();
                 System.out.println(port);
                 System.out.println(N1);
                 System.out.println(N2);
             }
            //socket.close();
             //outStream.write(server.getHasMap());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getPort()
    {
        return socket.getPort();
    }

    public void SendNotify()
    {
        try {
            outStream=new DataOutputStream(socket.getOutputStream());
            outStream.writeInt(singleton.getMap().size());
            for(Integer key:singleton.getMap().keySet())
                outStream.writeInt(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Update()
    {
        for(ServerConnection claind:singleton.getMap().values()) {
            //System.out.println(singleton.map.values());
            claind.SendNotify();
        }
        // map.get(key);
    }
}
