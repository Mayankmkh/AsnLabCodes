package com.asn.utils.socketUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by mayank on 9/3/17.
 */
public class SocketClient extends BaseSocket {

    public SocketClient() {
        startSocket();
    }

    protected void startSocket() {
        try {
            if (socket == null) socket = new Socket("localhost", 6666);
            super.startSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
