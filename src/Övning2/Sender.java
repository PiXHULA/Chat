package Övning2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Sender {



    public static void main(String[] args) throws IOException, InterruptedException {


        ///BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //InetAddress toAdr = InetAddress.getLocalHost();
        //InetAddress toAdr = InetAddress.getByName("172.20.201.157"); - Hugos
        //InetAddress toAdr = InetAddress.getByName("172.20.202.56"); - Willes
        //InetAddress toAdr = InetAddress.getByName("172.20.202.126");
        /*
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        String message = "I SEE YOU..";
        String message2 = "Almost there...";
        String message3 = "You sleep now!";

        while(true){
            byte[] data1 = message.getBytes();
            byte[] data2 = message2.getBytes();
            byte[] data3 = message3.getBytes();
            DatagramPacket packet = new DatagramPacket(data1, data1.length, toAdr, toPort);
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, toAdr, toPort);
            DatagramPacket packet3 = new DatagramPacket(data3, data3.length, toAdr, toPort);
            socket.send(packet);
            Thread.sleep(2000);
            socket.send(packet2);
            Thread.sleep(4000);
            socket.send(packet3);
            Thread.sleep(6000);
        }
        //System.exit(0);

         */


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //InetAddress toAdr = InetAddress.getLocalHost();
        InetAddress toAdr = InetAddress.getByName("172.20.202.126");
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        String message;
        System.out.println("?: ");
        while((message = input.readLine()) != null){
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            System.out.println("?: ");
        }
        System.exit(0);

    }
}
