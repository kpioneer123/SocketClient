package com.haocai.socketclient;

/**
 * Created by Xionghu on 2018/1/8.
 * Desc:
 */

public class SocketUtil {
    public native void startClient(String serverIp,int serverPort);

    static {
        System.loadLibrary("socketlib");
    }

}
