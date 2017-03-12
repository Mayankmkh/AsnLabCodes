package com.asn.utils.socketUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mayank on 9/3/17.
 */
public class BaseSocket {

    ServerSocket serverSocket;
    Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    protected void startSocket() {
        try {
            if (dataOutputStream == null) dataOutputStream = new DataOutputStream(socket.getOutputStream());
            if (dataInputStream == null) dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(String data) {
        try {
            dataOutputStream.writeUTF(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(int data) {
        try {
            dataOutputStream.writeInt(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString() {
        try {
            return dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getInt() {
        try {
            return dataInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeSocket() {
        try {
            if (dataOutputStream != null) {
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            if (dataInputStream != null) dataInputStream.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
