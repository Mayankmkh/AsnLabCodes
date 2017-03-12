package com.asn.utils.socketUtils;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by mayank on 9/3/17.
 */
public class SocketServer extends BaseSocket {

    public SocketServer() {
        startSocket();
    }

    @Override
    protected void startSocket() {
        try {
            if (serverSocket == null) serverSocket = new ServerSocket(6666);
            if (socket == null) socket = serverSocket.accept();
            super.startSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeSocket() {
        try {
            super.closeSocket();
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
