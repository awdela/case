package com.test.io.nio;

import java.io.IOException;

public class TimeServer {

    public static void main(String[] args) throws IOException{
        int port = 8080;
        MutiplexerTimeServer timeServer = new MutiplexerTimeServer(port);
        new Thread(timeServer, "nio-MutiplexerTimeServer").start();;
    }

}
