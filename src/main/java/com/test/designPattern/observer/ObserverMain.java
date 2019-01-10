package com.test.designPattern.observer;

import java.time.LocalDateTime;

public class ObserverMain {

    public static void main(String[] args) {

        Publish p = new Publish();
        p.addObserver(new Subscribe());
        p.notifyObservers();


        Received received = new Received();
//        Received2 received2 = new Received2();
        Listener listener = new Listener();
        listener.add(received);
//        listener.add(received2);
        for (int i=0;i<=100;i++) {
            Message msg = new Message(Integer.toString(i), "向你问好");
            listener.notified(msg);
        }
        LocalDateTime notifyTime2 = LocalDateTime.now();
        System.out.println(notifyTime2);


//        Listener2 listener2 = new Listener2();
//        listener2.add(received);
//        listener2.add(received2);
//        listener2.notified("上厕所");
    }

}
