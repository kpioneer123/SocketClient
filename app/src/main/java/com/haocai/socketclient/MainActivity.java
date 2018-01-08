package com.haocai.socketclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String SERVER_IP = "192.168.90.221";
    public static final int SERVER_PORT = 9998;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    public void startSocket(View v){
        new Thread(new Runnable() {

            @Override
            public void run() {
                SocketUtil socketUtil = new SocketUtil();
                socketUtil.startClient(SERVER_IP,SERVER_PORT);
            }
        }).start();
    }
}
